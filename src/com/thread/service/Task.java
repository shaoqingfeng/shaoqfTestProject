package com.thread.service;

import java.util.concurrent.TimeUnit;

//模拟一个任务线程，实现Runnable接口。
public class Task implements Runnable {
	
	private String name;
	
	public Task (String name) {
		this.name =name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long duration = (long)(Math.random() * 10);
		//占位符，%n是转行的意思,%s是字符串、%d是整数、%f代表浮点数。
        System.out.printf("Task: %s will run during %d seconds\n", name, duration);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
	}
	
	@Override
    public String toString() {
        return this.name;
    }

}
