package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.CakeOrder;
import com.techelevator.model.CakeOrderDto;
import com.techelevator.model.StandardCake;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    private final OrderDao orderDao;


    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping("/cakeorder")
    public List<CakeOrder> getAllCakeOrders() {
        return orderDao.getAllCakeOrders();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cakeorder/")
    public CakeOrder createNewCakeOrder(@RequestBody CakeOrderDto cakeOrderDto) {

        CakeOrder cakeOrderToCreate = new CakeOrder();

        cakeOrderToCreate.setStatus(cakeOrderDto.getStatus());
        cakeOrderToCreate.setDueDate(cakeOrderDto.getDueDate());
        cakeOrderToCreate.setDueTime(cakeOrderDto.getDueTime());
        cakeOrderToCreate.setQuantity(cakeOrderDto.getQuantity());
        cakeOrderToCreate.setTotal(cakeOrderDto.getTotal());

        return orderDao.createNewCakeOrder()

    }

    @GetMapping("/cakeorder/{id}")
    public CakeOrder getCakeOrderById(@PathVariable int id) {
        return orderDao.getCakeOrderById(id);
    }
}
