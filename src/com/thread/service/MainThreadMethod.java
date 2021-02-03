package com.thread.service;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 处理在执行器中被拒绝的任务
 *
 * 我们使用shutdown方法来关闭执行器，但是如果当前有正在执行的任务，执行器会等待任务执行完成才会关闭。
 * 但这个时候执行器已经不再接受任何任务了，我们发送任务给执行器会被拒绝。
 * ThreadPoolExecutor提供了一套机制了处理这些被拒绝的任务。
 *
 * 我们定义了一个执行器拒绝任务RejectedTaskController.
 * 在方法rejectedExecution(Runnable r, ThreadPoolExecutor executor)中处理被拒绝的任务。
 *
 * 需要通过执行器的setRejectedExecutionHandler(controller)方法来给执行器设置决绝任务处理器类。
 *
 * 当有任务发送给处理器的时候，会检查处理器是否被shutdown，如果shutdown那么就会调用拒绝任务处理器。
 * 如果没有定义这个拒绝任务处理器，那么就会抛出RejectedExecutionException异常。
 *
 * Created by shaoqf on 2019/9/28
 */
public class MainThreadMethod {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		RejectedTaskController controller = new RejectedTaskController();
		
		threadPoolExecutor.setRejectedExecutionHandler(controller);
		
		for(int i=0;i<3;i++){
			Task eTask = new Task("Task任务===："+i);
			System.out.println("111====");

			threadPoolExecutor.submit(eTask);
					
		}
		System.out.println("222====");
		threadPoolExecutor.shutdown();
		
		Task dTask = new Task("RejectTask===");
		System.out.println("11666====");
		threadPoolExecutor.submit(dTask);
		//threadPoolExecutor.shutdown();

		System.out.println("114====");
	}

}
