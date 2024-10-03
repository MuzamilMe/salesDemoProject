package com.example.salesdemo.Transformer;


import com.example.salesdemo.DTO.SaleDTO;
import com.example.salesdemo.entities.Sale;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleTransformer {
    @SneakyThrows
    public static Sale toEntity(SaleDTO dto) {
        LocalDate date = LocalDate.now();
        Sale sale = new Sale();
        if (dto.getId() != null) {
            sale.setId(Long.valueOf(dto.getId()));
        }
        if (date != null) {
            sale.setDate(date);
        }
        if (dto.getTotalAmount() != null) {
            sale.setTotalAmount(Double.valueOf(dto.getTotalAmount()));
        }
        if (dto.getQty() != null) {
            sale.setQty(Double.valueOf(dto.getQty()));
        }
        if(dto.getCName()!=null){
            sale.setCName(dto.getCName());
        }
        if(dto.getPayType()!=null){
            sale.setPayType(dto.getPayType());
        }
        //relationship Entity
        if (dto.getProductDTOS() != null) {
            sale.setProducts(ProductTransformer.toEntity(dto.getProductDTOS()));
        }

        return sale;
    }

    public static List<Sale> toEntity(List<SaleDTO> list) {
        List<Sale> list1 = new ArrayList<>();
        for (SaleDTO dto : list) {
            list1.add(SaleTransformer.toEntity(dto));
        }
        return list1;
    }

    public static SaleDTO toDTO(Sale sale) {
        SaleDTO dto = new SaleDTO();
        if (sale.getId() != null) {
            dto.setId(String.valueOf(sale.getId()));
        }
        if (sale.getDate() != null) {
            dto.setDate(sale.getDate().toString());
        }

        if (sale.getTotalAmount() != null) {
            dto.setTotalAmount(sale.getTotalAmount().toString());
        }
        if (sale.getQty() != null) {
            dto.setQty(sale.getQty().toString());
        }
        if(sale.getCName()!=null){
            dto.setCName(sale.getCName());
        }
        if(sale.getPayType()!=null){
            dto.setPayType(sale.getPayType());
        }
        //relationship DTO
        if (sale.getProducts() != null) {
            dto.setProductDTOS(ProductTransformer.toDTO(sale.getProducts()));
        }
        return dto;
    }

    public static List<SaleDTO> toDTO(List<Sale> list) {
        List<SaleDTO> list1 = new ArrayList<>();
        for (Sale sale : list) {
            list1.add(SaleTransformer.toDTO(sale));
        }
        return list1;
    }




    /**
     * @param sale it returns order null
     *              User where we have already order data
     * @return
     */
//    public static SaleDTO toDTONew(Sale sale) {
//        SaleDTO dto = new SaleDTO();
//        if (sale.getId() != null) {
//            dto.setId(String.valueOf(sale.getId()));
//        }
//        if (sale.getEstimatedDate() != null) {
//            dto.setEstimatedDate(String.valueOf(sale.getEstimatedDate()));
//        }
//        if (sale.getItemWeight() != null) {
//            dto.setItemWeight(String.valueOf(sale.getItemWeight()));
//        }
//        if (sale.getSize() != null) {
//            dto.setSize(String.valueOf(sale.getSize()));
//        }
//        if (sale.getName() != null) {
//            dto.setName(sale.getName());
//        }
//        if (sale.getType() != null) {
//            dto.setType(sale.getType());
//        }
//       /* if (sale.getOrder() != null) {
//            dto.setOrder(ProductTransformer.toDTOCheck(sale.getOrder()));
//        }*/
//
//        return dto;
//    }


//    public static List<SaleDTO> toDTONew(List<Sale> list) {
//        List<SaleDTO> list1 = new ArrayList<>();
//        for (Sale sale : list) {
//            list1.add(SaleTransformer.toDTOCheck(sale));
//        }
//        return list1;
//    }
//
//
//    @SneakyThrows
//    public static Sale toUpdate(Sale sale, SaleDTO dto) {
//        if (dto.getId() != null) {
//            sale.setId(Integer.valueOf(dto.getId()));
//        }
//        if (dto.getName() != null) {
//            sale.setName(dto.getName());
//        }
//        if (dto.getSize() != null) {
//            sale.setSize(Integer.valueOf(dto.getSize()));
//        }
//        if (dto.getType() != null) {
//            sale.setType(dto.getType());
//        }
//        if (dto.getItemWeight() != null) {
//            sale.setItemWeight(Double.valueOf(dto.getItemWeight()));
//        }
//        if (dto.getEstimatedDate() != null) {
//            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dto.getEstimatedDate());
//            sale.setEstimatedDate(date1);
//        }
//
//        return sale;
//    }

}
