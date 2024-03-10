package com.example.salesdemo.Controller;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.example.salesdemo.DTO.ProductDTO;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.Services.ProductService;
import com.example.salesdemo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping(value = "/addProduct")
    public ResponseEntity<Object> add(@ModelAttribute WrapperDTO dto) throws UserException {
        if (dto.getProductDTOS().isEmpty()) {
            throw new UserException("Missing Params");
        }
        return ResponseUtil.returnResponse(service.AddNew(dto));
    }

    @DeleteMapping(value = "/delete/{name}")
    public ResponseEntity<Object> delete(@PathVariable String name) throws UserException {
        return service.delete(name);
    }
    @GetMapping(value = "/getByName/{name}")
    public Product getByName(@PathVariable String name) {
        return service.findByName(name);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@ModelAttribute ProductDTO dto) throws UserException {
        return service.update(dto);
    }

    @GetMapping(value = "/productByCategory/{category}")
    public ResponseEntity<Object> productsByCategory(@PathVariable String category) {
        return service.productsByCategory(category);
    }

    @GetMapping("/ProductBylessQty/{qty}")
    public ResponseEntity<Object> productsBylessQty(@PathVariable int qty) {
        return service.findProductsBylessQty(qty);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        return service.findAll();
    }

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable int id) throws UserException {
        return service.findById(id);
    }
}