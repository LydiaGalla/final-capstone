package com.techelevator.dao;

import com.techelevator.model.CustomCake;
import com.techelevator.model.StandardCake;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class JdbcCustomerDao implements CustomerDao{

    @Override
    public List<StandardCake> getCakeName() {
        return null;
    }


}
