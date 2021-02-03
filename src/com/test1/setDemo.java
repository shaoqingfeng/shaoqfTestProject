package com.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class setDemo {
	public static void main(String[] args){
		
		List<Map<String, Object>> list = new ArrayList<>();
		for(int i=0; i<10;i++){
			Map map = new HashMap<>();
			map.put("LABEL_ID", "L1000"+i);
			list.add(map);
		}
		List<Map<String, Object>> list2 = new ArrayList<>();

		for(int i=5; i<20;i++){
			Map map = new HashMap<>();
			map.put("LABEL_ID", "L1000"+i);
			list2.add(map);
		}
		 
		getlast(list,list2);			
		
	}
	
	static void getlast(List<Map<String, Object>> list,List<Map<String, Object>> list2) {
		
		Set<String> setTmp = new HashSet<String>(); 
		
		//List<Map<String, Object>> list11 = new HashSet<>(); 
//		for(Map map : list){
//			setTmp.add(map.get("LABEL_ID").toString());
//			//System.out.println("---------++输出12122"+setTmp.toString());
//		}
		
		List<Map<String, Object>> tempList = new ArrayList<>();
		
//		if(setTmp.size()>0){
			for(java.util.Iterator<Map<String, Object>> i = list2.iterator();i.hasNext();){
				Map m = (Map)i.next();
				
				if(!setTmp.contains(m.get("LABEL_ID").toString())) {
					Map<String, Object> tempMap = new HashMap<>();
					tempMap.put("PRC_ID", m.get("LABEL_ID").toString());
					m.put("setaaaa", "23233");
					tempList.add(tempMap);
					 System.out.println("---------++setTmp输出"+setTmp.toString());
				} else{
					 System.out.println("---------++dingdi输出"+list2.toString());
					i.remove();
				}
			}
			
//			for(Map teMap :list){
//				String dd = teMap.get("LABEL_ID").toString();
//				for(Map teMap2 :list2){
//					if(dd.equals(teMap2.get("LABEL_ID").toString())){
//						
//						teMap2.put("zengjia", "AAA");
//					}
//				}
//			}
//			
			System.out.println("---------++list2输出==="+list2.toString());


//		}
		
	}

}
