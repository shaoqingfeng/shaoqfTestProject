package com.test1;

public class MyThread{
	
	public static void main(String[] args) {
		Runner1 run1 = new Runner1();
		
		run1.start();
		for(int j=0;j<5;j++){
			System.out.println("run1="+j);
		}
	}
}	
  class Runner1 extends Thread{
		public void run() {  
			for(int i=0;i<5;i++){
				System.out.println("MyThread.run()="+i);  
			}
			
		}
 }
	

