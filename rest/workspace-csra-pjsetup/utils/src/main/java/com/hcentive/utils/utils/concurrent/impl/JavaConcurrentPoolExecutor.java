/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils.concurrent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.utils.command.Handler;
import com.hcentive.utils.utils.concurrent.ParallelExecutor;

/**
 * Thic class implements the ParallelExecutor interface using the methods in
 * java.util.concurrent.
 * 
 * @author ashish.jaiswal
 * 
 * @param <Request>
 * @param <Response>
 */
public class JavaConcurrentPoolExecutor<Request, Response> implements ParallelExecutor<Request, Response> {

	private static Logger logger = LoggerFactory.getLogger(JavaConcurrentPoolExecutor.class);

	public static final int MAX_POOL_SIZE = 100;
	public static final int DEFAULT_TIMEOUT_IN_SEC = 20;

	protected ExecutorService executorService;
	private int timeoutInSeconds = DEFAULT_TIMEOUT_IN_SEC;
	private int maxPoolSize = 0;
	private boolean executorServiceInitialized = false;

	private List<Callable<Response>> executorCommandToCallable(List<Request> allRequests,
			List<? extends Handler<Request, Response>> allCommands) {
		List<Callable<Response>> allCallables = new ArrayList<Callable<Response>>();
		for (int i = 0; i < allRequests.size(); i++) {
			Request r = allRequests.get(i);
			Handler<Request, Response> c = allCommands.get(i);
			allCallables.add(new CallableAdapter<Request, Response>(r, c));
		}
		return allCallables;
	}

	private List<Response> getResponseFromFuture(List<Future<Response>> allFutures) throws Exception {
		List<Response> responses = new ArrayList<Response>();
		for (Future<Response> f : allFutures) {
			if (!f.isCancelled()) {
				responses.add(f.get());
			}
		}
		return responses;
	}

	/**
	 * Executes multiple requests concurrently using ExecutorService in
	 * java.util.concurrent.
	 * 
	 * @see com.hcentive.utils.utils.concurrent.ParallelExecutor#execute(java.util.List)
	 */
	@Override
	public List<Response> execute(List<Request> allRequests, List<? extends Handler<Request, Response>> allCommands)
			throws Exception {
		List<Callable<Response>> allCallables = executorCommandToCallable(allRequests, allCommands);
		List<Future<Response>> allFutures = getExecutorService().invokeAll(allCallables, timeoutInSeconds, TimeUnit.SECONDS);
		return getResponseFromFuture(allFutures);
	}

	@Override
	public List<Response> execute(List<Request> allRequests, List<? extends Handler<Request, Response>> allHandlers,
			com.hcentive.utils.utils.concurrent.ParallelExecutor.Priority[] requestPriority) throws Exception {

		Assert.assertNotNull("allRequests List cannot be null", allRequests);
		Assert.assertNotNull("allHandlers List cannot be null", allHandlers);
		Assert.assertNotNull("requestPriority List cannot be null", requestPriority);
		Assert.assertTrue("Size of Requests and Handlers must be same", allRequests.size() == allHandlers.size());
		Assert.assertTrue("Size of Requests and priorities must be same", allRequests.size() == requestPriority.length);

		// List<Request> priorityRequests = new ArrayList<Request>();
		List<Request> normalRequests = new ArrayList<Request>();
		// List<Handler<Request, Response>> priorityHandlers = new
		// ArrayList<Handler<Request, Response>>();
		List<Handler<Request, Response>> normalHandlers = new ArrayList<Handler<Request, Response>>();

		int index = 0;
		ExecutorService ex = getExecutorService();
		List<Future<Response>> prioritytFutures = new ArrayList<Future<Response>>();
		List<Future<Response>> normalFutures = new ArrayList<Future<Response>>();
		for (Priority p : requestPriority) {
			if (p == Priority.Y) {
				Callable<Response> c = new CallableAdapter<Request, Response>(allRequests.get(index), allHandlers.get(index));
				prioritytFutures.add(ex.submit(c));
			} else {
				normalRequests.add(allRequests.get(index));
				normalHandlers.add(allHandlers.get(index));
			}
			index++;
		}
		// Execute the normal threads with timeout
		if (normalRequests.size() > 0) {
			List<Callable<Response>> allCallables = executorCommandToCallable(normalRequests, normalHandlers);
			normalFutures = ex.invokeAll(allCallables, timeoutInSeconds, TimeUnit.SECONDS);
		}
		// Collate the responses
		List<Response> responses = new ArrayList<Response>();
		if (prioritytFutures.size() > 0) {
			responses.addAll(getResponseFromFuture(prioritytFutures));
		}
		if (normalRequests.size() > 0) {
			responses.addAll(getResponseFromFuture(normalFutures));
		}
		return responses;
	}

	@Override
	public void executeAsync(List<Request> allRequests, List<? extends Handler<Request, Response>> allHandlers,
			Vector<Response> aggregatedResult) throws Exception {

		if (aggregatedResult == null) {
			throw new Exception("Aggregated result cannot be null!!!");
		}
		ExecutorService ex = getExecutorService();

		for (int i = 0; i < allRequests.size(); i++) {
			Request r = allRequests.get(i);
			Handler<Request, Response> c = allHandlers.get(i);
			ex.execute(new RunnableAdapter<Request, Response>(r, c, aggregatedResult));
		}
	}

	public int getTimeoutInSeconds() {
		return timeoutInSeconds;
	}

	@Override
	public void setTimeoutInSeconds(int timeOutInSeconds) {
		this.timeoutInSeconds = timeOutInSeconds;
	}

	protected ExecutorService getExecutorService() {
		if (executorService != null) {
			return executorService;
		}
		return createDefaultExecutor();
	}

	protected synchronized ExecutorService createDefaultExecutor() {
		executorServiceInitialized = true;
		if (maxPoolSize == 0) {
			maxPoolSize = MAX_POOL_SIZE;
		}
		return executorService = Executors.newFixedThreadPool(maxPoolSize);
	}

	public void setExecutorService(ExecutorService e) {
		executorService = e;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	/**
	 * Sets the maximum # threads in the pool. Defaults to
	 * {@value #MAX_POOL_SIZE}.
	 * 
	 * @param threadPoolSize
	 */
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	/**
	 * Use this to shutdown the parallel connector. Useful in this case if this
	 * class created the executor Service, it shuts it down.
	 */
	public void destroy() {
		if (!executorServiceInitialized) {
			return;
		}
		if (executorService != null) {
			executorService.shutdown();
		}
		executorServiceInitialized = false;
		executorService = null;
	}

	public static class RunnableAdapter<Request, Response> implements Runnable {
		private Request request;
		private Handler<Request, Response> command;
		private List<Response> aggregatedResult;

		public RunnableAdapter(Request request, Handler<Request, Response> command, List<Response> r) {
			this.request = request;
			this.command = command;
			this.aggregatedResult = r;
		}

		@Override
		public void run() {
			try {
				aggregatedResult.add(command.execute(request));
			} catch (Exception e) {
				logger.error("Exception: ", e);
			}
		}
	}

	/**
	 * An adapter between ExecutorCommand and the Callable interface mandated by
	 * the methods of java.util.concurrent.
	 * 
	 * @param <Request>
	 * @param <Response>
	 */
	private static class CallableAdapter<Request, Response> implements Callable<Response> {
		private Request req;
		private Handler<Request, Response> command;

		public CallableAdapter(Request req, Handler<Request, Response> command) {
			this.req = req;
			this.command = command;
		}

		@Override
		public Response call() throws Exception {
			return command.execute(req);
		}
	}
}
