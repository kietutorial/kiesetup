package com.hcentive.utils.web.csrf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * A Spring MVC <code>HandlerInterceptor</code> which is responsible to enforce
 * CSRF token validity on incoming posts requests. The interceptor should be
 * registered with Spring MVC servlet using the following syntax:
 * 
 * <pre>
 * &lt;mvc:interceptors&gt;
 * &lt;/mvc:interceptors&gt;
 * </pre>
 * 
 * @see CSRFRequestDataValueProcessor
 */
@Deprecated
public class CSRFHandlerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CSRFHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!request.getMethod().equalsIgnoreCase("POST")) {
			// Not a POST - allow the request
			return true;
		}
		// This is a POST request - need to check the CSRF token
		String sessionToken = CSRFTokenManager.getTokenForSession(request.getSession());
		String requestToken = CSRFTokenManager.getTokenFromRequest(request);
		if (sessionToken.equals(requestToken)) {
			return true;
		}
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad or missing CSRF value");
		logger.debug("Bad or missing CSRF value");
		return false;
	}
}
