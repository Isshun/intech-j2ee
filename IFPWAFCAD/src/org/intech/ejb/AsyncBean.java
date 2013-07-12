package org.intech.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class AsyncBean
 */
@Singleton
@Asynchronous
public class AsyncBean {

	@Asynchronous
	public void ignoreResult(int a, int b) {
		
	}

	@Asynchronous
	public Future<Integer> longProcesing(int a, int b) throws InterruptedException {
		Thread.sleep(5);
		return new AsyncResult<Integer>(a + b);
	}

}
