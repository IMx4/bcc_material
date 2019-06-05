package com.bcc.mm.service;

import java.util.*;
import java.util.stream.Collectors;
import com.bcc.mm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bcc.mm.dto.ProductDTO;

@Component
public class ProductService implements IProductService{


	@Autowired
	IProductRepository repository;
	
	
	public ProductDTO getById(int id) {

		Optional<ProductDTO> searchProduct = repository.findById(id);
		ProductDTO product;

		if(searchProduct.isPresent()){
			return product = searchProduct.get();
		} else {

			return null;
		}
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

		List<ProductDTO> allCategories = repository.findByDescriptionLike(keyword);

		return allCategories;
	}


	public List<ProductDTO> search(String keyword){

		List<ProductDTO> result = repository.search(keyword);

		return result;
	}

	public boolean delete(int id){

		if(repository.findById(id).isPresent()){

			repository.deleteById(id);
			return true;

		}
		return false;
	}

	public List<ProductDTO> getLowInventory(){

		List<ProductDTO> lowInventory = repository.getLowInventory();

		return lowInventory;
	}

	public List<ProductDTO> getProductsByCategory(String keyword){

		List<ProductDTO> products = repository.findByCategoryLike(keyword);

		return products;
	}

	public List<ProductDTO> findBySubCategoryLike(String keyword){

		List<ProductDTO> products = repository.findBySubCategoryLike(keyword);

		return products;
	}

	public List<ProductDTO> getSubCategories(String keyword){

		List<ProductDTO> allCategories = repository.findByCategoryLike(keyword);

		return allCategories
				.stream()
				.distinct()
				.collect(Collectors.toList());

	}


}

