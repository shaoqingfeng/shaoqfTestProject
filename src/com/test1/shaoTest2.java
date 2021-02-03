package com.test1;
import java.util.Arrays;
import java.util.Collections;                                                                
import java.util.Comparator;                                                                 
import java.util.HashMap;                                                                    
import java.util.HashSet;                                                                    
import java.util.LinkedList;                                                                 
import java.util.List;                                                                       
import java.util.Map;                                                                        
	import java.util.Set;                                                                        
                                                                                              
	public class shaoTest2 {                                                                   
                                                                                      
	    public static void main(String[] args) {  
	    	//----
	    	String haha ;
	    	Double double1 = 02d;
	    	
	    	int price1 = 800;
	    	
	    	double1= Double.parseDouble(String.valueOf(price1))/100;
	    	haha = String.format("%.2f", double1);
	    	 System.out.println("double1="+double1+","+haha);
	                                                                  
//	    	int[] a = {1,3,7,10,2,-4,5,6};
//			int len=a.length;
//			int sum=0;
//
//	        for(int i=0;i<len;i++){
//	            int value=a[i];
//	            System.out.println("i="+i+",value="+value);
//	            int temp=i;
//	            for(int j=i+1;j<len;j++){
//	                if(a[j]>value){
//	                    value=a[j];
//	                    temp=j;
//	                    System.out.println("temp="+temp+",i="+i+",j="+j+",a[j]"+a[j]);
//	                }
//	            }
//	             
//	            a[temp]=a[i];
//	            a[i]=value;
//	             System.out.println("a[temp]"+a[temp]+",a[i]="+a[i]+",value="+value +",a="+Arrays.toString(a));
//	            if(i<4){
//	            	sum+=a[i];
//	            }
//	        }
//	        System.out.println(sum);

		
		
//	    算法一：
//	    int[] num = {1,3,7,10,-4,5,6};
//	    		int len = num.length;
//	    		int count = 0;
//	    		for(int i = 0; i < 4; i++){
//	    			for(int j = i+1; j < len; j++){
//	    				System.out.println("i"+i+"j"+j);
//	    				if(num[i] < num[j]){
//	    					
//	    					int temp = num[i];
//	    					num[i] = num[j];
//	    					num[j] = temp;
//	    				}
//	    			}
//	    			count += num[i];
//	    		}
//	    		System.out.println(count);
 
//	    算法二：
//	    int[] a = { 1, 3, 7, 10, -4, 5, 6 };
//	    		int len = a.length;
//	    		int count = 0;
//	    		for (int i = 0; i < len; i++) {
//	    			for (int j = 0; j < len - i - 1; j++) {
//	    				if (a[j] < a[j + 1]) {
//	    					int temp = a[j];
//	    					a[j] = a[j + 1];
//	    					a[j + 1] = temp;
//	    				}
//	    			}
//	    		}
//	    		for(int i = 0; i < 4; i++){
//	    			count += a[i];
//	    		}
//	    		System.out.println(count);
//	    算法三：
//	    int[] a={1,3,7,10,-4,5,6};
//	    		 int len=a.length;
//	             int insertNum;
//	             for(int i=1;i<len;i++){
//	                 insertNum=a[i];
//	                 int j=i-1;
//	                 while(j>=0&&a[j]>insertNum){
//	                     a[j+1]=a[j];
//	                     j--;
//	                }
//	                 a[j+1]=insertNum;
//	            }
//	             int num=0;
//	             for(int k=len-1;k>=len-4;k--){
//	    	 num+=a[k];
//	             }
//	            System.out.println(num);
//	    	}

	    }
}                                                                                          
