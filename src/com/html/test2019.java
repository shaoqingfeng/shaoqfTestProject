package com.html;

import java.util.Arrays;

public class test2019 {

	
	public static void main(String[] ags){
		String string = "12,34,,,,1,";
		 String[] arrays =string.split(",");//String[] arrays =string.split(",",-1); -1如果是空格，也计算在内
		System.out.println("arrays="+Arrays.toString(arrays) +",num="+arrays.length);
		
	}
	
	

}
