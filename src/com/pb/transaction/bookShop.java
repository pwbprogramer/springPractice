package com.pb.transaction;

/**
 * 书店接口
 * @author pwb
 *
 */
public interface bookShop {
    
	//根据书号获取书的单价
	public int findBookPriceByIsbn(String isbn); 
	//更新书的库存，使书号对应的库存-1
	public void updateBookStock(String isbn);
	//更新账户余额
	public void updateUserAccount(String username,int price);
}
