package com.techelevator.dao;

import com.techelevator.model.CakeOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcOrderDao implements OrderDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CakeOrder> getAllCakeOrders() {
        List<CakeOrder> cakeOrders = new ArrayList<>();

        String sql = "SELECT * FROM cake_order ORDER BY customer_id ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeOrder cakeOrder = mapToRowCakeOrder(results);

            cakeOrders.add(cakeOrder);
        }
        return cakeOrders;
    }

    private CakeOrder mapToRowCakeOrder(SqlRowSet results){
        CakeOrder cakeOrder = new CakeOrder();

        cakeOrder.setOrderId(results.getInt("order_id"));
        cakeOrder.setCustomerId(results.getInt("customer_id"));
        cakeOrder.setStandardCakeId(results.getInt("standard_cake_id"));
        cakeOrder.setCustomCakeId(results.getInt("custom_cake_id"));
        cakeOrder.setDueDate(Objects.requireNonNull(results.getDate("due_date")).toLocalDate());
        cakeOrder.setDueTime(Objects.requireNonNull(results.getTime("due_time")).toLocalTime());
        cakeOrder.setWriting(results.getString("writing"));
        cakeOrder.setStatus(results.getString("status"));
        cakeOrder.setQuantity(results.getInt("quantity"));
        cakeOrder.setTotal(results.getBigDecimal("total"));

        return cakeOrder;
    }
}
