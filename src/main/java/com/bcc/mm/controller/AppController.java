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

//	@RequestMapping(value="/search_material", method = RequestMethod.GET)
//	public String searchMaterial(Model model){
//
//
//		List<String> categories = productService.getCategories();
//		model.addAttribute("categories", categories);
//
//
//		return "search_material";
//	}


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
			System.out.println(item.getDescription());

        }

        return results;
    }


    @GetMapping(value="/edit")
    public String edit(@RequestParam(value="product",required = false, defaultValue="")String term, Model model){

        ProductDTO product = productService.getById(Integer.parseInt(term));
        CategoryService cs = new CategoryService();

        model.addAttribute("item", product);
        model.addAttribute("categories", cs.getCategories());

		return "edit";

	}

	@PostMapping(value="/update")
	public String update(@ModelAttribute(value="item") ProductDTO product){

		productService.save(product);

		return "index";
	}


	@PostMapping(value="/delete")
	public void delete(@ModelAttribute(value="item") ProductDTO product, Model model){

		model.addAttribute("item", product);
	}

	@PostMapping(value="/deleteNow")
	public String deleteNow(@ModelAttribute(value="id") String id){

		productService.delete(Integer.parseInt(id));

		return "index";
	}

	@GetMapping(value = "/order")
	public String orderSoon(Model model){

		List<ProductDTO> lowInventory = productService.getLowInventory();

		model.addAttribute("lowInventory", lowInventory);

		return "order";
	}

	@RequestMapping(value = "/emp")

	public String employeeSearch( @RequestParam("category")String category , Model model){
		System.out.println(category);
		if(category.equals("all")) {
			List<String> categories = productService.getCategories();
			model.addAttribute("categories", categories);
		} else {

			List<String> productDesc = new ArrayList<>();

			List<ProductDTO> items = productService.getProductsByCategory(category);
			for(ProductDTO product : items){

				productDesc.add(product.getDescription());
			}

			model.addAttribute("categories", productDesc);
		}

		return "employee_search";
	}



	
}
