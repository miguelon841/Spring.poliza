package com.poliza.demo.service;

import com.poliza.demo.model.PolizasModel;
import com.poliza.demo.repository.iPolizasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolizasService implements iPolizasService{
    @Autowired
    private iPolizasRepository iPolizasRepository;
    @Override
    public List<PolizasModel> findAll() {
        List<PolizasModel> list;
        try{
            list = iPolizasRepository.findAll();

        }catch (Exception err){
            throw err;
        }
        return list;
    }

    @Override
    public int save(PolizasModel Polizas) {
        int result;
        try{
            result = iPolizasRepository.save(Polizas);

        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int update(PolizasModel Polizas) {
        int result;
        try{
            result = iPolizasRepository.update(Polizas);
        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int deletePolizas(int IdPolizas) {
        int result;
        try{
            result = iPolizasRepository.deletePolizas(IdPolizas);
        }catch(Exception err){
            throw err;
        }
        return result;
    }
}
