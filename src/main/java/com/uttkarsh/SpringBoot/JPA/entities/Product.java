package com.uttkarsh.SpringBoot.JPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "product",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"sku"}),
            @UniqueConstraint(columnNames = {"title", "company"}) // No 2 products can have same title and price
        },
        indexes = {
            @Index(name = "price_index", columnList = "price")
            // Index is a database structure that improves the performance of queries by reducing the time required to locate records.(It reduces data lookup time)
            // Instead of scanning the entire table, the database uses the index to quickly find the rows that match the search criteria.(it uses B-Trees/Hash Indexes for this)
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "string_id", nullable = false)
    private String sku;

    @Column(length = 20)  //length of title can't exceed 20
    private String title;

    private String company;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
