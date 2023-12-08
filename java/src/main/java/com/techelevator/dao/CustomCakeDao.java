package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface CustomCakeDao {

    List<CakeFillings> getAllCakeFillings();


    void updateCakeFillingsAvailability(int fillingId, boolean isAvailable);

    void updateCakeFlavorsAvailability(int flavorId, boolean isAvailable);

    void updateCakeFrostingsAvailability(int frostingId, boolean isAvailable);

    void updateCakeSizeAvailability(int sizeId, boolean isAvailable);

    void updateCakeStyleAvailability(int styleId, boolean isAvailable);

    List<CakeFlavors> getAllCakeFlavors();

    List<CakeFrostings> getAllCakeFrostings();

    List<CakeSizes> getAllCakeSizes();

    List<CakeStyle> getAllCakeStyles();

    CakeFillings getCakeFillingById(int id);

    CakeFlavors getCakeFlavorById(int id);

    CakeFrostings getCakeFrostingById(int id);

    CakeSizes getCakeSizeById(int id);

    CakeStyle getCakeStyleById(int id);

    CakeFillings createNewCakeFilling(CakeFillings fillingToCreate);

    CakeFlavors createNewCakeFlavor(CakeFlavors flavorToCreate);

    CakeFrostings createNewCakeFrosting(CakeFrostings frostingToCreate);

    CakeSizes createNewCakeSize(CakeSizes sizeToCreate);

    CakeStyle createNewCakeStyle(CakeStyle styleToCreate);

    CustomCake getCustomCakeById(int id);





}
