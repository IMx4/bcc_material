package com.bcc.mm.service;

import java.util.List;

import com.bcc.mm.dto.ProductDTO;

public interface IProductService  {
	
	
	ProductDTO getById(int id);
	
	List<ProductDTO> getAll();
	
	boolean save(ProductDTO productDTO);

	List<ProductDTO> findByNameLike(String category);

	List<String> getCategories();

	List<ProductDTO> searchByKeyword(String keyword);


}
