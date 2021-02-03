package com.test1;


public class ThreadDemo extends Thread {
	
	private int i =0;
	@Override
	public void run() {
		System.out.println("thread---==");
		for(i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}
	
	public static void main(String[] args ){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==30){
				Thread myThread1= new ThreadDemo();
				Thread myThread2= new ThreadDemo();
				
				myThread1.start();
				myThread2.start();

			}
			
		}
	}

}

