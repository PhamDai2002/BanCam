package com.shop.bran.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CamType;
import com.shop.bran.service.CamService;

@Controller
@RequestMapping("cam")
public class CamController {
	@Autowired
	private CamService ser;

	@GetMapping("/index")// hàm nhận sử lý 
	public String index(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber, ModelMap map, Model mol) {
		map.addAttribute("lists", ser.getPage(pageNumber));// hiện thị phân trang
		CamType[] loaiCams = CamType.values();// hiện thị loại
		mol.addAttribute("loaiCams", loaiCams);// trả về cái loại
		map.addAttribute("view", "/WEB-INF/views/sanpham/index.jsp");// set về view
		return "layout";
	}

	@GetMapping("/create")// hàm create chỉ để hiện thị
	public String create(ModelMap map) {
		map.addAttribute("view", "/WEB-INF/views/sanpham/crate.jsp");
		return "layout";
	}

	@GetMapping("/edit")//hàm edit chỉ để hiện thị
	public String edit(ModelMap map, @RequestParam(name = "id") int id) {
		map.addAttribute("conlon", ser.findById(id));
		map.addAttribute("view", "/WEB-INF/views/sanpham/edit.jsp");
		return "layout";
	}

	@PostMapping("/update")//từ edit chạy update để sửa
	public String update(ModelMap map, Cam c, @RequestParam(name = "id") Integer id) {
		Cam cam = (Cam) ser.findById(id);
		if (c.getAnh().equals(""))//set ảnh
			c.setAnh(cam.getAnh());
		c.setHansudung(new Date());//set lại hạn sử dụng
		ser.update(c);//rồi updteta bên sevce
		return "redirect:/cam/index";
	}

	@PostMapping("/store")// từ create chạy store thêm đối tượng mới
	public String store(ModelMap map, Cam c) {
		ser.create(c);//chạy create của cámervice để thêm 
		System.out.println(c);
		return "redirect:/cam/index";
	}

	@GetMapping("/delete")
	public String delete(ModelMap map, int id) {
		ser.delete(id);//xoá bên sveceri
		return "redirect:/cam/index";
	}
	
	@GetMapping("/type")
	public String timKiem(Model model, @RequestParam(name = "loai", required = false) String type) {
		if (type.equals("all")) {
			return "redirect:/cam/index";
		} else {
			CamType loai = CamType.valueOf(type);
			Page<Cam> list = ser.getByType(loai, 0);
			System.out.println(list);
			CamType[] loaiCams = CamType.values();
			model.addAttribute("loaiCams", loaiCams);
			model.addAttribute("lists", list);
			model.addAttribute("view", "/WEB-INF/views/sanpham/index.jsp");
			return "layout";
		}	
	}
	@PostMapping("/deletes")
	public String deleteAll(@RequestParam(value = "chk", required = false) List<Integer> list) {
		ser.deleteList(list);
		return "redirect:/cam/index";
	}
	//Hiện thì toàn sản phẩm nên mạng hình
	@GetMapping("/home")
	public String home(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber, ModelMap map) {
		map.addAttribute("lists", ser.getAll());
		map.addAttribute("view", "/WEB-INF/views/sanpham/show.jsp");
		return "layout";
	}
}
