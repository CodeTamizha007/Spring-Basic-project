package com.sd.sdshop.apis.customers;

import com.sd.sdshop.apis.Entitys.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepocitory customersRepocitory;

    public String registerCustomer(Customers customer) {
        //Customers cust =  new Customers(customer.getUserName(),customer.getPassword(),customer.getMailId(),customer.getPhoneNo());
        Customers cust = customersRepocitory.save(customer);
        if(cust != null){
            return "customer added successfully";
        }
        else {
            return "Unable to add user";
        }
    }
}
