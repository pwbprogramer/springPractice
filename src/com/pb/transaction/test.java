package com.pb.transaction;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pb.model.appLicationContext;

public class test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopServiceImpl bookshopimpl = (bookShopServiceImpl) ctx.getBean("bookShopServiceImpl");
		System.out.println("请登录:");
		Scanner sc0 = new Scanner(System.in);
		String user = sc0.next();
		System.out.println("===========================");
		System.out.println("欢迎购买");
		System.out.println("===========================");
		System.out.println("1.basketballPrice");
		System.out.println("2.footballPrice");
		System.out.println("3.carRacingPrice");
		System.out.println("===========================");
		System.out.println("请选择：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String select = "";
		switch (num) {
		case 1:select = "basketballPrice";break;
		case 2:select = "footballPrice" ;break;
		case 3:select = "carRacingPrice";break;
		default:
			break;
		}
		//执行购买
		bookshopimpl.doPurchase(user, select);
		System.out.println("购买成功");
//		int price=bookshopimpl.findBookPriceByIsbn(select);
//		bookshopimpl.updateBookStock(select);
//		System.out.println("updateBookStock");
//		bookshopimpl.updateUserAccount(user, price);
//		System.out.println("updateUserAccount");
	}

}
