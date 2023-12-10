package com.techelevator.dao;

import java.time.LocalTime;
import com.techelevator.model.CakeOrder;
import com.techelevator.model.CustomCake;
import com.techelevator.model.StandardCake;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcOrderDao implements OrderDao {

    private final JdbcTemplate jdbcTemplate;


    private final CustomCakeDao customCakeDao;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate, CustomCakeDao customCakeDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.customCakeDao = customCakeDao;
    }

    @Override
    public List<CakeOrder> getAllCakeOrders() {
        List<CakeOrder> cakeOrders = new ArrayList<>();

        String sql = "SELECT * FROM cake_order ORDER BY customer_id ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {

            CakeOrder cakeOrder = mapToRowCakeOrder(results);

            cakeOrders.add(cakeOrder);
        }
        return cakeOrders;
    }

    @Override
    public CakeOrder getCakeOrderById(int id) {
        String sql ="SELECT * FROM cake_order WHERE order_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapToRowCakeOrder(results);
        }
        return null;
    }

    @Override
    public CakeOrder createNewCakeOrder(CakeOrder cakeToOrder) {
        String sql = "INSERT INTO cake_order (standard_cake_id, custom_cake_id, first_name, last_name, phone, due_date, due_time, writing, status, total) VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING order_id;";
        int orderId = jdbcTemplate.queryForObject(sql, Integer.class,
                cakeToOrder.getStandardCakeId(),
                cakeToOrder.getCustomCakeId(),
                cakeToOrder.getFirstName(),
                cakeToOrder.getLastName(),
                cakeToOrder.getPhone(),
                cakeToOrder.getDueDate(),
                LocalTime.of(8,0), //TODO: use cakeToOrder.getDueTime()
                cakeToOrder.getWriting(),
                cakeToOrder.getStatus(),
                cakeToOrder.getTotal());

        return getCakeOrderById(orderId);
    }
    @Override
    public CustomCake createNewCustomCake(CustomCake cakeToCreate) {
        String sql = "INSERT INTO custom_cake (cake_size_id, cake_flavor_id, cake_frosting_id, cake_filling_id, cake_style_id, extras, price_id) VALUES (?,?,?,?,?,?,?) RETURNING custom_cake_id;";

        int customCakeId = jdbcTemplate.queryForObject(sql, Integer.class,
                cakeToCreate.getCakeSizeId(),
                cakeToCreate.getCakeFlavorId(),
                cakeToCreate.getCakeFrostingId(),
                cakeToCreate.getCakeFillingId(),
                cakeToCreate.getCakeSizeId(),
                cakeToCreate.getExtras(),
                cakeToCreate.getPriceId());

        return customCakeDao.getCustomCakeById(customCakeId);
    }


    @Override
    public CakeOrder updateCakeOrderStatus(String status, int orderId) {

        CakeOrder cakeOrder = getCakeOrderById(orderId);

        String sql = "UPDATE cake_order SET status = ? WHERE order_id = ?;";
        if (status.equalsIgnoreCase("Completed")){
            jdbcTemplate.update(sql, status, orderId);
        }
        if (status.equalsIgnoreCase("Ready")){
            jdbcTemplate.update(sql, status, orderId);
        }
        if (status.equalsIgnoreCase("Cancelled")){
            jdbcTemplate.update(sql, status, orderId);
        }
        return getCakeOrderById(orderId);

    }

    private CakeOrder mapToRowCakeOrder(SqlRowSet results){
        CakeOrder cakeOrder = new CakeOrder();

        cakeOrder.setOrderId(results.getInt("order_id"));
        cakeOrder.setStandardCakeId(results.getInt("standard_cake_id"));
        cakeOrder.setCustomCakeId(results.getInt("custom_cake_id"));
        cakeOrder.setFirstName(results.getString("first_name"));
        cakeOrder.setLastName(results.getString("last_name"));
        cakeOrder.setPhone(results.getString("phone"));
        cakeOrder.setDueDate(Objects.requireNonNull(results.getDate("due_date")).toLocalDate());
        cakeOrder.setDueTime(Objects.requireNonNull(results.getTime("due_time")).toLocalTime());
        cakeOrder.setWriting(results.getString("writing"));
        cakeOrder.setStatus(results.getString("status"));
        cakeOrder.setTotal(results.getBigDecimal("total"));

        return cakeOrder;
    }
}
