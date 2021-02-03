package com.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class trueOrFalseTest {
	
	 
	public static void main(String[] args){
		boolean flag = true;
		
		String string ="1";
		List  js  = new ArrayList<>();
		List  js2  = new ArrayList<>();
		List  js3  = new ArrayList<>();
		js.add("123");
		js2.add("33");
		
		if(js3.isEmpty()){
			System.out.println(js.toString());
			flag = false;
			string="2";
		}else if(js2.isEmpty()){
			System.out.println(js2.toString());
			flag = false;
			string="2";
		}else if(js.isEmpty()){
			flag = false;
			string="2";
			System.out.println("5666666");

		}
		
		if(flag){
			System.out.println("zhen");
		}else{
			System.out.println("非真");
		}
		
		if(string.equals("2")){
			System.out.println("2222222222");
		}else{
			System.out.println("666666666666666");
		}
		
	}

	
	 
	
	
	
}
