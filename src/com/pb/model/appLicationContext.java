package com.pb.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class appLicationContext {
	
	public static ApplicationContext ctx;
	
	public appLicationContext(String path) {
		this.ctx = new ClassPathXmlApplicationContext(path);
	}

}
