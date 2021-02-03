package com.test1;

public class subSequenceDemo {
	
	static String string = "2019070119232333";
	
	public static void main (String args[]){
		//subSequence,类似截取（起始位，结束位）
		System.out.println(string.subSequence(0,4));
		String str= (String) string.subSequence(0,15);
		System.out.println(str);
		//indexOf返回索引的位置
		System.out.println(str.indexOf("9") );

		
		Boolean istwo = str.indexOf("201907") >=0?true:false;
		
		System.out.println(istwo);

	}
}
