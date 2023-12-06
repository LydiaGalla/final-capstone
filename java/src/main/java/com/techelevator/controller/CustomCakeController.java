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
    @PutMapping("/api/customer/customcake/fillings/{fillingId}")
    public ResponseEntity<String> UpdateCakeFillingsAvailability(@PathVariable int fillingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFillingsAvailability(fillingId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
    @PutMapping("/api/customer/customcake/{flavorsid}")
    public ResponseEntity<String> UpdateCakeFlavorsAvailability(@PathVariable int flavorId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFlavorsAvailability(flavorId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
    @PutMapping("/api/customer/customcake/{frostingid}")
    public ResponseEntity<String> UpdateCakeFrostingsAvailability(@PathVariable int frostingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFrostingsAvailability(frostingId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
    @PutMapping("/api/customer/customcake/{sizeid}")
    public ResponseEntity<String> updateCakeSizeAvailability(@PathVariable int sizeId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeSizeAvailability(sizeId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
    @PutMapping("/api/customer/customcake/{styleid}")
    public ResponseEntity<String> UpdateCakeStyleAvailability(@PathVariable int sizeId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeStyleAvailability(sizeId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }
}
