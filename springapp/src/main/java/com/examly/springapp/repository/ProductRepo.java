package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Product;
import java.util.Optional;
import java.util.*;

public interface ProductRepo  extends JpaRepository<Product,Integer>{
    List<Product> findByCategory_Id(int categoryId);
}
