package com.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileTest {
	public static void main (String[] args) throws IOException {
		File file1 = new File("G:/shaoqfTest/22.txt");
		if(!file1.exists()){
            file1.getParentFile().mkdirs();   
            file1.createNewFile();
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("试着写下,ni好啊");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }
        
		 
		if(file1.isFile()){
            
        }
        
        

//		File file1 = new File("G:/shaoqfTest/file.txt");
//		File directory = new File("G:/shaoqfTest/1");
//		File dir =new File("G:/shaoqfTest2/2/file.txt");
//		if(!directory.exists()){
//			System.out.println(directory.mkdir());
//		}	
//		
//		if(!dir.exists()){
//			System.out.println("234"+dir.createNewFile());
//		}
//		
//		if(!file1.exists()){
//			System.out.println(":"+file1.createNewFile());
//		}
		
		file1.setReadable(true);
		file1.setWritable(false);
		System.out.println("isFile"+ file1.isFile()+"isDirectory"+file1.isDirectory()+"/canRead"+file1.canRead());
//		System.out.println(dir.isFile()+"/isDirectory11"+file1.isDirectory());
		
		
		String[] str = file1.list();
		File[] str1 = file1.listFiles();
		System.out.println("last:"+file1.lastModified());
		
		System.out.println("lenght:"+file1.length() +"getAbsolutePath:"+file1.getAbsolutePath());
		
		System.out.println("getPath:"+file1.getPath());
		System.out.println("getParent+:"+file1.getParent()+"getName:"+file1.getName());
		  for(int j=0;j<str1.length;j++)
	            System.out.println(":"+str1[j]);
	        for(int i=0;i<str.length;i++)
	        {
	            System.out.println("@@:"+str[i]);
	        }
	}

}
