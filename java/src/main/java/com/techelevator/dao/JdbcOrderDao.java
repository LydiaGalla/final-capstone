package com.techelevator.dao;

import com.techelevator.model.StandardCakeOrder;
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
    public List<StandardCakeOrder> getAllCakeOrders() {
        List<StandardCakeOrder> standardCakeOrders = new ArrayList<>();

        String sql = "SELECT * FROM cake_order ORDER BY customer_id ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            StandardCakeOrder standardCakeOrder = mapToRowCakeOrder(results);

            standardCakeOrders.add(standardCakeOrder);
        }
        return standardCakeOrders;
    }

    @Override
    public StandardCakeOrder getCakeOrderById(int id) {
        String sql ="SELECT * FROM cake_order WHERE order_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()){
            return mapToRowCakeOrder(results);
        }
        return null;
    }

    @Override
    public StandardCakeOrder createNewStandardCakeOrder(StandardCakeOrder cakeToOrder) {
        String sql = "INSERT INTO standard_cake_order (standard_cake_id, first_name, last_name, phone, due_date, due_time, writing, status, total) VALUES (?,?,?,?,?,?,?,?,?) RETURNING order_id;";
            int orderId = jdbcTemplate.queryForObject(sql, Integer.class,
                    cakeToOrder.getStandardCakeId(),
                    cakeToOrder.getFirstName(),
                    cakeToOrder.getLastName(),
                    cakeToOrder.getPhone(),
                    cakeToOrder.getDueDate(),
                    cakeToOrder.getDueTime(),
                    cakeToOrder.getWriting(),
                    cakeToOrder.getStatus(),
                    cakeToOrder.getTotal());

            return getCakeOrderById(orderId);
    }



    private StandardCakeOrder mapToRowCakeOrder(SqlRowSet results){
        StandardCakeOrder standardCakeOrder = new StandardCakeOrder();

        standardCakeOrder.setOrderId(results.getInt("order_id"));
        standardCakeOrder.setStandardCakeId(results.getInt("standard_cake_id"));
        standardCakeOrder.setFirstName(results.getString("first_name"));
        standardCakeOrder.setLastName(results.getString("last_name"));
        standardCakeOrder.setPhone(results.getString("phone"));
        standardCakeOrder.setDueDate(Objects.requireNonNull(results.getDate("due_date")).toLocalDate());
        standardCakeOrder.setDueTime(Objects.requireNonNull(results.getTime("due_time")).toLocalTime());
        standardCakeOrder.setWriting(results.getString("writing"));
        standardCakeOrder.setStatus(results.getString("status"));
        standardCakeOrder.setTotal(results.getBigDecimal("total"));

        return standardCakeOrder;
    }
}
