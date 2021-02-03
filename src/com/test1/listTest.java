package com.test1;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class listTest {

	static Map<String,String> checkPacPrc(String relprcinsId, String goodsinsid)
	{
		if(relprcinsId.equals(goodsinsid)) {
			return null;
		}
		return  null;
	}
	
	public static void main(String[] args){
		Map<String, String> relProdPrcInsIdMap = new HashMap<String, String>();
		
		List<String> shortNumList = new ArrayList();
		String mainProdPrcinsId="60000166293989";
		String serialNo ="3";
		if (!mainProdPrcinsId.equals(relProdPrcInsIdMap.get(serialNo))) {
			serialNo ="3";

			checkPacPrc(relProdPrcInsIdMap.get(serialNo), "60000166293989");

		}



		
//		String  bb ="";
//		System.out.println(bb.length());
//		int m = 0;
		for (int a = 511; a< 561 ; a++){
			if(a!=550){
				 shortNumList.add(String.valueOf(a));
				//bb += a+",";
			}
			 
		}
//		System.out.println(shortNumList);
		
		Iterator<String> iterator =  shortNumList.iterator() ;
		
		while (iterator.hasNext()) {
			String str   = iterator.next();
			System.out.println("str="+str);
			if(!"1".equals(str)){
				iterator.remove();
				System.out.println("str移除="+str);

			}
			
		}
		
    	System.out.println("123"+  iterator );

		
//		
//		String[] cc = bb.split(",");
//		
//		cc.clone();
//		for (String j : cc){
//			if(j.equals(522)){
//				//shortNumList.add(String.valueOf(a));
//				m++;
//			}
//			
//			if(j.equals(511)){
//				//shortNumList.add(String.valueOf(a));
//				m++;
//			}
//			 
//		}
//		System.out.println("m="+m);
//
//		
//		int num = cc.length;
//		int num2= bb.length();
//		System.out.println("cc="+Arrays.toString(cc));
		
		 
		//System.out.println(shortNumList.toString());
//		shortNumList.add("551");
//		shortNumList.add("552");
//		shortNumList.add("553");
//		shortNumList.add("554");
//		shortNumList.add("555");
//		shortNumList.add("556");
//		shortNumList.add("557");
//		shortNumList.add("558");
		String mm = "35016";
		String shortnumStr_35009 ="" ;	
		
		
//		if(shortNumList != null){		
//			
//			for (String shornum : shortNumList)
//			shortnumStr_35009 = shortnumStr_35009+shornum+"|";
//			
//			//System.out.println(shortnumStr_35009);
//				
//	
//	
//} 
//		System.out.println(shortNumList);
//
//		System.out.println(shortnumStr_35009);
	
//	String[]	shortnumArr = shortnumStr_35009.split("|");
//		System.out.println(shortnumArr.toString());
//		
//		String abc = shortnumArr[0];
//		
//		System.out.println(abc);

		
//		 List<Integer> memberRoleIdList = new ArrayList<>();
//	        memberRoleIdList.add(30001);
//	        memberRoleIdList.add(30002);
//	        memberRoleIdList.add(30004);
//	        memberRoleIdList.add(30005);
//	     System.out.println(memberRoleIdList.toString());   
//		Map mapc1 = new HashMap<>(); 
//		mapc1.put("ziyuan1", "eeeeee");
//		mapc1.put("ziyuan2", "350002");
//		mapc1.put("ziyuan3", "eeeeee3");
//		
//		List strList = new ArrayList<>();
//		strList.add(mapc1);
//		//int i = strList.length;
//	
//		String bb ="44";
//		Map mapc = new HashMap<>();	
//		
//		mapc.put("189_35001", strList);
//		
//		mapc.put("189_35002", "555");
//		String dd = "189_35001";
//		Set<String> aa = mapc.keySet();
//		List  zhuanhuanlist = new ArrayList<>();
//		for(String gg : aa){
//			 System.out.println("gg"+gg);
//		if (dd.equals(gg)){
//			System.out.println("gg1"+mapc.get(gg).toString());
//			// String[] hhlist =  <String[]>mapc.get(gg);
//			zhuanhuanlist = (List) mapc.get(gg);
//			Map aMap = new HashMap<>();
//			for(int i=0; i<zhuanhuanlist.size();i++){
//				aMap  = (Map) zhuanhuanlist.get(i);
//				String aString = (String) aMap.get("ziyuan1");
//				String bString = (String) aMap.get("ziyuan2");
//				
//				System.out.println("aString=="+aString +",bString="+ Integer.parseInt(bString.substring(bString.length()-1)) );
//			}
//		 }
//		}
////		list.add(aa);
////		list.add(bb);
//		
////		map1.put("abc", list);
////		 list.add(bb);
////		list.addAll(list);
//		Set<String> s = map1.keySet();
////		if(s!=null && s.equals(null)){
////			map1.putAll(list);
////		}
//		//map1.put("abc", "456");
//	 // Collections.reverse(list);
//		System.out.println("s"+s.toString());
//
//		System.out.println(map1.toString());
//		System.out.println(list.toString());
		
		
	}

}
