package com.bcc.mm.controller;

import java.util.ArrayList;
import java.util.List;
import com.bcc.mm.service.CategoryService;
import com.bcc.mm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bcc.mm.dto.ProductDTO;


@Controller
public class AppController {
	
	@Autowired
	ProductService productService;
	

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

		CategoryService cs = new CategoryService();
		List<String> categories = cs.getCategories();

		ProductDTO product = new ProductDTO();

		model.addAttribute("product", product);
		model.addAttribute("categories",categories);

		return"add_material";
	}
	
	@RequestMapping(value = "/add_material", method = RequestMethod.POST)
	public String saveNew(@ModelAttribute(value="product") ProductDTO product) {
		
		
		productService.save(product);

		return "/index";
	}
	
	@RequestMapping("/showall")
	public String showAll(Model model) {
		
		List<ProductDTO> all = productService.getAll();
		model.addAttribute("inventory", all);
		
		return "all_products";
	}

//	@GetMapping("/test")
//	public String search(Model model){
//
//		productService.findByCategoryLike()
//
//		model.addAttribute("keyword");
//
//		return "test";
//	}
//
//	@PostMapping("/test")
//	public String search(@RequestParam String keyword){
//
//		System.out.println(keyword);
//
//
//
//		return "test";
//	}

	@RequestMapping("/test/{keyword}")
	public String search(@PathVariable String keyword, Model model){

		List<String> searchList = productService.search(keyword);
		//productService.search(keyword);
		//List<ProductDTO> searchList = new ArrayList<>();


		model.addAttribute("inventory", searchList);
		model.addAttribute("keyword", keyword);

		return "test";
	}
	
	
}
