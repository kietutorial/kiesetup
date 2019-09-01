package com.hcentive.utils.web.csrf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hx.services.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hcentive.utils.Constants;
import com.hcentive.utils.ext.HXUtility;

/**
 * A Spring MVC <code>HandlerInterceptor</code> which is responsible to enforce
 * CSRF token validity on incoming posts requests. The interceptor should be
 * registered with Spring MVC servlet using the following syntax:
 * 
 * <pre>
 * &lt;mvc:interceptors&gt; &lt;bean class="com.eyallupu.blog.springmvc.controller.csrf.CSRFHandlerInterceptor"/&gt;
 * &lt;/mvc:interceptors&gt;
 * </pre>
 * 
 * @see CSRFRequestDataValueProcessor
 */
public class CSRFHandlerFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(CSRFHandlerFilter.class);

	private List<String> urlsToIgnore;
	
	private List<String> urlsAllowed;
	
	private String samlUriAllowed;
	
	private String env;

	@Override
	protected void initFilterBean() throws ServletException {
		FilterConfig filterConfig = this.getFilterConfig();
		String excludeURLString = filterConfig.getInitParameter("urlsToIgnore");
		urlsToIgnore = new ArrayList<String>();
		if (StringUtils.hasText(excludeURLString)) {
			urlsToIgnore.addAll(Arrays.asList(excludeURLString.split(",")));
		}
		
		boolean refFound = true;
		String urlsAllowedString = null;
		String samlUriAllowedString = null;
		
		try {
			Hashtable environment = new Hashtable();
			environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context ctx = new InitialContext(environment);
			Object object = ctx.lookup("ref/HxProperties");
			Config config = (Config) object;
			urlsAllowedString = (String) config.getAttribute("urlsAllowed");
			samlUriAllowedString = (String) config.getAttribute("samlUriAllowed");
		} catch (NamingException e) {
			refFound = false;
		}
		if (!refFound) {
			env = System.getProperty("hxEnvironment");
			urlsAllowedString = System.getProperty("urlsAllowed");
			samlUriAllowedString = System.getProperty("samlUriAllowed");
			if (HXUtility.isNull(env)) {
				urlsAllowedString = System.getenv("urlsAllowed");
				samlUriAllowedString = System.getenv("samlUriAllowed");
			}
		}
		if (!HXUtility.isEmpty(urlsAllowedString)) {
			this.setUrlsAllowed(Arrays.asList(urlsAllowedString.split(",")));
		}
		if(!HXUtility.isEmpty(samlUriAllowedString)){
			this.setSamlUriAllowed(samlUriAllowedString);
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!request.getMethod().equalsIgnoreCase("POST")) {
			// Not a POST - allow the request
			filterChain.doFilter(request, response);
			return;
		}
		// This is a POST request - need to check the CSRF token
		String sessionToken = CSRFTokenManager.getTokenForSession(request.getSession());
		String requestToken = CSRFTokenManager.getTokenFromRequest(request);
		//if (sessionToken.equals(requestToken)) {
		String referrer = request.getHeader("Referer");
		String uri = request.getRequestURI();
		if(!HXUtility.isNull(referrer) && (checkURLAllowed(referrer))){
			filterChain.doFilter(request, response);
			return;
		} else if(HXUtility.isNull(referrer)){
			logger.info("Referer is Null. Checking for URI.");
			if ((!HXUtility.isNull(uri) && uri.endsWith(this.getSamlUriAllowed()))){
				filterChain.doFilter(request, response);
				return;
			}
		} 
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad or missing CSRF value");
		logger.debug("Bad or missing CSRF value");
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String requestUrl = request.getRequestURI();
		for (String urlToIgnore : urlsToIgnore) {
			if (requestUrl.contains(urlToIgnore)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkURLAllowed(String referrer){
		boolean urlAllowed = false;
		
		for(String url : this.urlsAllowed){
			if(referrer.startsWith(url)){
				urlAllowed = true;
				break;
			}
		}
		
		return urlAllowed;
	}
	
	public List<String> getUrlsAllowed() {
		return urlsAllowed;
	}

	public void setUrlsAllowed(List<String> urlsAllowed) {
		this.urlsAllowed = urlsAllowed;
	}

	public String getSamlUriAllowed() {
		return samlUriAllowed;
	}

	public void setSamlUriAllowed(String samlUriAllowed) {
		this.samlUriAllowed = samlUriAllowed;
	}

}
