package com.poliza.demo.service;

import com.poliza.demo.model.EmpleadoModel;

import java.util.List;

public interface iEmpleadoService {
    public List<EmpleadoModel> findAll();
    public int save(EmpleadoModel Empleado);
    public int update(EmpleadoModel Empleado);
    public int deleteEmpleado(int IdEmpleado);
}
