package com.ing.catalog.repository;

import com.ing.catalog.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    public ProductCategory findByCategoryName(String name);

}
