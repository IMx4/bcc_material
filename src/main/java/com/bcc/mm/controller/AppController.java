package com.bcc.mm.controller;

import java.util.ArrayList;
import java.util.List;
import com.bcc.mm.service.CategoryService;
import com.bcc.mm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bcc.mm.dto.ProductDTO;
import org.springframework.web.servlet.ModelAndView;


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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(){


        return "search";
    }

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(value="keyword")String term, Model model){

        System.out.println(term);
        List<ProductDTO> searchList = productService.search(term);

	    model.addAttribute("inventory", searchList);


		return "search";
	}

    @RequestMapping(value = "/search/result", method = RequestMethod.GET)
    @ResponseBody
    public List<String> searchResult(@RequestParam(value="term",required = false, defaultValue="")String term){

	    List<String> results = new ArrayList<>();

        List<ProductDTO> searchList = productService.search(term);
        for(ProductDTO item : searchList){
            results.add(item.getDescription());

        }

        return results;
    }


//    @RequestMapping(value="/search")
//    public List<ProductDTO> search(@RequestParam(value="term",required = false, defaultValue="")String term, Model model){
//
//        System.out.println(term);
//            List<ProductDTO> searchList = productService.search(term);
//		model.addAttribute("inventory", searchList);
//
//		return searchList;
//
//        }


	
}
