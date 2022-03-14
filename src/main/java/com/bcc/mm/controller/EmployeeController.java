package com.bcc.mm.controller;
import com.bcc.mm.AppState;
import com.bcc.mm.dto.ProductDTO;
import com.bcc.mm.service.Logger;
import com.bcc.mm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    ProductService productService;


    // Employee index of Categories
    @RequestMapping(value = "/emp")
    public String employeeSearch(Model model){

        List<String> categories = productService.getCategories();
        model.addAttribute("categories", categories);

        return "employee/employee_search";
    }

    // Employee index of Sub Categories
    @RequestMapping(value = "/sub")
    public String emplyeeSub(@RequestParam("category")String category, Model model){

        List<String> items = productService.getDistinctSubCategories(category);
        model.addAttribute("categories", items);

        return "employee/employee_search_sub";
    }

    // Employee index of Products
    @RequestMapping(value = "/final")
    public String employeeFinal(@RequestParam("category")String category, Model model){

        List<ProductDTO> items = productService.findBySubCategoryLike(category);
        model.addAttribute("categories", items);

        return "employee/employee_search_final";
    }

    // Employee Edit Product Quantity
    @RequestMapping(value = "/employee_edit")
    public String employeeEdit(@RequestParam("category")String id, Model model){

        ProductDTO product = productService.getById(Integer.parseInt(id));
        model.addAttribute("item", product);

        return "employee/employee_edit";
    }

    // Employee Update Product Quantity
    @GetMapping(value = "/emp_update")
    public String employeeUpdate(@RequestParam("qty")String qty, @RequestParam("id") String id){

        ProductDTO product = productService.getById(Integer.parseInt(id));

        int adjustedQty = Integer.parseInt(qty) - product.getQty();

        product.setQty(Integer.parseInt(qty));
        productService.save(product);

        Logger.logUpdateItem(product, AppState.user, adjustedQty);

//        // if the user is not admin - redirect to login page
//        if(!AppState.isAdmin()){
//            AppState.user = null;
//            return "/login";
//        }

        return "employee/employee_index";
    }

}
