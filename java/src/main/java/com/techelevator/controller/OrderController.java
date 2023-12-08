package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.model.CakeOrder;
import com.techelevator.model.CakeOrderDto;
import com.techelevator.model.CustomCake;
import com.techelevator.model.CustomCakeDto;
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
}
