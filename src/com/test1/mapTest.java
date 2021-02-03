package com.test1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mapTest {
	public static void main(String[] args){
		//Map 和 List如果初始化是null，在add和put的时候就会报空指针，new HashMap或者new ArrayList 则会避免恐空指针
		Map mapc = new HashMap<>();
		Map map2 = new HashMap<>();
		Map map3 = new HashMap<>();
		Map outMap = new HashMap<>();
		Map outMap4 = new HashMap<>();
		//mapc.put("189_35001", strList);
		List<Map<String, Object>> ls = new ArrayList<>();
		String phone = "189";
		//mapc.put("189_35002", "555");
		mapc.put("arr", "35016");
		mapc.put("err", "554");
		mapc.put("zhangsan", "123");
		mapc.put("lishi", "456");
		mapc.put("wangwu", "789");
		ls.add(mapc);
		map2.put("arr", "35012");
		map3.put("arr", "666");
		map2.put("err", "774");
		ls.add(map2);
		ls.add(map3);
		String dd = "189_35001";
		System.out.println("ls==="+ls.toString());
		Map<String,Object> inMap = new HashMap<String,Object>(); 

		for(Object key : mapc.keySet()){
			inMap.put(key.toString(), mapc.get(key));
			System.out.println("key==="+key.toString());
			System.out.println("inMap==="+inMap.toString());

		}
		System.out.println("mapc==="+mapc.toString());

		
//		int m =0;
//		for(Map tempMap : ls){
//			if( !"35016".equals(tempMap.get("arr").toString()) && !"35012".equals(tempMap.get("arr").toString())  ){
//				
//					System.out.println("m111==="+tempMap.get("arr").toString());
//	
//				}
//		}
//		for(Map tempMap : ls){
//			if(tempMap.get("arr").toString().equals("666")){
//				 m++;
//					System.out.println("m==="+m);
//
//			}
//		}
//		
//		 System.out.println("ls==="+ls.toString());
//
//		
//		outMap.put("canshu", ls);
//		System.out.println("outMap==="+outMap.toString());
//		
//		outMap4.put("dd", outMap);
//		
//		System.out.println("outMap4==="+outMap4.toString());
//
//		map2.put(dd,ls);
//		
//		List ls2 =new ArrayList<>();
//		//System.out.println(ls.toString());
//		ls2 = (List) map2.get("198");
//		if(ls2!=null &&  ls2.size()>0){
//			System.out.println("qqqq");
//		}else{
//			System.out.println("N");
//		}
//		if	(dd.equals(phone + "_35001" )){
//			System.out.println("23233333");
//		}
//		
//		Double	resourcesRemain2 = 10000.0;  
//		Double resourcesTotal2	 = 5005.0; 
//		Double eee = resourcesRemain2/resourcesTotal2;
//		Double dbDouble  = (double) (resourcesRemain2/resourcesTotal2);
//		//float num=  (float)resourcesRemain2/resourcesTotal2;
//		DecimalFormat df = new DecimalFormat("0.0");//格式化小数   
//		//String df1 = df.format(num);
//		//String percentum = num*100 + "%";
//		//System.out.println(percentum +"wwww"+num+",df1="+df1+",eee="+eee+",dbDouble="+dbDouble);
//
//		System.out.println( ",eee="+eee+",dbDouble="+dbDouble);
		
	}
}
