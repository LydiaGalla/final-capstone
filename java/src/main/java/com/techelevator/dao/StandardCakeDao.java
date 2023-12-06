package com.techelevator.dao;

import com.techelevator.model.StandardCake;

import java.util.List;

public interface StandardCakeDao {

    List<StandardCake> getAllStandardCakes();

    void updateStandardCakeAvailability(int standardCakeId, boolean isAvailable);
}
