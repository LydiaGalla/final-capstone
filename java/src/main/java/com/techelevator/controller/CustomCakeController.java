package com.techelevator.controller;

import com.techelevator.dao.CustomCakeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CakeFillings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.techelevator.model.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class CustomCakeController {

    private JdbcTemplate jdbcTemplate;
    private final CustomCakeDao customCakeDao;

    private final UserDao userDao;



    public CustomCakeController(JdbcTemplate jdbcTemplate, CustomCakeDao customCakeDao, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.customCakeDao = customCakeDao;
        this.userDao = userDao;

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
    @PutMapping("/customcake/flavors/{flavorId}")
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
    public CakeStyle getCakeStyleById(@PathVariable int id){
        return customCakeDao.getCakeStyleById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customcake/fillings/create")
    @PreAuthorize("isAuthenticated()")
    public CakeFillings createNewCakeFilling(@RequestBody CakeFillingDto cakeFillingDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeFillings cakeFillingToCreate = new CakeFillings();

        cakeFillingToCreate.setFillingName(cakeFillingDto.getFillingName());
        cakeFillingToCreate.setAvailable(cakeFillingDto.isAvailable());

        return customCakeDao.createNewCakeFilling(cakeFillingToCreate);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customcake/flavors/create")
    @PreAuthorize("isAuthenticated()")
    public CakeFlavors createNewCakeFlavor(@RequestBody CakeFlavorDto cakeFlavorDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeFlavors flavorToCreate = new CakeFlavors();

        flavorToCreate.setFlavorName(cakeFlavorDto.getFlavorName());
        flavorToCreate.setAvailable(cakeFlavorDto.isAvailable());

        return customCakeDao.createNewCakeFlavor(flavorToCreate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customcake/frostings/create")
    @PreAuthorize("isAuthenticated()")
    public CakeFrostings createNewCakeFrosting(@RequestBody CakeFrostingsDto cakeFrostingsDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeFrostings frostingToCreate = new CakeFrostings();

        frostingToCreate.setFrostingName(cakeFrostingsDto.getFrostingName());
        frostingToCreate.setAvailable(cakeFrostingsDto.isAvailable());

        return customCakeDao.createNewCakeFrosting(frostingToCreate);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customcake/cakesize/create")
    @PreAuthorize("isAuthenticated()")
    public CakeSizes createNewCakeSize(@RequestBody CakeSizeDto cakeSizeDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeSizes sizeToCreate = new CakeSizes();

        sizeToCreate.setSizeName(cakeSizeDto.getSizeName());
        sizeToCreate.setAvailable(cakeSizeDto.isAvailable());

        return customCakeDao.createNewCakeSize(sizeToCreate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customcake/cakestyle/create")
    @PreAuthorize("isAuthenticated()")
    public CakeStyle createNewCakeStyle(@RequestBody CakeStyleDto cakeStyleDto, Principal principal){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeStyle styleToCreate = new CakeStyle();

        styleToCreate.setStyleName(cakeStyleDto.getStyleName());
        styleToCreate.setAvailable(cakeStyleDto.isAvailable());

        return customCakeDao.createNewCakeStyle(styleToCreate);
    }

    @GetMapping("/customcake/{id}")
    public CustomCake getCustomCakeById(@PathVariable int id){
        String sql ="SELECT * FROM custom_cake WHERE custom_cake_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCustomCake(results);
        }
        return null;
    }

    private CustomCake mapToRowCustomCake(SqlRowSet results){
        CustomCake customCake = new CustomCake();

        customCake.setCustomCakeId(results.getInt("custom_cake_id"));
        customCake.setCakeSizeId(results.getInt("cake_size_id"));
        customCake.setCakeFlavorId(results.getInt("cake_flavor_id"));
        customCake.setCakeFrostingId(results.getInt("cake_frosting_id"));
        customCake.setCakeFillingId(results.getInt("cake_filling_id"));
        customCake.setCakeStyleId(results.getInt("cake_style_id"));
        customCake.setExtras(results.getString("extras"));
        customCake.setPriceId(results.getInt("price_id"));

        return customCake;
    }


}
