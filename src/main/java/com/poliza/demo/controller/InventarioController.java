package com.poliza.demo.controller;
import com.poliza.demo.model.InventarioModel;
import com.poliza.demo.service.iInventarioService;

import lombok.var;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/Inventario")
@CrossOrigin("*")
public class InventarioController {

    @Autowired
    private iInventarioService iInventarioService;

    /*@GetMapping("/jsonResponse")
    public String jsonResponse()throws Exception{
        JSONObject obj = new JSONObject();
        try {
            obj.put("Nombre", "Miguel");
            System.out.println(obj);
        }catch (Exception err){
            throw err;
        }
        return obj.toString();
    }*/

    @GetMapping("/Obtener")
    public String list(){
        JSONObject Response = new JSONObject();
        int i = 0;
        try{
            JSONObject obj = new JSONObject();
            JSONObject data = new JSONObject();
            obj.put("Status", "OK");
            Response.put("Meta",obj);
            try{
                var result = iInventarioService.findAll();

                for(InventarioModel item : result) {
                    JSONObject jItem = new JSONObject();
                    jItem.put("SKU",item.getSKU());
                    jItem.put("Nombre",item.getNombre());
                    jItem.put("Cantidad",item.getCantidad());
                    data.put("DetalleArticulo"+i,jItem);
                    i++;
                }
                Response.put("Data",data);
            }catch(Exception err){
                obj.put("Status", "FAILURE");
                Response.put("Meta",obj);
                data.put("Mensaje","Ha ocurrido un error al consultar el Material.");
                Response.put("Data",data);
            }

        }catch (Exception err){
            throw err;
        }
        return Response.toString();
    }



    @PostMapping("/Guardar")
    public String save(@RequestBody String jInventario){
        JSONObject obj = new JSONObject(jInventario);
        JSONObject Response = new JSONObject();
        JSONObject res = new JSONObject();
        JSONObject data = new JSONObject();

        InventarioModel Inventario = new InventarioModel();

        Inventario.setSKU(Integer.parseInt(obj.get("SKU").toString()));
        Inventario.setNombre(obj.get("Nombre").toString());
        Inventario.setCantidad(Integer.parseInt(obj.get("Cantidad").toString()));
        try {
            int result = iInventarioService.save(Inventario);

            if (result == 1) {
                res.put("Status", "OK");
                Response.put("Meta", res);
                JSONObject jItem = new JSONObject();
                jItem.put("SKU", obj.get("SKU").toString());
                jItem.put("Nombre", obj.get("Nombre").toString());
                jItem.put("Cantidad", obj.get("Cantidad").toString());
                data.put("DetalleArticulo", jItem);
                Response.put("Data", data);
            }else{
                res.put("Status", "FAILURE");
                Response.put("Meta",res);
                data.put("Mensaje","Ha ocurrido un error en los grabados de el Material.");
                Response.put("Data",data);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            data.put("Mensaje","Ha ocurrido un error en los grabados de el Material.");
            Response.put("Data",data);
        }
        return Response.toString();
    }

    @PostMapping("/Actualizar")
    public String update(@RequestBody String jInventario){
        JSONObject obj = new JSONObject(jInventario);
        JSONObject res = new JSONObject();
        JSONObject msg1 = new JSONObject();
        JSONObject msg2 = new JSONObject();
        JSONObject Response = new JSONObject();

        InventarioModel Inventario = new InventarioModel();
        Inventario.setSKU(Integer.parseInt(obj.get("SKU").toString()));
        Inventario.setNombre(obj.get("Nombre").toString());
        Inventario.setCantidad(Integer.parseInt(obj.get("Cantidad").toString()));
        try {
            int result = iInventarioService.update(Inventario);
            if (result == 1) {
                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se actualizó correctamente el material con SKU: " + obj.get("SKU").toString());
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
            }else{
                res.put("Status", "FAILURE");
                Response.put("Meta",res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar el material.");
                Response.put("Data",msg2);
            }
        }catch(Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar el material.");
            Response.put("Data",msg2);
        }
        return Response.toString();
    }
    @PostMapping("/Eliminar" )
    public String deleteSKU(@RequestBody String jSKU){
        JSONObject Response = new JSONObject();
        JSONObject obj = new JSONObject(jSKU);
        JSONObject res = new JSONObject();
        JSONObject msg1 = new JSONObject();
        JSONObject msg2 = new JSONObject();

        int SKU = Integer.parseInt(obj.get("SKU").toString());
        try {
            int result = iInventarioService.deleteSKU(SKU);
            if (result == 1) {

                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se eliminó correctamente el material con SKU: " + SKU);
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
            }else{
                res.put("Status", "FAILURE");
                Response.put("Meta",res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar el material.");
                Response.put("Data",msg2);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar el material.");
            Response.put("Data",msg2);
        }
        return Response.toString();
    }
}
