package com.bcc.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcc.mm.dao.ProductDAO;
import com.bcc.mm.dto.ProductDTO;

@Component
public class ProductService implements IProductService {

	@Autowired
	ProductDAO productDAO;
	
	
	public ProductDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductDTO> getAll() {
		
		return productDAO.getAll();
	}



	public boolean save(ProductDTO productDTO) {
		
		productDAO.save(productDTO);

		return false;
	}

	public List<ProductDTO> findByNameLike(String category){

		return productDAO.findByCategoryLike(category);
	}

//	public List<ProductDTO> findDistinctByCategory(){
//
//		return productDAO.findDistinctByCategory();
//	}


}
