package com.example.salesdemo.Repository;

import com.example.salesdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //    @Query("select pr.name from Product pr where pr.Qty<?4 ")
    List<Product> findProductsByQtyIsLessThanEqual(Integer no);

    Product findProductsByName(String name);

    List<Product> findAllByCategory(String category);

@Query(value = "SELECT DISTINCT product_category FROM (SELECT product_category FROM products ORDER BY product_id) AS subquery", nativeQuery = true)

    List<Object>  findDistinctByCategory();

}
