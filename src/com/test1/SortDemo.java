package com.test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortDemo {
	
	public static void main(String[] args) {
//		out
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		Map<String, Object> map3 = new HashMap<>();
		Map<String, Object> map4 = new HashMap<>();

		map1.put("PRC_ID", "BM01");
		map1.put("PRICE", 80);
		list.add(map1);
		map2.put("PRC_ID", "BM02");
		map2.put("PRICE", 90);
		list.add(map2);
		map3.put("PRC_ID", "BM03");
		map3.put("PRICE", 95);
		list.add(map3);
		map4.put("PRC_ID", "BM03");
		map4.put("PRICE", 75);
		list.add(map4);
		
		System.out.println(map1+",,,,"+map2);
		
//		int midValue = 99999;
//		Map<String,Object> outMap = new HashMap<>();
//		for(int i=0;i<list.size();i++){
//			Map tempMap = list.get(i);
//			if(midValue> Integer.parseInt(tempMap.get("PRICE").toString())){
//				midValue =Integer.parseInt(tempMap.get("PRICE").toString());
//				outMap.put("PRC_ID",tempMap.get("PRC_ID"));
//				outMap.put("PRICE",tempMap.get("PRICE"));
//
//			}
//		}
		// list = new ArrayList<>();

		if(!list.isEmpty()){
			
		
			int midValue ;
			
			midValue = Integer.valueOf(list.get(0).get("PRICE").toString());
			
			Map<String,Object> outMap = new HashMap<>();
			for(int i=0;i<list.size();i++){
				Map tempMap = list.get(i);
				if(midValue> Integer.parseInt(tempMap.get("PRICE").toString())){
					midValue =Integer.parseInt(tempMap.get("PRICE").toString());
					outMap.put("PRC_ID",tempMap.get("PRC_ID"));
					outMap.put("PRICE",tempMap.get("PRICE"));
	
				}
			}
	
			
			System.out.println("outMap="+outMap);
		}
		if(list.isEmpty()){
			System.out.println("-----------=");
		}
		System.out.println(list.size());
		
		
		
		Collections.sort(list,new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> arg1, Map<String, Object> arg2) {
				// TODO Auto-generated method stub
				 
				Integer price1 = Integer.valueOf(arg1.get("PRICE").toString());
				Integer price2 = Integer.valueOf(arg2.get("PRICE").toString());
				return price1.compareTo(price2);////控制升降序，现在是升序,换成
				//return price2.compareTo(price1);////控制升降序，降序
			}
			
			 
			
		});
		
		
		//排序后
		
		System.out.println(list);
		
		for(Map<String, Object> map:list.subList(0, 2)){
			System.out.println("PRC_ID="+map.get("PRC_ID")+",,"+"Price="+map.get("PRICE"));
		}
	}

}
