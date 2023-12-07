package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.StandardCakeOrder;
import com.techelevator.model.StandardCakeOrderDto;
import org.springframework.http.HttpStatus;
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
    public List<StandardCakeOrder> getAllCakeOrders() {
        return orderDao.getAllCakeOrders();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cakeorder/create")
    public StandardCakeOrder createNewStandardCakeOrder(@RequestBody StandardCakeOrderDto standardCakeOrderDto) {

        StandardCakeOrder standardCakeOrderToCreate = new StandardCakeOrder();

        standardCakeOrderToCreate.setStandardCakeId(standardCakeOrderDto.getStandardCakeId());
        standardCakeOrderToCreate.setFirstName(standardCakeOrderDto.getFirstName());
        standardCakeOrderToCreate.setLastName(standardCakeOrderDto.getLastName());
        standardCakeOrderToCreate.setPhone(standardCakeOrderDto.getPhone());
        standardCakeOrderToCreate.setDueDate(standardCakeOrderDto.getDueDate());
        standardCakeOrderToCreate.setDueTime(standardCakeOrderDto.getDueTime());
        standardCakeOrderToCreate.setWriting(standardCakeOrderDto.getWriting());
        standardCakeOrderToCreate.setStatus(standardCakeOrderDto.getStatus());
        standardCakeOrderToCreate.setTotal(standardCakeOrderDto.getTotal());

        return orderDao.createNewStandardCakeOrder(standardCakeOrderToCreate);

    }

    @GetMapping("/cakeorder/{id}")
    public StandardCakeOrder getCakeOrderById(@PathVariable int id) {
        return orderDao.getCakeOrderById(id);
    }
}
