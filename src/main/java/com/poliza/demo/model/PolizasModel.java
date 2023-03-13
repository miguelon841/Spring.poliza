package com.poliza.demo.model;

import lombok.Data;

@Data
public class PolizasModel {
    int IdPolizas;
    int EmpleadoGenero;
    int SKU;
    int Cantidad;
    String Fecha;
    public int getIdPolizas (){
        return IdPolizas;
    }
    public void setIdPolizas (int IdPolizas){
        this.IdPolizas = IdPolizas;
    }
    public int getEmpleadoGenero (){
        return EmpleadoGenero;
    }
    public void setEmpleadoGenero (int EmpleadoGenero){
        this.EmpleadoGenero = EmpleadoGenero;
    }
    public int getSKU (){
        return SKU;
    }
    public void setSKU (int SKU){
        this.SKU = SKU;
    }
    public int getCantidad (){
        return Cantidad;
    }
    public void setCantidad (int Cantidad){
        this.Cantidad = Cantidad;
    }
    public String Fecha (){
        return Fecha;
    }
    public void setFecha (String Fecha){
        this.Fecha = Fecha;
    }
}
