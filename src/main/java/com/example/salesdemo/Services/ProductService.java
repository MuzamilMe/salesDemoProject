package com.example.salesdemo.Services;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.DTO.ProductDTO;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Object> AddNew(WrapperDTO products) throws UserException;

    ResponseEntity<Object> delete(String name) throws UserException;

    ResponseEntity<Object> update(ProductDTO dto) throws UserException;

    ResponseEntity<Object> findAll();
    ResponseEntity<Object> findById(int id) throws UserException;

    ResponseEntity<Object> productsByCategory(String Category);
   Product findByName(String name) throws UserException;

    ResponseEntity<Object> findProductsBylessQty(int qty);

}
