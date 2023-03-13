package com.poliza.demo.repository;

import com.poliza.demo.model.PolizasModel;

import java.util.List;

public interface iPolizasRepository {
    public List<PolizasModel> findAll();
    public int save(PolizasModel Polizas);
    public int update(PolizasModel Polizas);
    public int deletePolizas(int IdPolizas);
}
