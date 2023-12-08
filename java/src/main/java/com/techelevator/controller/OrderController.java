package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.CakeOrder;
import com.techelevator.model.CakeOrderDto;
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
    @PostMapping("/cakeorder/create")
    public CakeOrder createNewCakeOrder(@RequestBody CakeOrderDto cakeOrderDto) {

        CakeOrder cakeOrderToCreate = new CakeOrder();

        cakeOrderToCreate.setStandardCakeId(cakeOrderDto.getStandardCakeId());
        cakeOrderToCreate.setCustomCakeId(cakeOrderDto.getCustomCakeId());
        cakeOrderToCreate.setFirstName(cakeOrderDto.getFirstName());
        cakeOrderToCreate.setLastName(cakeOrderDto.getLastName());
        cakeOrderToCreate.setPhone(cakeOrderDto.getPhone());
        cakeOrderToCreate.setDueDate(cakeOrderDto.getDueDate());
        cakeOrderToCreate.setDueTime(cakeOrderDto.getDueTime());
        cakeOrderToCreate.setWriting(cakeOrderDto.getWriting());
        cakeOrderToCreate.setStatus(cakeOrderDto.getStatus());
        cakeOrderToCreate.setTotal(cakeOrderDto.getTotal());

        return orderDao.createNewCakeOrder(cakeOrderToCreate);

    }

    @GetMapping("/cakeorder/{id}")
    public CakeOrder getCakeOrderById(@PathVariable int id) {
        return orderDao.getCakeOrderById(id);
    }
    @PutMapping("/standardcakeorder/{standardCakeOrderId}")
    public ResponseEntity<String> updateStandardCakeAvailability(@PathVariable int orderId, @RequestParam String status){
        orderDao.updateStandardCakeOrderStatus(orderId, status);

        CakeOrder standardCakeOrder = getCakeOrderById(orderId);
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
