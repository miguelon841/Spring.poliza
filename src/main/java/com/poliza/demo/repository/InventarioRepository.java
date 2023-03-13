package com.poliza.demo.repository;

import com.poliza.demo.model.InventarioModel;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventarioRepository implements  iInventarioRepository{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<InventarioModel> findAll() {
        String SP = "EXEC selectAllInventario";
        var result = jdbcTemplate.query(SP, BeanPropertyRowMapper.newInstance(InventarioModel.class));
        return result;
    }

    @Override
    public int save(InventarioModel Inventario) {
        String SP = "EXEC SaveInventario ?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Inventario.getSKU(),Inventario.getNombre(),Inventario.getCantidad()});
        System.out.println(result);
        return result;
    }

    @Override
    public int update(InventarioModel Inventario) {
        String SP = "EXEC UpdateInventario  ?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Inventario.getSKU(),Inventario.getNombre(),Inventario.getCantidad()});
        System.out.println(result);
        return result;
    }

    @Override
    public int deleteSKU(int SKU) {

        String SP = "EXEC DeleteInventario " + SKU;
        var result = jdbcTemplate.update(SP);
        return result;
    }
}
