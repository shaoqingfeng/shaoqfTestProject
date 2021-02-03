package com.test.model;

public class DeepCloneTest {
   public static void main(String[] args){
	   Qitiandasheng qitiandasheng = new Qitiandasheng();
	   
	   Qitiandasheng clone = (Qitiandasheng) qitiandasheng.clone();
	   
	   System.out.println("深克隆："+(qitiandasheng.jingubang == clone.jingubang));
	   
	   
	   Qitiandasheng qitiandasheng2 = new Qitiandasheng();
	   
	   Qitiandasheng nQitiandasheng = qitiandasheng2.shallowClone(qitiandasheng2);
	   
	   System.out.println("浅克隆："+(qitiandasheng2.jingubang == nQitiandasheng.jingubang));
   }
}
