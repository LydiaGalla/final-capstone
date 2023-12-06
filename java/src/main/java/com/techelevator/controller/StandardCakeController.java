package com.techelevator.controller;

import com.techelevator.dao.StandardCakeDao;
import com.techelevator.model.StandardCake;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/customer/standardcake/{standardCakeId}")
    public ResponseEntity<String> updateStandardCakeAvailability(@PathVariable int standardCakeId, @RequestParam boolean isAvailable){
        standardCakeDao.updateStandardCakeAvailability(standardCakeId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }

}
