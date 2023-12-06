package com.techelevator.controller;

import com.techelevator.dao.StandardCakeDao;
import com.techelevator.model.StandardCake;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StandardCakeController {

    private final StandardCakeDao standardCakeDao;

    public StandardCakeController(StandardCakeDao standardCakeDao) {
        this.standardCakeDao = standardCakeDao;
    }
    @GetMapping("/api/customer/standardcake")
    public List<StandardCake> getAllStandardCakes() {
        return standardCakeDao.getAllStandardCakes();
    }
}
