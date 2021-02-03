package com.test1;

import java.awt.datatransfer.FlavorTable;
import java.util.List;

public class matchesDemo {
	
	static  String str = "123457890000";
	
	public static void main(String args[]){
		//[0-9]+ 表示至少一个，最多不限制的数字串
//		if(str.matches("[0-9]+")){
//			System.out.println(str);
//
//		}else{
//			System.out.println("shenm");
//
//		}
		
		str = "99.9";
		
		String string2TypeTest = "89";
		Float float1 = Float.parseFloat(str);
		System.out.println(float1); 
		
		if( Float.parseFloat(string2TypeTest) < float1){
			System.out.println("55555555555555"); 

		}
		 
		str = "0";
		Double.parseDouble(str);
		System.out.println(Double.parseDouble(str)/100);
	}
	 
}
