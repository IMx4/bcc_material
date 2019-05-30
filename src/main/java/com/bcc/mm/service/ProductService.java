package com.bcc.mm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.bcc.mm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bcc.mm.dto.ProductDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component
public class ProductService implements IProductService{


	@Autowired
	IProductRepository repository;
	
	
	public ProductDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductDTO> getAll() {

		List<ProductDTO> all = new ArrayList<>();
		repository.findAll().forEach(all::add);

		return all;
	}


	public boolean save(ProductDTO productDTO) {
		
		repository.save(productDTO);

		return false;
	}

		@Override
		public List<ProductDTO> findByNameLike(String category) {
			return null;
		}


		public List<ProductDTO> findByCategoryLike(String category){

		return repository.findDistinctProductByCategoryLike(category);
	}

	public List<String> getCategories(){

		List<ProductDTO> allCategories = (List<ProductDTO>) repository.findAll();

		return allCategories
				.stream()
				.map(x -> x.getCategory())
				.distinct()
				.collect(Collectors.toList());

	}

	@Override
	public List<ProductDTO> searchByKeyword(String keyword) {

		List<ProductDTO> allCategories = (List<ProductDTO>) repository.findByDescriptionLike(keyword);

		return allCategories;
	}

	public List<String> search(String keyword){

		//List<String> allCategories = repository.search(keyword);
		List<String> t = repository.search(keyword);




		//return allCategories;
		return null;
	}


}

