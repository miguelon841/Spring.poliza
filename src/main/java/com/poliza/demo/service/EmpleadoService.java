package com.poliza.demo.service;

import com.poliza.demo.model.EmpleadoModel;
import com.poliza.demo.repository.iEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements iEmpleadoService{
    @Autowired
    private iEmpleadoRepository iEmpleadoRepository;
    @Override
    public List<EmpleadoModel> findAll() {
        List<EmpleadoModel> list;
        try{
            list = iEmpleadoRepository.findAll();

        }catch (Exception err){
            throw err;
        }
        return list;
    }

    @Override
    public int save(EmpleadoModel Empleado) {
        int result;
        try{
            result = iEmpleadoRepository.save(Empleado);

        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int update(EmpleadoModel Empleado) {
        int result;
        try{
            result = iEmpleadoRepository.update(Empleado);
        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int deleteEmpleado(int IdEmpleado) {
        int result;
        try{
            result = iEmpleadoRepository.deleteEmpleado(IdEmpleado);
        }catch(Exception err){
            throw err;
        }
        return result;
    }
}
