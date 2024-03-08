package com.example.salesdemo.Repository;

import com.example.salesdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //    @Query("select pr.name from Product pr where pr.Qty<?4 ")
    List<Product> findProductsByQtyIsLessThanEqual(Integer no);

    Product findProductsByName(String name);

    List<Product> findAllByCategory(String category);

}
