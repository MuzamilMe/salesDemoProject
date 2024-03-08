package com.example.salesdemo.Transformer;

import com.example.salesdemo.DTO.ProductDTO;
import com.example.salesdemo.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductTransformer {

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        if (dto.getId() != null) {
            product.setId(Long.valueOf(dto.getId()));
        }
        if (dto.getName() != null) {
            product.setName(dto.getName());
        }
        if (dto.getPrice() != null) {
            product.setPrice(Double.valueOf(dto.getPrice()));
        }
        if (dto.getQty() != null) {
            product.setQty(Double.valueOf(dto.getQty()));
        }

        if (dto.getCategory() != null) {
            product.setCategory(dto.getCategory());
        }
        return product;
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        if (product.getId() != null) {
            dto.setId(String.valueOf(product.getId()));
        }
        if (product.getName() != null) {
            dto.setName(product.getName());
        }
        if (product.getPrice() != null) {
            dto.setPrice(product.getPrice().toString());
        }
        if (product.getQty() != null) {
            dto.setQty(product.getQty().toString());
        }

        if (product.getCategory() != null) {
            dto.setCategory(product.getCategory());
        }

        return dto;
    }


    public static List<Product> toEntity(List<ProductDTO> list) {
        List<Product> list1 = new ArrayList<>();
        for (ProductDTO dto : list) {
            list1.add(ProductTransformer.toEntity(dto));
        }
        return list1;
    }

    public static List<ProductDTO> toDTO(List<Product> list) {
        List<ProductDTO> list1 = new ArrayList<>();
        for (Product product : list) {
            list1.add(ProductTransformer.toDTO(product));
        }
        return list1;
    }

//    public static List<ProductDTO> toDTOCheck(List<Product> list) {
//        List<ProductDTO> list1 = new ArrayList<>();
//        for (Product Product : list) {
//            Product.setSetup(null);
//            list1.add(ProductTransformer.toDTO(Product));
//        }
//        return list1;
//    }
//
//    public static List<ProductDTO> toDTONew(List<Product> list) {
//        List<ProductDTO> list1 = new ArrayList<>();
//        for (Product Product : list) {
//            list1.add(ProductTransformer.toDTOCheck(Product));
//        }
//        return list1;
//    }

    public static Product toUpdate(Product product, ProductDTO dto) {
        if (dto.getId() != null) {
            product.setId(Long.valueOf(dto.getId()));
        }
        if (dto.getName() != null) {
            product.setName(dto.getName());
        }
        if (dto.getPrice() != null) {
            product.setPrice(Double.valueOf(dto.getPrice()));
        }
        if (dto.getQty() != null) {
            product.setQty(Double.valueOf(dto.getQty()));
        }

        if (dto.getCategory() != null) {
            product.setCategory(dto.getCategory());
        }
        return product;
    }
//
//    /**
//     * @param Product gives Product null in setup
//     * @return
//     */
//    public static ProductDTO toDTOCheck(Product Product) {
//        ProductDTO dto = new ProductDTO();
//        if (Product.getId() != null) {
//            dto.setId(String.valueOf(Product.getId()));
//        }
//        if (Product.getCedentAmount() != null) {
//            dto.setCedentAmount(String.valueOf(Product.getCedentAmount()));
//        }
//        if (Product.getCedentRate() != null) {
//            dto.setCedentRate(Product.getCedentRate());
//        }
//        //using DTO New from SetupTransformer which returns us Product null because we have already Product data
//        if (Product.getSetup() != null) {
//            dto.setSetup(SystemSetupTransformer.toDTONew(Product.getSetup()));
//        }
//
//        return dto;
//    }

}
