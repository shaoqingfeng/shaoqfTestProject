package com.thread.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
public class ThreadDemo{
	  public static void main(String[] args) {
	        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(12);
	        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) fixedExecutorService;
	        System.out.println(threadPoolExecutor.getMaximumPoolSize());
	        
	        System.out.println("0=="+threadPoolExecutor.getActiveCount());
	        
	        System.out.println("1=="+threadPoolExecutor.getCorePoolSize());

	        System.out.println("2=="+threadPoolExecutor.getTaskCount());

	        
	        threadPoolExecutor.setCorePoolSize(8);
	        
	        System.out.println("setCorePoolSize=="+threadPoolExecutor.getCorePoolSize());

	        
	        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
//	      运行时异常 java.lang.ClassCastException
//	      ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) singleExecutorService;
	    }
}
