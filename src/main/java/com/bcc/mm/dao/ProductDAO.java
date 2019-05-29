package com.bcc.mm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcc.mm.dto.ProductDTO;


@Component
public class ProductDAO {
	
	@Autowired
	IProductRepository productRepository;
	

	public boolean save(ProductDTO productDTO) {

		productRepository.save(productDTO);
		
		return false;
	}

	public List<ProductDTO> getAll() {
		
		List<ProductDTO> all = (List<ProductDTO>) productRepository.findAll();
		
		return all;
	}



	public List<ProductDTO> findByCategoryLike(String name){

		List<ProductDTO> byCategory = productRepository.findDistinctProductByCategoryLike(name);

		return byCategory;
	}


	public List<ProductDTO> findByThick(String thick){

		List<ProductDTO> byThickness = productRepository.findDistinctProductByThickLike(thick);

		return byThickness;
	}




}
