package com.shop.bran.service.Impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CartItem;
import com.shop.bran.service.CamService;
import com.shop.bran.service.CartService;


@Service
@SessionScope// tất thao tác đều trong SessionScope
public class CartServiceImpl implements CartService{

	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	
	@Autowired
	private CamService camService;
	
	@Override
	public void addToCart(CartItem item) {// sử lý addToCart 
		Cam cam = camService.findById(item.getId());//tìm ra thằng cam
		CartItem existedItem = map.get(item.getId());//existedItem để các sản phẩm trong cam
		if (existedItem != null) {// nếu sản tồn tại
			if (existedItem.getQuantity() < cam.getSoluong()) {//set sô nhận vào nếu nhỏ hơn số db 
				existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
			}
		} else {
			map.put(item.getId(), item);// dùng để lưu keyvalue
		}
	}
	
	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
	@Override
	public BigDecimal getAmout() {
		BigDecimal cartTotal = BigDecimal.ZERO;//khơi tạo cartTotal
		for (Map.Entry<Integer, CartItem> itemCart : map.entrySet()) {// duyệt tất cả item ở trong map
			cartTotal = cartTotal.add(itemCart.getValue().getGia().multiply(new BigDecimal(itemCart.getValue().getQuantity())));
			//cartTotal cộng với giá nhân số lượng
		}
		return cartTotal;
	}
	
	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();//size độ lớn map
	}
	
	@Override
	public void updateToCart(int id, int quantity) {//trả về id, quantity
		Cam cam = camService.findById(id);//khai báo cám
		CartItem item = map.get(id);//lấy các sản phẩm trong item
		if (cam.getSoluong() < item.getQuantity()) {//chenk số lượng db với nhập vào
			item.setQuantity(cam.getSoluong());// set số lượng giỏ hàng bằng với cam
		}
		item.setGia(cam.getGia());//set lại giá, quantity
		item.setQuantity(quantity);
		if (item.getQuantity() <= 0) {// nếu bằng 0 sẽ mất 
			map.remove(id);
		}
		
	}
}
