package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.model.StandardCake;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<StandardCake> getAllStandardCakes() {
        return customerDao.getAllStandardCakes();
    }
}
