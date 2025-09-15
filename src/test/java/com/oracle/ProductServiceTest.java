package com.oracle;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.oracle.entity.Product;
import com.oracle.repostitory.ProductRepository;
import com.oracle.service.ProductServiceImpl;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	@Mock
	private ProductRepository prodRepo;
	@InjectMocks //mock objects injected in prodservice
	private ProductServiceImpl prodService;
	@Test
	public void testSearchProductById() {
		System.out.println("test");
		Product p=new Product();
		p.setProductId(111); p.setProductName("Bag"); p.setPrice(500);
		//PRE-CONDITION : when the service invokes rep.findById 
		when(prodRepo.findById(111)).thenReturn(Optional.of(p));
		Product actualProduct=prodService.searchProductServiceById(111);
		
		assertEquals(actualProduct.getProductName(), p.getProductName());
		assertEquals(actualProduct.getPrice(), p.getPrice());
	}
}
