package com.test1;

public class stringBufferTest {
	
	public static StringBuffer vqp = new StringBuffer("select * from ");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vqp.append(" ex_table_dict where dddd=1");
		
		System.out.println("vqp=="+vqp);
		System.out.println(vqp.length());
		
		vqp.append("and ii=0");
		//vqp.delete(0, vqp.length());
		System.out.println("delete_vqp=="+vqp);
	}

}
