package com.techelevator.controller;

import com.techelevator.dao.CustomCakeDao;
import com.techelevator.model.CakeFillings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomCakeController {

    private final CustomCakeDao customCakeDao;

    public CustomCakeController(CustomCakeDao customCakeDao) {
        this.customCakeDao = customCakeDao;
    }

    @GetMapping("/api/customer/customcake")
    public List<CakeFillings> getAllCakeFillings(){
        return customCakeDao.getAllCakeFillings();
    }
}
