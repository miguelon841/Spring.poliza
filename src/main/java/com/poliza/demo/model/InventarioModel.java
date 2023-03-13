package com.poliza.demo.model;

import lombok.Data;

@Data
public class InventarioModel {
    int SKU;
    String Nombre;
    int Cantidad;
    public int getSKU (){
        return SKU;
    }
    public void setSKU (int SKU){
        this.SKU = SKU;
    }
    public String getNombre (){
        return Nombre;
    }
    public void setNombre (String Nombre){
        this.Nombre = Nombre;
    }
    public int getCantidad (){
        return Cantidad;
    }
    public void setCantidad (int Cantidad){
        this.Cantidad = Cantidad;
    }
}
