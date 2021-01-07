package com.bcc.mm.controller;
import com.bcc.mm.dto.ProductDTO;
import com.bcc.mm.service.CategoryService;
import com.bcc.mm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add_material", method = RequestMethod.GET)
    public String add(Model model) {

        CategoryService cs = new CategoryService();
        List<String> categories = cs.getCategories();

        ProductDTO product = new ProductDTO();

        model.addAttribute("product", product);
        model.addAttribute("categories",categories);

        return "admin/add_material";
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

        return "admin/all_products";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(){


        return "admin/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value="keyword")String term, Model model){

        List<ProductDTO> searchList = productService.search(term);

        model.addAttribute("inventory", searchList);


        return "admin/search";
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

        return "admin/edit";

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

        return "admin/order";
    }




}
