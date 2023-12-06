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

    @Override
    public void updateCakeFillingsAvailability(int FillingId, boolean isAvailable) {
        String sql = "UPDATE cake_fillings SET is_available = ? WHERE filling_id = ?;";
        jdbcTemplate.update(sql, isAvailable, FillingId);
    }

    @Override
    public void updateCakeFlavorsAvailability(int FlavorId, boolean isAvailable) {
        String sql = "UPDATE cake_flavors SET is_available = ? WHERE flavor_id = ?;";
        jdbcTemplate.update(sql, isAvailable, FlavorId);
    }

    @Override
    public void updateCakeFrostingsAvailability(int FrostingId, boolean isAvailable) {
        String sql = "UPDATE cake_frostings SET is_available = ? WHERE frosting_id = ?;";
        jdbcTemplate.update(sql, isAvailable, FrostingId);
    }

    @Override
    public void updateCakeSizeAvailability(int SizeId, boolean isAvailable) {
        String sql = "UPDATE cake_sizes SET is_available = ? WHERE size_id = ?;";
        jdbcTemplate.update(sql, isAvailable, SizeId);
    }

    @Override
    public void updateCakeStyleAvailability(int StyleId, boolean isAvailable) {
        String sql = "UPDATE cake_style SET is_available = ? WHERE style_id = ?;";
        jdbcTemplate.update(sql, isAvailable, StyleId);
    }

    private CakeFillings mapToRowCakeFillings(SqlRowSet results){
        CakeFillings cakeFillings = new CakeFillings();

        cakeFillings.setFillingId(results.getInt("filling_id"));
        cakeFillings.setFillingName(results.getString("filling_name"));
        cakeFillings.setAvailable(results.getBoolean("is_available"));

        return cakeFillings;
    }
}
