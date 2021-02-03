package com.test.model;

import java.io.Serializable;

public class Jingubang implements Serializable {
	
	public float h =100;
	public float d= 10;
	public void big(){
		this.d *=2;
		this.h *=2;
		
	}
	
	public  void small(){
		this.d /=2;
		this.h /=2;
	}

}
