package com.sd.sdshop.apis.customers;

import com.sd.sdshop.apis.Entitys.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepocitory extends JpaRepository<Customers,Integer> {

}
