package com.shop.bran.controller;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CartItem;
import com.shop.bran.service.CamService;
import com.shop.bran.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CamService camService;

	
	//Hiển thị sản phẩm trong giỏ hàng
	@GetMapping("cart")
	public String list(Model model) {
		Collection<CartItem> cartItems = cartService.getCartItems();
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("total", cartService.getAmout());
		model.addAttribute("NoOfItems", cartService.getCount());
		return "cart";
	}
	
	//Hàm add vào giỏ hàng
	@GetMapping("add-to-cart/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		Cam cam = camService.findById(id);// tìm kiếm đối tượng cám
		CartItem item = new CartItem();//khởi tao CartItem là giỏ hàng
		if (cam != null) {
				BeanUtils.copyProperties(cam, item);// nếu cam tồn app toàn bộ dữ liệu và item
				item.setQuantity(1);//set Quantity bằng 1 
				cartService.addToCart(item);// gọi và sử lý addToCart
		}
		return "redirect:/cart";
	}
	
	@PostMapping("/update-to-cart")
	public String updateCart(@RequestParam("id") Integer id, @RequestParam("quantity") int quantity) {
		Cam cam = camService.findById(id);
		if (quantity > cam.getSoluong()) {
			quantity = cam.getSoluong();
		}
		cartService.updateToCart(id, quantity);
		return "redirect:/cart";
	}
	
}
