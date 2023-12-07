package com.techelevator.dao;

import com.techelevator.model.StandardCake;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStandardCakeDao implements StandardCakeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStandardCakeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<StandardCake> getAllStandardCakes() {
        List<StandardCake> standardCakes = new ArrayList<>();

        String sql = "SELECT * FROM standard_cake ORDER BY cake_name ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            StandardCake standardCake = mapToRowStandardCake(results);

            standardCakes.add(standardCake);

        }

        return standardCakes;
    }

    @Override
    public void updateStandardCakeAvailability(int standardCakeId, boolean isAvailable) {
        String sql = "UPDATE standard_cake SET is_available = ? WHERE standard_cake_id = ?;";
        jdbcTemplate.update(sql, isAvailable, standardCakeId);
    }

    @Override
    public StandardCake createNewStandardCake(StandardCake cakeToCreate) {
        String sql ="INSERT INTO standard_cake (cake_name, description, price, is_available) VALUES (?,?,?,?) RETURNING standard_cake_id;";

        int standardCakeId =jdbcTemplate.queryForObject(sql, Integer.class,
                cakeToCreate.getCakeName(),
                cakeToCreate.getDescription(),
                cakeToCreate.getPrice(),
                cakeToCreate.isAvailable());

        return getStandardCakeById(standardCakeId);

    }

    @Override
    public StandardCake getStandardCakeById(int id) {
        String sql ="SELECT * FROM standard_cake WHERE standard_cake_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()){
                return mapToRowStandardCake(results);
        }
        return null;
    }



    private StandardCake mapToRowStandardCake(SqlRowSet results){
        StandardCake standardCake = new StandardCake();

        standardCake.setStandardCakeId(results.getInt("standard_cake_id"));
        standardCake.setCakeName(results.getString("cake_name"));
        standardCake.setDescription(results.getString("description"));
        standardCake.setPrice(results.getBigDecimal("price"));
        standardCake.setAvailable(results.getBoolean("is_available"));

        return standardCake;
    }
}
