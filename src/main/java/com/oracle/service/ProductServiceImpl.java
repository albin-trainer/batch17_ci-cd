package com.oracle.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.oracle.entity.Product;
import com.oracle.exception.ApplicationException;
import com.oracle.repostitory.ProductRepository;
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prodRepo;
	public Product addProductService(Product p) {
		return prodRepo.save(p);
	} 
	public Product searchProductServiceById(int id) {
	Optional<Product> optional= prodRepo.findById(id); //can find only by primary key
		if(optional.isPresent())
			return optional.get();
		else
			throw new ApplicationException("product id "+id+"  not present");
	}
	
	
	public Product updateProductService(Product p, int id) {
		 prodRepo.findById(id).orElseThrow(()->new ApplicationException("Prod id not found") );
		return 	prodRepo.save(p); //if the record not present it add new rec or else it just update
	}
	@Override
	public void deleteProduct(int id) {
			prodRepo.deleteById(id); //delete by primary key
	}
	@Override
	public List<Product> allProductsService() {
		return prodRepo.findAll(); //find all records ...
	}
	@Override
	public List<Product> searchByName(String name) {
		return prodRepo.findByProductName(name);
	}
}
