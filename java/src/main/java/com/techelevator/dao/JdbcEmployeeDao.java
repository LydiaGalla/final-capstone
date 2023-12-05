package com.techelevator.dao;

import com.techelevator.model.CakeOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class JdbcEmployeeDao implements EmployeeDao{
    @Override
    public List<CakeOrder> getOrderId() {
        return null;
    }
}
