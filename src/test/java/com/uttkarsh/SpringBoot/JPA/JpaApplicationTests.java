package com.uttkarsh.SpringBoot.JPA;

import com.uttkarsh.SpringBoot.JPA.entities.ProductEntity;
import com.uttkarsh.SpringBoot.JPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void getRepo(){
		 List<ProductEntity> entities = productRepository.findByTitle("pepsi");
		 System.out.println(entities);
	}

	@Test
	void getRepo2(){
		 List<ProductEntity> entities = productRepository.findByCreatedAtAfter(java.time.LocalDateTime.now().minusDays(1));
	}

	@Test
	void getRepo3(){
		 List<ProductEntity> entities = productRepository.findByQuantityAndPrice(10, new java.math.BigDecimal("100.00"));
		System.out.println(entities);
	}

	@Test
	void getRepo4(){
		 List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(10, new java.math.BigDecimal("100.00"));
		System.out.println(entities);
	}

	@Test
	void getRepo5(){
		Optional<ProductEntity> entity = productRepository.finByCompanyAndPrice("parle", new java.math.BigDecimal("100.00"));
		entity.ifPresent(System.out::println);
	}

}
