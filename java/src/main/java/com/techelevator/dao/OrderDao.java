package com.techelevator.dao;


import com.techelevator.model.StandardCake;
import com.techelevator.model.StandardCakeOrder;

import java.util.List;

public interface OrderDao {

    List<StandardCakeOrder> getAllCakeOrders();

    StandardCakeOrder getCakeOrderById(int id);

    StandardCakeOrder createNewStandardCakeOrder(StandardCakeOrder cakeToOrder);


}
