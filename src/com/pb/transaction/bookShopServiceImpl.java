package com.pb.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class bookShopServiceImpl implements bookShopService {
    
	@Autowired 
	public bookShopImpl bookShopImpl;
	
	@Transactional
	@Override
	public void doPurchase(String user,String select) {
		//1.获取图书价格
		int price = bookShopImpl.findBookPriceByIsbn(select);
		//2.库存减一
		bookShopImpl.updateBookStock(select);
		//3.用户
		bookShopImpl.updateUserAccount(user, price);
	}


}
