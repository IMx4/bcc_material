package com.bcc.mm.repository;


import com.bcc.mm.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeRepository")
public interface IEmployeeRepository extends CrudRepository<EmployeeDTO, Integer> {

    @Query("SELECT new EmployeeDTO(id, firstName, lastName, jobPosition, pin) FROM EmployeeDTO where pin = :pin")
    public EmployeeDTO findByPinLike(@Param("pin") int pin);



}
