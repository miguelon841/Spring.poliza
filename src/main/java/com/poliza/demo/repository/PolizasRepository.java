package com.poliza.demo.repository;

import com.poliza.demo.model.PolizasModel;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PolizasRepository implements iPolizasRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PolizasModel> findAll() {
        String SP = "EXEC selectAllPolizas";
        var result = jdbcTemplate.query(SP, BeanPropertyRowMapper.newInstance(PolizasModel.class));
        return result;    }

    @Override
    public int save(PolizasModel Polizas) {
        String SP = "EXEC SavePolizas ?,?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Polizas.getEmpleadoGenero(),Polizas.getSKU(),Polizas.getCantidad(),Polizas.getFecha()});
        return result;
    }

    @Override
    public int update(PolizasModel Polizas) {
        String SP = "EXEC UpdatePolizas ?,?,?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Polizas.getIdPolizas(),Polizas.getEmpleadoGenero(),Polizas.getSKU(),Polizas.getCantidad(),Polizas.getFecha()});
        return result;
    }

    @Override
    public int deletePolizas(int IdPolizas) {
        String SP = "EXEC DeletePolizas " + IdPolizas;
        var result = jdbcTemplate.update(SP);
        return result;
    }
}
