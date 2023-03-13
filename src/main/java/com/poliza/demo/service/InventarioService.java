package com.poliza.demo.service;

import com.poliza.demo.model.InventarioModel;
import com.poliza.demo.repository.iInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements iInventarioService {

    @Autowired
    private iInventarioRepository iInventarioRepository;
    @Override
    public List<InventarioModel> findAll() {
        List<InventarioModel> list;
        try{
            list = iInventarioRepository.findAll();

        }catch (Exception err){
            throw err;
        }
        return list;
    }

    @Override
    public int save(InventarioModel Inventario) {
        int result;
        try{
            result = iInventarioRepository.save(Inventario);

        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int update(InventarioModel Inventario) {
        int result;
        try{
            result = iInventarioRepository.update(Inventario);
        }catch(Exception err){
            throw err;
        }
        return result;
    }

    @Override
    public int deleteSKU(int SKU) {

        int result;
        try{
            result = iInventarioRepository.deleteSKU(SKU);
        }catch(Exception err){
            throw err;
        }
        return result;
    }
}
