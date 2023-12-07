package com.techelevator.dao;


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
    public void updateCakeFillingsAvailability(int fillingId, boolean isAvailable) {
        String sql = "UPDATE cake_fillings SET is_available = ? WHERE filling_id = ?;";
        jdbcTemplate.update(sql, isAvailable, fillingId);
    }

    @Override
    public void updateCakeFlavorsAvailability(int flavorId, boolean isAvailable) {
        String sql = "UPDATE cake_flavors SET is_available = ? WHERE flavor_id = ?;";
        jdbcTemplate.update(sql, isAvailable, flavorId);
    }

    @Override
    public void updateCakeFrostingsAvailability(int frostingId, boolean isAvailable) {
        String sql = "UPDATE cake_frostings SET is_available = ? WHERE frosting_id = ?;";
        jdbcTemplate.update(sql, isAvailable, frostingId);
    }

    @Override
    public void updateCakeSizeAvailability(int sizeId, boolean isAvailable) {
        String sql = "UPDATE cake_sizes SET is_available = ? WHERE size_id = ?;";
        jdbcTemplate.update(sql, isAvailable, sizeId);
    }

    @Override
    public void updateCakeStyleAvailability(int styleId, boolean isAvailable) {
        String sql = "UPDATE cake_style SET is_available = ? WHERE style_id = ?;";
        jdbcTemplate.update(sql, isAvailable, styleId);
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

    @Override
    public CakeFillings getCakeFillingById(int id) {
        String sql = "SELECT * FROM cake_fillings WHERE filling_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCakeFillings(results);
        }
        return null;
    }

    @Override
    public CakeFlavors getCakeFlavorById(int id) {
        String sql = "SELECT * FROM cake_flavors WHERE flavor_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCakeFlavors(results);
        }
        return null;
    }

    @Override
    public CakeFrostings getCakeFrostingById(int id) {
        String sql = "SELECT * FROM cake_frostings WHERE frosting_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCakeFrostings(results);
        }
        return null;
    }

    @Override
    public CakeSizes getCakeSizeById(int id) {
        String sql = "SELECT * FROM cake_sizes WHERE size_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCakeSizes(results);
        }
        return null;
    }

    @Override
    public CakeStyle getCakeStyleById(int id) {
        String sql = "SELECT * FROM cake_style WHERE style_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            return mapToRowCakeStyle(results);
        }
        return null;
    }

    @Override
    public CakeFillings createNewCakeFilling(CakeFillings fillingToCreate) {
        String sql = "INSERT INTO cake_fillings (filling_name, is_available) VALUES (?,?) RETURNING filling_id;";

        int fillingId = jdbcTemplate.queryForObject(sql, Integer.class,
                fillingToCreate.getFillingName(),
                fillingToCreate.isAvailable());

        return getCakeFillingById(fillingId);
    }

    @Override
    public CakeFlavors createNewCakeFlavor(CakeFlavors flavorToCreate) {
        String sql = "INSERT INTO cake_flavors (flavor_name, is_available) VALUES (?,?) RETURNING flavor_id;";

        int flavorId = jdbcTemplate.queryForObject(sql, Integer.class,
                flavorToCreate.getFlavorName(),
                flavorToCreate.isAvailable());

        return getCakeFlavorById(flavorId);
    }

    @Override
    public CakeFrostings createNewCakeFrosting(CakeFrostings frostingToCreate) {
        String sql = "INSERT INTO cake_frostings (frosting_name, is_available) VALUES(?,?) RETURNING frosting_id;";

        int frostingId = jdbcTemplate.queryForObject(sql, Integer.class,
                frostingToCreate.getFrostingName(),
                frostingToCreate.isAvailable());

        return getCakeFrostingById(frostingId);
    }

    @Override
    public CakeSizes createNewCakeSize(CakeSizes sizeToCreate) {
        String sql = "INSERT INTO cake_sizes (size_name, is_available) VALUES (?,?) RETURNING size_id;";

        int sizeId = jdbcTemplate.queryForObject(sql, Integer.class,
                sizeToCreate.getSizeName(),
                sizeToCreate.isAvailable());

        return getCakeSizeById(sizeId);
    }

    @Override
    public CakeStyle createNewCakeStyle(CakeStyle styleToCreate) {
        String sql = "INSERT INTO cake_style (style_name, is_avaialable) VALUES (?,?) RETURNING style_id;";

        int styleId = jdbcTemplate.queryForObject(sql, Integer.class,
                styleToCreate.getStyleName(),
                styleToCreate.isAvailable());

        return getCakeStyleById(styleId);
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
   public List<CakeFlavors> getAllCakeFlavors() {
       List<CakeFlavors> cakeFlavors = new ArrayList<>();
       String sql = "SELECT * FROM cake_flavors ORDER BY flavor_name ASC;";

       SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

       while (results.next()) {

           CakeFlavors cakeFlavor = mapToRowCakeFlavors(results);

           cakeFlavors.add(cakeFlavor);
       }
       return cakeFlavors;
   }

}
