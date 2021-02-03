package com.thread.service;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//首先实现自定义的拒绝任务处理逻辑，继承RejectedExecutionHandler，并实现rejectedExecution方法。
//创建执行器拒绝任务处理器
public class RejectedTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.printf("RejectedTaskController: The task %s has been rejected.\n", r.toString());
        System.out.printf("RejectedTaskController: Executor is %s\n", executor.toString());
        System.out.printf("RejectedTaskController: Executor terminating: %s\n", executor.isTerminating());
        System.out.printf("RejectedTaskController: Executor terminated: %s\n", executor.isTerminated());
   
	}

}
