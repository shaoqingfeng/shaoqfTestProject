package com.test1;

import java.util.HashSet;
import java.util.Scanner;



public class scannerDemo {
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输�?");
		while (in.hasNext()) {
				int	n = in.nextInt();
				in.nextLine();
				
				HashSet<String> set = new HashSet<String>();
				
				for(int i=0;i<n;i++){
					String line = in.nextLine();
					
					String[] arr= line.split(" ");
					for (int j=0;j<arr.length ;j++){
						set.add(line);
						
					}
					
					}
				System.out.println("sum:"+set.size());
				}
		}
}



