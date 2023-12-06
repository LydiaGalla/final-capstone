package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface CustomCakeDao {

    List<CakeFillings> getAllCakeFillings();

    List<CakeFlavors> getAllCakeFlavors();

    List<CakeFrostings> getAllCakeFrostings();

    List<CakeSizes> getAllCakeSizes();

    List<CakeStyle> getAllCakeStyles();



}
