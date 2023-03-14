package com.poliza.demo.controller;

import com.poliza.demo.model.EmpleadoModel;
import com.poliza.demo.model.PolizasModel;
import com.poliza.demo.service.iPolizasService;

import lombok.var;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Polizas")
@CrossOrigin("*")
public class PolizasController {
    @Autowired
    private iPolizasService iPolizasService;
    @GetMapping("/Obtener")
    public String list(){
        JSONObject Response = new JSONObject();
        int i = 0;
        try{
            JSONObject obj = new JSONObject();
            JSONObject data = new JSONObject();
            obj.put("Status", "OK");
            Response.put("Meta",obj);
            var result = iPolizasService.findAll();
            try{
                for(PolizasModel item : result) {
                    System.out.println(item);
                    JSONObject jItem = new JSONObject();
                    jItem.put("IdPolizas",item.getIdPolizas());
                    jItem.put("EmpleadoGenero",item.getEmpleadoGenero());
                    jItem.put("SKU",item.getSKU());
                    jItem.put("Cantidad",item.getCantidad());
                    jItem.put("Fecha",item.getFecha());
                    data.put("Poliza"+i,jItem);
                    i++;
                }
                Response.put("Data",data);
            }catch(Exception err){
                obj.put("Status", "FAILURE");
                Response.put("Meta",obj);
                data.put("Mensaje","Ha ocurrido un error al consultar la Poliza.");
                Response.put("Data",data);
            }

        }catch (Exception err){
            throw err;
        }
        return Response.toString();
    }



    @PostMapping("/Guardar")
    public String save(@RequestBody String jPolizas){
        JSONObject obj = new JSONObject(jPolizas);
        JSONObject Response = new JSONObject();
        JSONObject res = new JSONObject();
        JSONObject data = new JSONObject();

        PolizasModel Polizas = new PolizasModel();

        Polizas.setEmpleadoGenero(Integer.parseInt(obj.get("EmpleadoGenero").toString()));
        Polizas.setSKU(Integer.parseInt(obj.get("SKU").toString()));
        Polizas.setCantidad(Integer.parseInt(obj.get("Cantidad").toString()));
        Polizas.setFecha(obj.get("Fecha").toString());

        try{
            int result = iPolizasService.save(Polizas);
            System.out.println(result);
            if(result == 1){
                res.put("Status", "OK");
                Response.put("Meta",res);
                JSONObject jItem = new JSONObject();
                jItem.put("EmpleadoGenero",obj.get("EmpleadoGenero").toString());
                jItem.put("SKU",obj.get("SKU").toString());
                jItem.put("Cantidad",obj.get("Cantidad").toString());
                jItem.put("Fecha",obj.get("Fecha").toString());
                data.put("Polizas",jItem);
                Response.put("Data",data);
            }
            else{
                res.put("Status", "FAILURE");
                Response.put("Meta",res);
                data.put("Mensaje","Ha ocurrido un error en los grabados de el Empleado.");
                Response.put("Data",data);
            }
        }catch(Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            data.put("Mensaje","Ha ocurrido un error en los grabados de la poliza.");
            Response.put("Data",data);
        }
        return Response.toString();
    }

    @PostMapping("/Actualizar")
    public String update(@RequestBody String jPolizas){
        JSONObject obj = new JSONObject(jPolizas);
        JSONObject res = new JSONObject();
        JSONObject msg1 = new JSONObject();
        JSONObject msg2 = new JSONObject();
        JSONObject Response = new JSONObject();

        PolizasModel Polizas = new PolizasModel();

        Polizas.setIdPolizas(Integer.parseInt(obj.get("IdPolizas").toString()));
        Polizas.setEmpleadoGenero(Integer.parseInt(obj.get("EmpleadoGenero").toString()));
        Polizas.setSKU(Integer.parseInt(obj.get("SKU").toString()));
        Polizas.setCantidad(Integer.parseInt(obj.get("Cantidad").toString()));
        Polizas.setFecha(obj.get("Fecha").toString());

        try {
            int result = iPolizasService.update(Polizas);
            if (result == 1) {
                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se actualizó correctamente la poliza con IdPolizas: " + obj.get("IdPolizas").toString());
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
                System.out.println(Response);

            } else {
                res.put("Status", "FAILURE");
                Response.put("Meta", res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar la poliza.");
                Response.put("Data", msg2);
                System.out.println(Response);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta", res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar la poliza.");
            Response.put("Data", msg2);
            System.out.println(Response);
        }
        return Response.toString();
    }
    @PostMapping("/Eliminar" )
    public String deleteSKU(@RequestBody String jPolizas){
        JSONObject Response = new JSONObject();
        JSONObject obj = new JSONObject(jPolizas);
        JSONObject res = new JSONObject();
        JSONObject msg1 = new JSONObject();
        JSONObject msg2 = new JSONObject();
        try {
            int IdPolizas = Integer.parseInt(obj.get("IdPolizas").toString());
            int result = iPolizasService.deletePolizas(IdPolizas);
            System.out.println(result);
            if (result == 1) {

                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se eliminó correctamente el empleado con IdPolizas: " + IdPolizas);
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
                System.out.println(Response);
            }
            if (result == 0) {
                res.put("Status", "FAILURE");
                Response.put("Meta", res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar IdPolizas.");
                Response.put("Data", msg2);
                System.out.println(Response);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar IdPolizas.");
            Response.put("Data",msg2);
            System.out.println(Response);
        }
        return Response.toString();
    }
}
