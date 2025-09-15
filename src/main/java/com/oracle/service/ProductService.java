package com.oracle.service;

import java.util.List;

import com.oracle.entity.Product;

public interface ProductService {
Product addProductService(Product p);
Product searchProductServiceById(int id);
Product updateProductService(Product p, int id);
void deleteProduct(int id);
List<Product> allProductsService();
List<Product> searchByName(String name);

}
