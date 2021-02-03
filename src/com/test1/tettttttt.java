package com.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tettttttt {
	public static String sql ="BCAG4623,BCAG4625|";
	public static String sql2 ="";
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		List   list = java.util.Arrays.asList("aaaaaaa bbbbbbc ccccc".split(" "));
//		System.out.println(list);
//		java.util.Collections.reverse(list);
//		
//		System.out.println(list);
/*		 
		正则表达式中如果直接是$的话会解释为行的结尾，如果你要匹配$这个字符的话，要用[$]。
		split方法参数是一个正则表达式,由于$是正则表达式中的关键字符,所以需要加上转义字符进行转义.
		当然,使用 String[] numbers = str.split("[$]");的方式也可以,因为[$]中将[$]放在中括号[]里时不表示行首,就不需要进行转义了.
*/	
		sql = sql.substring(0,sql.length()-1);
		System.out.println("sql"+sql+"==="+sql.length());
		
		System.out.println("sql2"+sql2+"==="+sql2.trim());
		
		System.out.println("sql2"+sql2+"==="+"".equals(sql2.trim()));


		

	}
	
	
	 public static List<String> sqlParamter(String sql) {
	        String[] q = sql.split("[$]");
	        List<String> param = new ArrayList<String>();
	        for (String s : q) {
	            if (s.trim().length() == 0)
	                continue;
	            System.out.println("s=="+s);
	            if (s.substring(0, 1).equals("(") || s.substring(0, 1).equals("[") || s.substring(0, 1).equals("{")) {
	                    param.add(s);
	            }
	        }
	        return param;
	    }

}
