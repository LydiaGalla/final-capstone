package com.techelevator.controller;

import com.techelevator.dao.StandardCakeDao;

import com.techelevator.dao.UserDao;
import com.techelevator.model.StandardCake;
import com.techelevator.model.StandardCakeDto;

import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class StandardCakeController {

    private final StandardCakeDao standardCakeDao;

    private final UserDao userDao;

    public StandardCakeController(StandardCakeDao standardCakeDao, UserDao userDao) {
        this.standardCakeDao = standardCakeDao;
        this.userDao = userDao;
    }

    @GetMapping("/standardcake")
    public List<StandardCake> getAllStandardCakes() {
        return standardCakeDao.getAllStandardCakes();
    }

    @PutMapping("/standardcake/{standardCakeId}")
    public ResponseEntity<String> updateStandardCakeAvailability(@PathVariable int standardCakeId, @RequestParam boolean isAvailable){
        standardCakeDao.updateStandardCakeAvailability(standardCakeId, isAvailable);
        return ResponseEntity.ok("Standard cake availability updated successfully");
    }

    @GetMapping("/standardcake/{id}")
    public StandardCake getStandardCakeById(@PathVariable int id){
        return standardCakeDao.getStandardCakeById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/standardcake/create")
    @PreAuthorize("isAuthenticated()")
    public StandardCake createNewStandardCake(@RequestBody StandardCakeDto standardCakeDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);


        StandardCake standardCakeToCreate = new StandardCake();

        standardCakeToCreate.setCakeName(standardCakeDto.getCakeName());
        standardCakeToCreate.setDescription(standardCakeDto.getDescription());
        standardCakeToCreate.setDescription(standardCakeDto.getDescription());
        standardCakeToCreate.setPrice(standardCakeDto.getPrice());
        standardCakeToCreate.setImg(standardCakeDto.getImg());
        standardCakeToCreate.setAvailable(standardCakeDto.isAvailable());

        return standardCakeDao.createNewStandardCake(standardCakeToCreate);

    }

}
