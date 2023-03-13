package com.poliza.demo.repository;

import com.poliza.demo.model.InventarioModel;

import java.util.List;

public interface iInventarioRepository {
    public List<InventarioModel> findAll();
    public int save(InventarioModel Inventario);
    public int update(InventarioModel Inventario);
    public int deleteSKU(int SKU);

}
