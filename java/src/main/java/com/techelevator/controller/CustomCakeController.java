package com.techelevator.controller;

import com.techelevator.dao.CustomCakeDao;
import com.techelevator.model.CakeFillings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/api/customer/customcake/{standardCakeId}")
    public ResponseEntity<String> UpdateCakeFillingsAvailability(@PathVariable int FillingId, @RequestParam boolean isAvailable){
        customCakeDao.updateCakeFillingsAvailability(FillingId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }

}
