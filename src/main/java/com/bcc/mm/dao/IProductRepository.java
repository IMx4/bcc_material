package com.bcc.mm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bcc.mm.dto.ProductDTO;

import java.util.List;

public interface IProductRepository extends CrudRepository<ProductDTO, Integer> {

    List<ProductDTO> findDistinctProductByCategoryLike(String category);

    //List<ProductDTO> findDistinctByCategory();


}
