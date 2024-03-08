package com.example.salesdemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sale_Id")
    private Long id;
    @Column(name = "Total_Amount")
    private Double totalAmount;
    @Column(name = "Sale_Date")
    private LocalDate date;
    @Column(name = "Sales_Quantity")
    private Double qty;

    //relationship
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "Sales_with_product", joinColumns = {@JoinColumn(name = "Sales_Id")}, inverseJoinColumns = {
            @JoinColumn(name = "Product_Name")
    })
    private List<Product> products;
}
