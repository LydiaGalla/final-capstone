package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    private final OrderDao orderDao;

    private final UserDao userDao;



    public OrderController(OrderDao orderDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
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

    @PostMapping("/cakeorder/customcake")
    public CustomCake createNewCustomCake(@RequestBody CustomCakeDto customCakeDto) {

        CustomCake cakeToCreate = new CustomCake();

        cakeToCreate.setCakeSizeId(customCakeDto.getCakeSizeId());
        cakeToCreate.setCakeFlavorId(customCakeDto.getCakeFlavorId());
        cakeToCreate.setCakeFrostingId(customCakeDto.getCakeFrostingId());
        cakeToCreate.setCakeFillingId(customCakeDto.getCakeFillingId());
        cakeToCreate.setCakeStyleId(customCakeDto.getCakeStyleId());
        cakeToCreate.setExtras(customCakeDto.getExtras());
        cakeToCreate.setPriceId(customCakeDto.getPriceId());

        return orderDao.createNewCustomCake(cakeToCreate);
    }

    @PutMapping("/cakeorder/{orderId}/status")
    public CakeOrder updateCakeOrderStatus(@RequestBody CakeOrderStatusUpdateDto cakeOrderStatusUpdateDto, Principal principal, @PathVariable int orderId){
        String username = principal.getName();
        User loggedInUser = userDao.getUserByUsername(username);

        CakeOrder cakeOrderToUpdate = getCakeOrderById(orderId);
        String completed = "Completed";
        String ready = "Ready";
        String cancelled = "Cancelled";

        if(cakeOrderToUpdate.getOrderId() == orderId && cakeOrderStatusUpdateDto.getStatus().equalsIgnoreCase("Completed")){
            cakeOrderToUpdate.setStatus(completed);
        }
        if(cakeOrderToUpdate.getOrderId() == orderId && cakeOrderStatusUpdateDto.getStatus().equalsIgnoreCase("Ready")){
            cakeOrderToUpdate.setStatus(ready);
        }
        if(cakeOrderToUpdate.getOrderId() == orderId && cakeOrderStatusUpdateDto.getStatus().equalsIgnoreCase("Cancelled")){
            cakeOrderToUpdate.setStatus(cancelled);
        }

        orderDao.updateCakeOrderStatus(cakeOrderToUpdate.getStatus(), orderId);
        return cakeOrderToUpdate;
    }
}
