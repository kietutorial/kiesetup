/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils.concurrent;

import java.util.List;
import java.util.Vector;

import com.hcentive.utils.command.Handler;

/**
 * This interface captures implementations that take on a list of requests and
 * execute them in parallel using a {@link Handler} (that is explicitly passed
 * with each request or passed upfront and used for every request- see the
 * execute methods below)
 * 
 * @author ashish.jaiswal
 * 
 * @param <Request>
 * @param <Response>
 */
public interface ParallelExecutor<Request, Response> {

	enum Priority {
		Y, N
	}

	/**
	 * Sets the timeout interval in seconds after which the request will
	 * timeout. Defaults to {@link #DEFAULT_TIMEOUT} whose value is set to
	 * {@value #DEFAULT_TIMEOUT}
	 * 
	 * @param timeout
	 */
	public abstract void setTimeoutInSeconds(int timeout);

	/**
	 * Executes the requests using the handlers. Returns all the responses which
	 * are returned within the given timeout.
	 * 
	 * @param allRequests
	 * @param allHandlers
	 * @return
	 * @throws Exception
	 */
	public abstract List<Response> execute(List<Request> allRequests, List<? extends Handler<Request, Response>> allHandlers)
			throws Exception;

	/**
	 * Executes the requests using the handlers. Returns all the responses for
	 * the requests which are of priority(timeout is not applicable for these
	 * requests) and which are returned within the given timeout along. Count of
	 * request must be equal to count of handlers and priority count.
	 * 
	 * @param allRequests
	 * @param allHandlers
	 * @param requestPriority
	 *            - Priority array for the request. Request with Priority = Y
	 *            are processed irrespective of timeout.
	 * @return
	 * @throws Exception
	 */
	public abstract List<Response> execute(List<Request> allRequests, List<? extends Handler<Request, Response>> allHandlers,
			Priority[] requestPriority) throws Exception;

	/**
	 * Triggers execution of requests asynchronously. Handlers are responsible
	 * for updating the response asynchronously back.
	 * 
	 * @param allRequests
	 * @param allHandlers
	 * @throws Exception
	 */
	public abstract void executeAsync(List<Request> allRequests, List<? extends Handler<Request, Response>> allHandlers,
			Vector<Response> aggregatedResponse) throws Exception;

}
