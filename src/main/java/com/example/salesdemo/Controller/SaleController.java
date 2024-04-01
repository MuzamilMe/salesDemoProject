package com.example.salesdemo.Controller;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.DTO.WrapperDTO;
import com.example.salesdemo.Services.SaleService;
import com.example.salesdemo.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
//@AllArgsConstructor
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;

    @PostMapping(value = "/transaction")
    public ResponseEntity<Object> transaction(@ModelAttribute WrapperDTO wrapperDTO) throws UserException {
        return service.performSale(wrapperDTO);
    }

    @GetMapping(value = "/todaysSale")
    public ResponseEntity<Object> todaysSale() throws UserException {
        return service.todaysSale();
    }

    @GetMapping(value = "/saleByDate/{date}")
    public List<Sale> getSaleByDate(@PathVariable String date) {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//        LocalDate  d1 = LocalDate.parse(date, df);
        return service.findByDate(date);
    }
    @GetMapping(value = "/Sales")
    public List<Sale> saleAll()  {
        return service.findAll();
    }

}
