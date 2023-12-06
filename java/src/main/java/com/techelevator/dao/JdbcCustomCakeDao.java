package com.techelevator.dao;

import com.techelevator.model.CakeFillings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCustomCakeDao implements CustomCakeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomCakeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CakeFillings> getAllCakeFillings() {
        List<CakeFillings> cakeFillings = new ArrayList<>();

        String sql = "SELECT * FROM cake_fillings ORDER BY filling_name ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeFillings cakeFilling = mapToRowCakeFillings(results);

            cakeFillings.add(cakeFilling);
        }

        return cakeFillings;
    }

    private CakeFillings mapToRowCakeFillings(SqlRowSet results){
        CakeFillings cakeFillings = new CakeFillings();

        cakeFillings.setFillingId(results.getInt("filling_id"));
        cakeFillings.setFillingName(results.getString("filling_name"));
        cakeFillings.setAvailable(results.getBoolean("is_available"));

        return cakeFillings;
    }
}
