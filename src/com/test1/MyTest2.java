package com.test1;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class MyTest2 {
    
    public static void main(String[] args) {
        String s = "{'a':'1','b':'2'}";
        Map map1 = new HashMap<String, Object>();
        String aa;
        String bb;
        String cc;
//        String dateStr = "20150103"; 
//        System.out.println(dateStr.substring(0, 4));
//        System.out.println(dateStr.substring(4, 6));
//        System.out.println(dateStr.substring(6, 8));
        
        
    	int[] arr={5,6,3};
		for(int x=0;x<=arr.length-1;x++){
	
			
			
//			if(arr[x]==3){
//				break;
//			 
//			}
			map1.put(arr[x], "qq");
		}
		System.out.println(arr.length);
		System.out.println(map1.toString());
		
		Map<String, Object> Map2 = new HashMap<String,Object>();
		
		System.out.println(map1.size());
		Set<Map.Entry<String, Object>> map11 =  map1.entrySet();
		for (Map.Entry<String, Object> entry : map11){
			System.out.println(String.valueOf(entry.getKey())+",,"  +"value="+entry.getValue());
		}
//		for(int e=1;e<=map1.size();e++){
//			
//			System.out.println("map1.get(e).toString():==="+map1.entrySet());
//			Map2.put( map1.entrySet().toString(),e);
//			System.out.println(Map2.toString());
//		}
		
		
    }

    	
    	
    	

}
