package com.pb.transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class bookShopImpl implements bookShop {
    
	/**
	 * 获取图书价格
	 */
	@Override
	public int findBookPriceByIsbn(String isbn) {
		return Integer.parseInt(this.getProperties().getProperty(isbn));
	}
    
	/**
	 * 更新图书库存
	 */
	@Override
	public void updateBookStock(String isbn) {
		Properties pop = this.getProperties();
		int num = Integer.parseInt(pop.getProperty(isbn+"Num"));
		if(num==0) {
			throw new bookShopException("库存不足");
		}else {
			pop.setProperty(isbn+"Num", ""+--num+"");
		}
		this.setProperties(pop);
	}
    
	/**
	 * 更新用户余额
	 */
	@Override
	public void updateUserAccount(String username, int price) {
		Properties pop = this.getProperties();
		int num = Integer.parseInt(pop.getProperty(username));
		if(num<price) {
			throw new accountException("余额不足");
		}else {
			pop.setProperty(username, ""+(num-price)+"");
		}
		this.setProperties(pop);
	}
	
	/**
	 * 读取properties
	 * @return
	 */
	@SuppressWarnings("unused")
	public Properties getProperties() {
		Properties pop = null;
		InputStream is = null;
		String price = null;
			try {
				pop = new Properties();
				is = new FileInputStream(new File(""+System.getProperty("user.dir")+"\\src\\bookShop.properties"));
				pop.load(is);
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return pop;
	}
	
	/**
	 * 重写propertise
	 * @param pop
	 */
	public void setProperties(Properties pop) {
		try {
			OutputStream os = new FileOutputStream(new File(""+System.getProperty("user.dir")+"\\src\\bookShop.properties"));
			pop.store(os,"update");
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
