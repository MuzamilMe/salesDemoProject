package com.example.salesdemo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WrapperDTO {
    private List<ProductDTO> productDTOS;
    private List<SaleDTO> saleDTOS;


}
