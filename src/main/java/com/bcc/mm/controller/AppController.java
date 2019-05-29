package com.bcc.mm.controller;


import java.util.List;

import com.bcc.mm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcc.mm.dto.ProductDTO;
import com.bcc.mm.service.IProductService;


@Controller
public class AppController {
	
	@Autowired
	IProductService productService;
	

	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/")
	public String index() {


		return "index";
	}

	@RequestMapping(value="/search_material", method = RequestMethod.GET)
	public String searchMaterial(Model model){


		List<String> categories = productService.getCategories();
		model.addAttribute("categories", categories);


		return "search_material";
	}




	@RequestMapping(value = "/add_material", method = RequestMethod.GET)
	public String add(Model model) {
		
		ProductDTO product = new ProductDTO();
		product.setDescription("");
		product.setLength("");
		product.setWidth("");
		product.setThick("");
		product.setCategory("");
		product.setQty(2);
		product.setDate();
		product.setStockControl(false);
		product.setStockControlMin(10);
		
		model.addAttribute("product", product);

		CategoryService cs = new CategoryService();
		List<String> categories = cs.getCategories();

		model.addAttribute("categories",categories);

		return"add_material";
	}
	
	@RequestMapping(value = "/add_material", method = RequestMethod.POST)
	public String saveNew(@ModelAttribute(value="product") ProductDTO product) {
		
		
		productService.save(product);
		System.out.println(product.getDescription());
		System.out.println(product.getCategory());
		System.out.println(product.getLength());
		System.out.println(product.getWidth());
		System.out.println(product.getThick());
		System.out.println(product.isStockControl());




		
		return "/index";
	}
	
	@RequestMapping("/showall")
	public String showAll(Model model) {
		
		List<ProductDTO> all = productService.getAll();
		model.addAttribute("inventory", all);
		
		return "all_products";
	}
	
	
}
