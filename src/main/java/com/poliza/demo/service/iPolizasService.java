package com.poliza.demo.service;

import com.poliza.demo.model.PolizasModel;

import java.util.List;

public interface iPolizasService {
    public List<PolizasModel> findAll();
    public int save(PolizasModel Polizas);
    public int update(PolizasModel Polizas);
    public int deletePolizas(int IdPolizas);
}
