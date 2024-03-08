package com.example.salesdemo.ServiceImpl;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.example.salesdemo.Commons.utils.StatusDto;
import com.example.salesdemo.Commons.utils.StatusEnum;
import com.example.salesdemo.DTO.ProductDTO;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.Repository.ProductRepository;
import com.example.salesdemo.Services.ProductService;
import com.example.salesdemo.Transformer.ProductTransformer;
import com.example.salesdemo.entities.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Object> AddNew(WrapperDTO dto) throws UserException {
        List<ProductDTO> list = new ArrayList<>();
        if (dto.getProductDTOS().isEmpty()) {
            throw new UserException("Enter Products data");
        }
        for (ProductDTO product : dto.getProductDTOS()) {
            Product entity = ProductTransformer.toEntity(product);
            entity = productRepository.save(entity);
            product = ProductTransformer.toDTO(entity);
            list.add(product);
        }
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Product Added", list));
    }

    @Override
    public ResponseEntity<Object> update(ProductDTO dto) throws UserException {
        if (dto.getName() == null) {
            throw new UserException("Missing params");
        }
        Product entity = productRepository.findProductsByName(dto.getName());
        System.out.println(entity.toString());
        if (entity == null) {
            throw new UserException(dto.getName() + " Not found");
        }
        dto = ProductTransformer.toDTO(productRepository.save(ProductTransformer.toUpdate(entity, dto)));
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Product Updated", dto));

    }

    @Override
    public ResponseEntity<Object> findAll() {
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Products List found", productRepository.findAll()));
    }

    @Override
    public ResponseEntity<Object> findById(int id) throws UserException {
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Product found with id "+id, productRepository.findById(id)));
    }

    @Override
    public ResponseEntity<Object> delete(String name) throws UserException {
        if (name == null) {
            throw new UserException("Missing params");
        }
        Product product = productRepository.findProductsByName(name);
        if (product == null) {
            throw new UserException(name + " Not found");
        }
        productRepository.delete(product);
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Delete Successfully: ", name));
    }


    @Override
    public ResponseEntity<Object> productsByCategory(String category) {
        List<Product> list = productRepository.findAllByCategory(category);
        if (list.isEmpty()) {
            return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "No product is found in " + category, null));
        }
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "products are found in " + category, list));
    }

    @Override
    public ResponseEntity<Object> findProductsBylessQty(int qty) {
        List<Product> list = productRepository.findProductsByQtyIsLessThanEqual(qty);
        if (list.isEmpty()) {
            return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "No product is less than or equals to " + qty, null));
        }
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Products less than or equals to " + qty, list));
    }
}
