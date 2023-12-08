package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.CakeStatusUpdateDto;
import com.techelevator.model.StandardCakeOrder;
import com.techelevator.model.StandardCakeOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    private final OrderDao orderDao;

    private final CakeStatusUpdateDto cakeStatusUpdateDto;


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
    @PutMapping("/standardcakeorder/{standardCakeOrderId}")
    public ResponseEntity<String> updateStandardCakeAvailability(@PathVariable int orderId, @RequestParam String status){
        orderDao.updateStandardCakeOrderStatus(orderId, status);

        StandardCakeOrder standardCakeOrder = getCakeOrderById(orderId);
        String pending = "Pending";
        String ready = "Ready";
        String cancelled = "Cancelled";
        String completed = "Completed";

        if (standardCakeOrder.getStatus().equalsIgnoreCase(pending)) {

        } else if (standardCakeOrder.getStatus().equalsIgnoreCase(ready)) {

        } else if (standardCakeOrder.getStatus().equalsIgnoreCase(cancelled)) {

        } else if (standardCakeOrder.getStatus().equalsIgnoreCase(completed)) {

        }

        return ResponseEntity.ok("Standard cake order status updated successfully");
    }
    }
}
