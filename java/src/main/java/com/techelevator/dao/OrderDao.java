package com.techelevator.dao;


import com.techelevator.model.CakeOrder;
import com.techelevator.model.CustomCake;

import java.util.List;

public interface OrderDao {

    List<CakeOrder> getAllCakeOrders();

    CakeOrder getCakeOrderById(int id);

    CakeOrder createNewCakeOrder(CakeOrder cakeToOrder);

    CakeOrder updateCakeOrderStatus(String status, int orderId);

    CustomCake createNewCustomCake(CustomCake cakeToCreate);

}
