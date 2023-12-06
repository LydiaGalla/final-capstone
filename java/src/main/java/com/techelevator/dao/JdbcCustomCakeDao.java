package com.techelevator.dao;

import com.techelevator.model.CakeOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCustomCakeDao implements CustomCakeDao {
    @Override
    public List<CakeOrder> getOrderId() {
        return null;
    }
}
