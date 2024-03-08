package com.example.salesdemo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_id")
    private Long id;
    @Column(name = "Product_Name")
    private String name;
    @Column(name = "Product_Price")
    private Double price;
    @Column(name = "Product_Quantity")
    private Double qty;
    @Column(name = "Product_Category")
    private String category;
}
