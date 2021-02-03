package fileTest2;

import java.io.File;
import java.io.IOException;


public class deleteFileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		deleteFile("G:/shaoqfTest");
	}

	public static void deleteFile(String path) {
		// TODO Auto-generated method stub
		File file = new File(path);
		
		if(!file.exists()){
			System.out.println("²»´æÔÚ"); 
		}
		
		if(file.exists()){
			System.out.println("´æÔÚ"); 
		}
		
		if(file.isFile()){
			file.delete();
		}else if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i=0; i<files.length;i++){
				File tempf = files[i];
				System.out.println(":"+tempf.getAbsolutePath());
				deleteFile(tempf.getAbsolutePath());
			}
			file.delete();
		}
		
	}

}
