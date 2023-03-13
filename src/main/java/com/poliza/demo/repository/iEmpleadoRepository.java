package com.poliza.demo.repository;

import com.poliza.demo.model.EmpleadoModel;

import java.util.List;

public interface iEmpleadoRepository {
    public List<EmpleadoModel> findAll();
    public int save(EmpleadoModel Empleado);
    public int update(EmpleadoModel Empleado);
    public int deleteEmpleado(int IdEmpleado);
}
