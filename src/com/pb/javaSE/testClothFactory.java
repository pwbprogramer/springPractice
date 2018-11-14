package com.pb.javaSE;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理的实现
 * @author pwb
 *
 */
interface clothFactory {
    void productCloth();
}

//被代理类
class NikeClothFactory implements clothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产一批衣服");
	}
	
}

//代理类
class ProxyFactory implements clothFactory{
   public  clothFactory cf;
   //创建一个代理类对象时实际传入一个被代理类对象
   public ProxyFactory(clothFactory clothFactory) {
   	   this.cf = clothFactory;
   }
	@Override
   public void productCloth() {
		System.out.println("代理类开始执行,开始收费");
		cf.productCloth();
   }
	
}

/**
 * 动态代理实现
 * @author pwb
 *
 */
interface testActionProxy{
	void action();
}

//被代理类
class actionClass implements testActionProxy {

	@Override
	public void action() {
		System.out.println("阿迪达斯生产了一批衣服");
	}
	
}

//代理
class myInvokeHandler implements InvocationHandler{
    
	Object proxy;
	
	public myInvokeHandler(Object proxy){
		this.proxy = proxy;
	}
	
	public Object blind() {
		return Proxy.newProxyInstance(this.proxy.getClass().getClassLoader(),
				                      this.proxy.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass());
		return method.invoke(this.proxy, args);
	}
	
}

public class testClothFactory {
       public static void main(String[] args) {
    	   NikeClothFactory nikeclothfactory = new NikeClothFactory();
    	   ProxyFactory proxyfactory = new ProxyFactory(nikeclothfactory);
    	   proxyfactory.productCloth();
    	   
    	   myInvokeHandler myinvokehandler = new myInvokeHandler(nikeclothfactory);
    	   Object ob=myinvokehandler.blind();
    	   clothFactory clothfactory = (clothFactory)ob;
    	   clothfactory.productCloth();
       } 
}
