package com.bcc.mm.controller;

import com.bcc.mm.dto.EmployeeDTO;
import com.bcc.mm.dto.ProductDTO;
import com.bcc.mm.service.EmployeeService;
import com.bcc.mm.service.ProductService;
import com.bcc.mm.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;


@Controller
public class AppController {
	
	@Autowired
	ProductService productService;

	@Autowired
	EmployeeService employeeService;

	/**
	 * root of app
	 * @return html view for login
	 */
	@RequestMapping("/")
	public String index() {

		// Initial setup requires application property "setup" to be to 'true'
		// This enables access to the admin page to create admin account



		if(PropertiesService.isSetup().equals("true")){

			PropertiesService.setupComplete();

			return "index";
		}

		return "login";
	}

	/**
	 * maps user entered pin to correct landing page
	 * @param id user id entered from keypad in login.html
	 * @return html view for admin or standard user
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestParam(value = "id") String id){

		EmployeeDTO employee = employeeService.getEmployeeByPin(Integer.parseInt(id));
		if(employee != null ){

			if(employee.getJobPosition().equals("admin")){

				return "index";

			} else {

				return "employee/employee_index";
			}
		}
		return "login";
	}

}
