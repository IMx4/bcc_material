package com.bcc.mm.service;

import com.bcc.mm.dto.EmployeeDTO;
import com.bcc.mm.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService implements IEmployeeService {


    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public boolean save(EmployeeDTO employeeDTO) {

        employeeRepository.save(employeeDTO);

        return false;
    }

    @Override
    public boolean deleteById(int id) {

        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<EmployeeDTO> getAllEmployees(){

        List<EmployeeDTO> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(x -> employees.add(x));

        return employees;
    }

    public EmployeeDTO getEmployeeByID(int id){

        EmployeeDTO employee = employeeRepository.findById(id).get();

        return employee;
    }


}
