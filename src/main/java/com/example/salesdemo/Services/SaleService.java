package com.example.salesdemo.Services;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.entities.Sale;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaleService {
    ResponseEntity<Object> performSale(WrapperDTO dto) throws UserException;

    ResponseEntity<Object> todaysSale() throws UserException;

    List<Sale> findByDate(String Date);
}
