package com.bcc.mm.service;


import com.bcc.mm.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public interface IEmployeeService {

    boolean save(EmployeeDTO employeeDTO);

    boolean deleteById(int id);

}
