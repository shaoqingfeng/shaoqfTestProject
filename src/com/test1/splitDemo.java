package com.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class splitDemo {
	
	public static String sql ="select '$(62147)$^$(109413)$' from dual";
	
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
		String[] dd = splitDemo.sql.split("\\$");
		for (String str : dd) {
			System.out.println("str:="+str);
		}
		
		List  ls = new ArrayList<>();
		ls.add(0, "xiaom");
		ls.add(1, "xi4om");
		System.out.println(ls);
		Collections.reverse(ls);
		System.out.println(ls);
		
		List<String> l1 = sqlParamter(sql);
		l1.add("(123ee),(45ee6),(9rr88 ");
		System.out.println(l1.toString());
		
		Method method = splitDemo.class.getMethod("" ,   ls.getClass());
		
		method.invoke(ls, (List<String>)ls);
		
		Map<String,String> paramValue = new HashMap<String, String>();
		for(String paramName:l1)
		{
			System.out.println("paramName==="+paramName);
            String[] pn = paramName.split(",");
			//System.out.println("pn==="+pn.toString());
            String bianliang =pn[0] ;
            String fixName = paramName;
            //山西修改：是否是分表，山西的分表取值只有()类型，这里默认补右括号
            if (pn.length > 1) {
                fixName = pn[0].trim()+")";
            }
            
            System.out.println("fixName"+fixName);
		}
		

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
