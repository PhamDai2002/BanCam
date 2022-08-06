package com.shop.bran.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CartItem;
import com.shop.bran.entity.Order;
import com.shop.bran.repsitory.IOrderReponsitory;
import com.shop.bran.service.CamService;
import com.shop.bran.service.CartService;

@Controller
public class OrderController {
	
	@Autowired
	private IOrderReponsitory iOrderReponsitory;
	
	@Autowired
	private CamService camService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	
	
	//Hàm thanh toán
	@RequestMapping("/paying/{total}")
	public String addOrder(Model model, @PathVariable("total") BigDecimal total) {//total là tổng tiền
		Order orders = new Order();//khỏi tạo
		
		//Gọi ra ngày hiện tại
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		orders.setOrderDate(date);//set ngày mua ở trong tk order là ngày hiện tset ngày mua hiện tại
		orders.setAmount(total);// set odert để lấy tổng tiền
		//Lưu vào order
		iOrderReponsitory.save(orders);// iOrderReponsitory là của jpa . save có sẵn trong db
		
		// update lại số lượng
		Collection<CartItem> lcartItem = cartService.getCartItems();
		//lcartItem là lấy số lượng
		// cartService.getCartItems() là để lấy danh sách
		
		for (CartItem cartItem : lcartItem) {// dùng for duyệt ra 
			Cam cam = camService.findById(cartItem.getId());
			int qtM = cam.getSoluong();// ptM là số ở db
			int qtO = cartItem.getQuantity();// ptO là số nhập vào
			int updateSoLuong = qtM - qtO;
			cam.setSoluong(updateSoLuong);// set lại số lượng
			camService.update(cam);// rồi uppdate lại
		}
		return "redirect:/list-order";
		
	}
	
	// Hàm này là hiển thị ra danh sách order
	@RequestMapping("list-order")
	public String showOrder(Model model) {
		//findAll() là lấy từ Jpa có sẵn
		List<Order> listOrder = iOrderReponsitory.findAll();
		// truyền dữ liệu qua view
		model.addAttribute("listOrder",listOrder);
		return "order";
	}
	
	
}
