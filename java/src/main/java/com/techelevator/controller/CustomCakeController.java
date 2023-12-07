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

    @GetMapping("/customcake/fillings")
    public List<CakeFillings> getAllCakeFillings(){
        return customCakeDao.getAllCakeFillings();
    }
    @GetMapping("/customcake/flavors")
    public List<CakeFlavors> getAllCakeFlavors(){
        return customCakeDao.getAllCakeFlavors();
    }

    @GetMapping("/customcake/frostings")
    public List<CakeFrostings> getAllCakeFrostings(){
        return customCakeDao.getAllCakeFrostings();
    }

    @GetMapping("/customcake/cakesize")
    public List<CakeSizes> getAllCakeSizes(){
        return customCakeDao.getAllCakeSizes();
    }

    @GetMapping("/customcake/cakestyle")
    public List<CakeStyle> getAllCakeStyles(){
        return customCakeDao.getAllCakeStyles();
    }
    @PutMapping("/customcake/fillings/{fillingId}")
    public ResponseEntity<String> updateCakeFillingsAvailability(@PathVariable int fillingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFillingsAvailability(fillingId, isAvailable);
        return ResponseEntity.ok("Filling availability updated successfully");
    }
    @PutMapping("/customcake/flavors/{flavorsId}")
    public ResponseEntity<String> updateCakeFlavorsAvailability(@PathVariable int flavorId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFlavorsAvailability(flavorId, isAvailable);
        return ResponseEntity.ok("Flavor availability updated successfully");
    }
    @PutMapping("/customcake/frostings/{frostingId}")
    public ResponseEntity<String> updateCakeFrostingsAvailability(@PathVariable int frostingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFrostingsAvailability(frostingId, isAvailable);
        return ResponseEntity.ok("Frosting availability updated successfully");
    }
    @PutMapping("/customcake/cakesize/{sizeId}")
    public ResponseEntity<String> updateCakeSizeAvailability(@PathVariable int sizeId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeSizeAvailability(sizeId, isAvailable);
        return ResponseEntity.ok("Size availability updated successfully");
    }
    @PutMapping("/customcake/cakestyle/{styleId}")
    public ResponseEntity<String> updateCakeStyleAvailability(@PathVariable int styleId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeStyleAvailability(styleId, isAvailable);
        return ResponseEntity.ok("Style availability updated successfully");
    }
    @GetMapping("/customcake/fillings/{id}")
    public CakeFillings getCakeFillingById(@PathVariable int id){
        return customCakeDao.getCakeFillingById(id);
    }
    @GetMapping("/customcake/flavors/{id}")
    public CakeFlavors getCakeFlavorById(@PathVariable int id){
        return customCakeDao.getCakeFlavorById(id);
    }
    @GetMapping("/customcake/frostings/{id}")
    public CakeFrostings getFrostingById(@PathVariable int id){
        return customCakeDao.getCakeFrostingById(id);
    }
    @GetMapping("/customcake/cakesize/{id}")
    public CakeSizes getCakeSizeById(@PathVariable int id){
        return customCakeDao.getCakeSizeById(id);
    }
    @GetMapping("/customcake/cakestyle/{id}")
    public CakeStyle getCakeStyleById(int id){
        return customCakeDao.getCakeStyleById(id);
    }
}
