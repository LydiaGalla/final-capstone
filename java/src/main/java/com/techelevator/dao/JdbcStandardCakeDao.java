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
