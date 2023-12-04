package com.techelevator.dao;

import com.techelevator.model.CustomCake;
import com.techelevator.model.StandardCake;

import java.util.List;

public interface CustomerDao {

    List<StandardCake> getCakeName();

    List<CustomCake> getCakeStyle();

    List<CustomCake> getCakeSize();

    List<CustomCake> getCakeFlavor();

    List<CustomCake> getFrostingFlavor();

    List<CustomCake> getFillingFLavor();

    List<CustomCake> getExtras();




}
