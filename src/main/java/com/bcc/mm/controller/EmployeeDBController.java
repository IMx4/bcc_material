package com.bcc.mm.controller;


import com.bcc.mm.dto.EmployeeDTO;
import com.bcc.mm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeDBController {


    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employee/all")
    public String allEmployees(Model model){

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        model.addAttribute("employees", employees);

        return "employeeDB/all_employees";
    }


    @RequestMapping("/employee/add")
    public String addEmployee(Model model){

        model.addAttribute("employee", new EmployeeDTO());

        return "employeeDB/add_employee";
    }

    @RequestMapping("/employee/{id}")
    public String editEmployee(@PathVariable(value = "id") String id, Model model){

        EmployeeDTO employee = employeeService.getEmployeeByID(Integer.parseInt(id));
        model.addAttribute("employee", employee);

        return "employeeDB/add_employee";
    }

    @RequestMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id, Model model){


        return "redirect:/employee/all";
    }

    @RequestMapping("/employee/save")
    public String saveEmployee(@ModelAttribute(value="employee") EmployeeDTO employee){

        employeeService.save(employee);

        return "index";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(EmployeeDTO employeeDTO){

        employeeService.deleteById(employeeDTO.getId());

        return "index";
    }



}
