package com.techelevator.dao;

import ch.qos.logback.core.util.COWArrayList;
import com.techelevator.model.*;
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
    public List<CakeFlavors> getAllCakeFlavors() {
        List<CakeFlavors> cakeFlavors = new ArrayList<>();

        String sql = "SELECT * FROM cake_flavors ORDER BY flavor_name ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeFlavors cakeFlavor = mapToRowCakeFlavors(results);

            cakeFlavors.add(cakeFlavor);
        }
        return cakeFlavors;
    }

    @Override
    public List<CakeFrostings> getAllCakeFrostings() {
        List<CakeFrostings> cakeFrostings = new ArrayList<>();

        String sql = "SELECT * FROM cake_frostings ORDER BY frosting_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeFrostings cakeFrosting = mapToRowCakeFrostings(results);

            cakeFrostings.add(cakeFrosting);
        }

        return cakeFrostings;
    }

    @Override
    public List<CakeSizes> getAllCakeSizes() {
        List<CakeSizes> cakeSizes = new ArrayList<>();

        String sql = "SELECT * FROM cake_sizes ORDER BY size_name ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeSizes cakeSize = mapToRowCakeSizes(results);

            cakeSizes.add(cakeSize);
        }

        return cakeSizes;
    }

    @Override
    public List<CakeStyle> getAllCakeStyles() {
        List<CakeStyle> cakeStyles = new ArrayList<>();

        String sql = "SELECT * FROM cake_style ORDER BY style_name ASC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){

            CakeStyle cakeStyle = mapToRowCakeStyle(results);

            cakeStyles.add(cakeStyle);

        }
        return cakeStyles;
    }

    private CakeFillings mapToRowCakeFillings(SqlRowSet results){
        CakeFillings cakeFillings = new CakeFillings();

        cakeFillings.setFillingId(results.getInt("filling_id"));
        cakeFillings.setFillingName(results.getString("filling_name"));
        cakeFillings.setAvailable(results.getBoolean("is_available"));

        return cakeFillings;
    }

    private CakeFlavors mapToRowCakeFlavors(SqlRowSet results){
        CakeFlavors cakeFlavors = new CakeFlavors();

        cakeFlavors.setFlavorId(results.getInt("flavor_id"));
        cakeFlavors.setFlavorName(results.getString("flavor_name"));
        cakeFlavors.setAvailable(results.getBoolean("is_available"));

        return cakeFlavors;
    }

   private CakeFrostings mapToRowCakeFrostings(SqlRowSet results){
        CakeFrostings cakeFrostings = new CakeFrostings();

        cakeFrostings.setFrostingId(results.getInt("frosting_id"));
        cakeFrostings.setFrostingName(results.getString("frosting_name"));
        cakeFrostings.setAvailable(results.getBoolean("is_available"));

        return cakeFrostings;
   }

   private CakeSizes mapToRowCakeSizes(SqlRowSet results){
        CakeSizes cakeSizes = new CakeSizes();

        cakeSizes.setSizeId(results.getInt("size_id"));
        cakeSizes.setSizeName(results.getString("size_name"));
        cakeSizes.setAvailable(results.getBoolean("is_available"));

        return cakeSizes;
   }

   private CakeStyle mapToRowCakeStyle(SqlRowSet results){
        CakeStyle cakeStyle = new CakeStyle();

        cakeStyle.setStyleId(results.getInt("style_id"));
        cakeStyle.setStyleName(results.getString("style_name"));
        cakeStyle.setAvailable(results.getBoolean("is_available"));

        return cakeStyle;
   }
}
