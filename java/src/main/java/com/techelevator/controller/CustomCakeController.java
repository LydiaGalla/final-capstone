package com.techelevator.controller;

import com.techelevator.dao.CustomCakeDao;
import com.techelevator.model.CakeFillings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techelevator.model.*;
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

    @GetMapping("/api/customer/customcake/fillings")
    public List<CakeFillings> getAllCakeFillings(){
        return customCakeDao.getAllCakeFillings();
    }
    @PutMapping("/api/customer/customcake/{standardCakeId}")
    public ResponseEntity<String> UpdateCakeFillingsAvailability(@PathVariable int FillingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFillingsAvailability(FillingId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
    @GetMapping("/api/customer/customcake/flavors")
    public List<CakeFlavors> getAllCakeFlavors(){
        return customCakeDao.getAllCakeFlavors();
    }

    @GetMapping("/api/customer/customcake/frostings")
    public List<CakeFrostings> getAllCakeFrostings(){
        return customCakeDao.getAllCakeFrostings();
    }

    @GetMapping("/api/customer/customcake/cakesize")
    public List<CakeSizes> getAllCakeSizes(){
        return customCakeDao.getAllCakeSizes();
    }

    @GetMapping("/api/customer/customcake/cakestyle")
    public List<CakeStyle> getAllCakeStyles(){
        return customCakeDao.getAllCakeStyles();
    }

}
