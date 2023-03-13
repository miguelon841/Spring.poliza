package com.poliza.demo.model;

import lombok.Data;

@Data
public class EmpleadoModel {
    int IdEmpleado;
    String Nombre;
    String Apellido;
    String Puesto;
    public int getIdEmpleado (){
        return IdEmpleado;
    }
    public void setIdEmpleado (int IdEmpleado){
        this.IdEmpleado = IdEmpleado;
    }
    public String getNombre (){
        return Nombre;
    }
    public void setNombre (String Nombre){
        this.Nombre = Nombre;
    }
    public String getApellido (){
        return Apellido;
    }
    public void setApellido (String Apellido){
        this.Apellido = Apellido;
    }
    public String getPuesto (){
        return Puesto;
    }
    public void set (String Puesto){
        this.Puesto = Puesto;
    }

}
