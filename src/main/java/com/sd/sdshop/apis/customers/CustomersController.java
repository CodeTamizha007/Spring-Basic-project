package com.sd.sdshop.apis.customers;

import com.sd.sdshop.apis.Entitys.Customers;
import com.sd.sdshop.apis.response.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @PostMapping("register")
    public ResponseMessage registerCustomer(@Valid @RequestBody CustomersRequestDTO customer){
        Customers entity = new Customers(
                customer.getUserName(),
                customer.getPassword(),
                customer.getMailId(),
                customer.getPhoneNo()
        );
        return new ResponseMessage(customersService.registerCustomer(entity));
    }
}
