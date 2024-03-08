package com.example.salesdemo.Repository;

import com.example.salesdemo.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByDate(LocalDate date);

//    @Query(value = "SELECT cast(SUM(s.totalAmount) AS string) FROM Sale s")
//    String[] getTotalAmountAsString();

    @Query(value = "SELECT  cast(SUM(total_amount) as char) from  sales", nativeQuery = true)
    String getTotalAmountAsString();

}
