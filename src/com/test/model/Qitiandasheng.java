package com.test.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Qitiandasheng extends Monkey implements Cloneable, Serializable {

		public  Jingubang jingubang;
		
		public Qitiandasheng (){
			this.birthday = new Date();
			this.jingubang =new Jingubang();
		};
		
		@Override
		
		protected Object clone(){
			return this.deepClone();
			
		}

		private Object deepClone()  {
			// TODO Auto-generated method stub
			try {
				
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				oos.writeObject(this);
				
				ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				
				Qitiandasheng copy = (Qitiandasheng) ois.readObject();
				copy.birthday = new Date();
				
				return copy;
				
				
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public Qitiandasheng shallowClone(Qitiandasheng target){
			Qitiandasheng qitiandasheng = new Qitiandasheng();
			qitiandasheng.height = target.height;
			qitiandasheng.weight = target.weight;
			
			qitiandasheng.jingubang =target.jingubang;
			qitiandasheng.birthday = new Date();
			
			return qitiandasheng;
			
		}
		
		
}
