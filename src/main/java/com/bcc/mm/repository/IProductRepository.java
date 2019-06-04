package com.bcc.mm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bcc.mm.dto.ProductDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("repository")
public interface IProductRepository extends CrudRepository<ProductDTO, Integer> {

    List<ProductDTO> findDistinctProductByCategoryLike(String category);

    List<ProductDTO> findDistinctProductByThickLike(String thick);

    List<ProductDTO> findByDescriptionLike(String keyword);


    @Query("SELECT new ProductDTO(id, description, length, width, " +
            "thick, qty, category, date, stockControl, " +
            "stockControlMin) FROM ProductDTO where description like %:keyword%")
    public List<ProductDTO> search(@Param("keyword") String keyword);



}
