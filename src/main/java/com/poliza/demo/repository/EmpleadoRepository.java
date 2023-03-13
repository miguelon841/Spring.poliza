package com.poliza.demo.repository;

import com.poliza.demo.model.EmpleadoModel;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository implements iEmpleadoRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EmpleadoModel> findAll() {
        String SP = "EXEC selectAllEmpleado";
        var result = jdbcTemplate.query(SP, BeanPropertyRowMapper.newInstance(EmpleadoModel.class));
        return result;
    }

    @Override
    public int save(EmpleadoModel Empleado) {
        String SP = "EXEC SaveEmpleado ?,?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Empleado.getIdEmpleado(),Empleado.getNombre(),Empleado.getApellido(),Empleado.getPuesto()});
        return result;
    }

    @Override
    public int update(EmpleadoModel Empleado) {
        String SP = "EXEC UpdateEmpleado ?,?,?,?;";
        var result =  jdbcTemplate.update(SP,new Object[]{Empleado.getIdEmpleado(),Empleado.getNombre(),Empleado.getApellido(),Empleado.getPuesto()});
        System.out.println(result);
        return result;
    }

    @Override
    public int deleteEmpleado(int IdEmpleado) {

        String SP = "EXEC DeleteEmpleado " + IdEmpleado;
        var result = jdbcTemplate.update(SP);
        return result;
    }
}
