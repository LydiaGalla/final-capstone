package com.techelevator.dao;

import com.techelevator.model.CakeOrder;

import java.util.List;

public interface OrderDao {

    List<CakeOrder> getAllCakeOrders();

}
