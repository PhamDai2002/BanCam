package com.shop.bran.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.shop.bran.entity.CartItem;

public interface CartService {// nó để sử dụng nhiều lần

	void addToCart(CartItem item);

	Collection<CartItem> getCartItems();

	BigDecimal getAmout();

	int getCount();

	void updateToCart(int id, int quantity);

}
