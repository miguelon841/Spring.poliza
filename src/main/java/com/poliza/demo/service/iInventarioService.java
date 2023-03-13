package com.poliza.demo.service;

import com.poliza.demo.model.InventarioModel;

import java.util.List;

public interface iInventarioService {
    public List<InventarioModel> findAll();
    public int save(InventarioModel Inventario);
    public int update(InventarioModel Inventario);
    public int deleteSKU(int SKU);
}
