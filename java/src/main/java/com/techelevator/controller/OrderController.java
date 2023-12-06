package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.CakeOrder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    private final OrderDao orderDao;


    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping("/cakeorder")
    public List<CakeOrder> getAllCakeOrders(){
        return orderDao.getAllCakeOrders();
    }
}
