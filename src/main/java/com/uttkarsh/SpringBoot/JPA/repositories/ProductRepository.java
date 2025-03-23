package com.uttkarsh.SpringBoot.JPA.repositories;

import com.uttkarsh.SpringBoot.JPA.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //we don't need to implement these methods, Spring Data JPA does it for us.
    //we just need to define the methods by following some rules, and JPA will do its magic.
    //Spring Data JPA automatically generates a JPQL query, by seeing the name, then Hibernate(ORM) converts the JPQL query into native SQL
    //and JPA uses Hibernate to execute the query and return a object.
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime timestamp);

    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(Integer quantity, BigDecimal price);


    //we can also implement our oun custom queries, directly, giving the JPQL query, then letting hibernate(ORM) do its work.
    @Query("select e from ProductEntity e where company=:company and price=:price")
    //in query, names should be exact same as it were created in entity like- (ProductEntity) - class name(same, it is case sensitive), similarly company and price
    Optional<ProductEntity> finByCompanyAndPrice(String company,  BigDecimal price);

    //NOTE: - we did test them , using unit testing
}
