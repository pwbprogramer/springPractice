package com.pb.model;

public class helloWord {
     
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public helloWord() {
		
	}
	
	public helloWord(String name) {
		this.name=name;
	}
	
	public void hello() {
		System.out.println("你好："+this.name);
	}
	
}
