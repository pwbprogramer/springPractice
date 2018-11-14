package com.pb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pb.interfaceImpl.calculateImpl;
import com.pb.model.helloWord;

public class test {

	public static void main(String[] args) {
			helloWord hello = new helloWord("pingweibo");
			hello.hello();
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			String[] beans = ctx.getBeanDefinitionNames(); 
	        for (String beanName : beans) {  
	            Class<?> beanType = ctx .getType(beanName);  
	            System.out.println("==============================");
	            System.out.println("BeanName:" + beanName);  
	            System.out.println("Bean的类型：" + beanType);  
	            System.out.println("Bean所在的包：" + beanType.getPackage());  
	            System.out.println("Bean：" + ctx.getBean(beanName)); 
	            System.out.println("==============================");
	        }  
			helloWord hello2=(helloWord) ctx.getBean("hello");
			calculateImpl calculateImpl = (com.pb.interfaceImpl.calculateImpl) ctx.getBean("calculateImpl");
			calculateImpl.jia(1, 1);
			hello2.hello();
	}

}
