package com.example.salesdemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Dto By Muzamil
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private String id;
    private String date;
    private String totalAmount;
    private String qty;
    private String cName;
    private String payType;

    //relationship
    private List<ProductDTO> ProductDTOS;

}
