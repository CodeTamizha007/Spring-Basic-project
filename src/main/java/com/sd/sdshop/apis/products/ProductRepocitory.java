package com.sd.sdshop.apis.products;

import com.sd.sdshop.apis.Entitys.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepocitory extends JpaRepository<Products, Integer> {
    Products findByProductId(String id);

    void deleteByProductId(String id);
}
