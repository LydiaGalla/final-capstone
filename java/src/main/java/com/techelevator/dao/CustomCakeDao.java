package com.techelevator.dao;

import com.techelevator.model.CakeFillings;
import com.techelevator.model.CakeOrder;

import java.util.List;

public interface CustomCakeDao {

    List<CakeFillings> getAllCakeFillings();

    void updateCakeFillingsAvailability(int FillingId, boolean isAvailable);

    void updateCakeFlavorsAvailability(int FlavorId, boolean isAvailable);

    void updateCakeFrostingsAvailability(int FrostingId, boolean isAvailable);

    void updateCakeSizeAvailability(int SizeId, boolean isAvailable);

    void updateCakeStyleAvailability(int StyleId, boolean isAvailable);





}
