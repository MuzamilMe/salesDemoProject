package com.example.salesdemo.ServiceImpl;


import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.example.salesdemo.Commons.utils.StatusDto;
import com.example.salesdemo.Commons.utils.StatusEnum;
import com.example.salesdemo.DTO.SaleDTO;
import com.example.salesdemo.DTO.TotalSalesDTO;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.Repository.ProductRepository;
import com.example.salesdemo.Repository.SalesRepository;
import com.example.salesdemo.Services.SaleService;
import com.example.salesdemo.Transformer.SaleTransformer;
import com.example.salesdemo.entities.Product;
import com.example.salesdemo.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleImpl implements SaleService {


    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Object> performSale(WrapperDTO dtos) throws UserException {
        List<SaleDTO> saleDTOS = new ArrayList<>();
        for (SaleDTO dto : dtos.getSaleDTOS()) {
            Product productEntity = productRepository.findProductsByName(String.valueOf(dto.getProductDTOS().get(0).getName()));
            List<Product> productList = new ArrayList<>();
            productList.add(productEntity);
            if (productEntity == null) {
                throw new UserException(dto.getProductDTOS().get(0).getName() + " not found");
            }
            Sale entity = SaleTransformer.toEntity(dto);
            //seting remaining quantity to product
            if (productEntity.getQty() < Integer.valueOf(dto.getQty())) {
                throw new UserException("Only " + productEntity.getQty() + " " + dto.getProductDTOS().get(0).getName() + "  available");
            }
            productEntity.setQty(productEntity.getQty() - entity.getQty());
            //setting amount of sale of each product
            entity.setTotalAmount(productEntity.getPrice() * entity.getQty());
            //setting product data to sales
            entity.setProducts(productList);
            entity = salesRepository.save(entity);
            dto = SaleTransformer.toDTO(entity);
            saleDTOS.add(dto);
        }
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "Success", saleDTOS));
    }

    @Override
    public ResponseEntity<Object> todaysSale() throws UserException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.now();
        List<Sale> sales = salesRepository.findByDate(LocalDate.parse(dtf.format(dt)));

        if (sales.isEmpty()) {
            return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS, "No Sales Today", null));
        }
        String totalSales = salesRepository.getTotalAmountAsString();
        System.out.println(totalSales);
        TotalSalesDTO totalSalesDTO = new TotalSalesDTO();
        totalSalesDTO.setTotalAmount(totalSales);
        return ResponseUtil.returnResponseWithCustomMessage(1,"Todays Sales ",totalSalesDTO,sales.get(0));

    }

    @Override
    public List<Sale> findByDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.from(dtf.parse(date));
        List<Sale> sales = salesRepository.findByDate(dt);
        if (sales.isEmpty()) {
            throw new RuntimeException("No Sale on date: " + date);
        }
        return sales;
    }

}
