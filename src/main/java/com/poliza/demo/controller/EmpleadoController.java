package com.poliza.demo.controller;
import com.poliza.demo.model.EmpleadoModel;
import com.poliza.demo.service.iEmpleadoService;

import lombok.var;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Empleado")
@CrossOrigin("*")
public class EmpleadoController {
    @Autowired
    private iEmpleadoService iEmpleadoService;

    @GetMapping("/Obtener")
    public String list(){
        JSONObject Response = new JSONObject();
        int i = 0;
        try{
            JSONObject obj = new JSONObject();
            JSONObject data = new JSONObject();
            obj.put("Status", "OK");
            Response.put("Meta",obj);
            var result = iEmpleadoService.findAll();
            try{
                for(EmpleadoModel item : result) {
                    System.out.println(item);
                    JSONObject jItem = new JSONObject();
                    jItem.put("IdEmpleado",item.getIdEmpleado());
                    jItem.put("Nombre",item.getNombre());
                    jItem.put("Apellido",item.getApellido());
                    jItem.put("Puesto",item.getPuesto());
                    data.put("Empleado"+i,jItem);
                    i++;
                }
                Response.put("Data",data);
            }catch(Exception err){
                obj.put("Status", "FAILURE");
                Response.put("Meta",obj);
                data.put("Mensaje","Ha ocurrido un error al consultar el Empleado.");
                Response.put("Data",data);
            }

        }catch (Exception err){
            throw err;
        }
        return Response.toString();
    }



    @PostMapping("/Guardar")
    public String save(@RequestBody String jEmpleado){
        JSONObject obj = new JSONObject(jEmpleado);
        JSONObject Response = new JSONObject();
        JSONObject res = new JSONObject();
        JSONObject data = new JSONObject();

        EmpleadoModel Empleado = new EmpleadoModel();

        Empleado.setIdEmpleado(Integer.parseInt(obj.get("IdEmpleado").toString()));
        Empleado.setNombre(obj.get("Nombre").toString());
        Empleado.setApellido(obj.get("Apellido").toString());
        Empleado.setPuesto(obj.get("Puesto").toString());
        try{
            int result = iEmpleadoService.save(Empleado);
            System.out.println(result);
            if(result == 1){
                res.put("Status", "OK");
                Response.put("Meta",res);
                JSONObject jItem = new JSONObject();
                jItem.put("IdEmpleado",obj.get("IdEmpleado").toString());
                jItem.put("Nombre",obj.get("Nombre").toString());
                jItem.put("Apellido",obj.get("Apellido").toString());
                jItem.put("Puesto",obj.get("Puesto").toString());
                data.put("Empleado",jItem);
                Response.put("Data",data);
            } else {
                res.put("Status", "FAILURE");
                Response.put("Meta",res);
                data.put("Mensaje","Ha ocurrido un error en los grabados de el Empleado.");
                Response.put("Data",data);
            }
        }catch(Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            data.put("Mensaje","Ha ocurrido un error en los grabados de el Empleado.");
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

        EmpleadoModel Empleado = new EmpleadoModel();

        Empleado.setIdEmpleado(Integer.parseInt(obj.get("IdEmpleado").toString()));
        Empleado.setNombre(obj.get("Nombre").toString());
        Empleado.setApellido(obj.get("Apellido").toString());
        Empleado.setPuesto(obj.get("Puesto").toString());
        try {
            int result = iEmpleadoService.update(Empleado);
            if (result == 1) {
                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se actualizó correctamente el Empleado con IdEmpleado: " + obj.get("IdEmpleado").toString());
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
                System.out.println(Response);

            } else {
                res.put("Status", "FAILURE");
                Response.put("Meta", res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar el Empleado.");
                Response.put("Data", msg2);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar actualizar el Empleado.");
            Response.put("Data",msg2);
        }
        return Response.toString();
    }
    @PostMapping("/Eliminar" )
    public String deleteSKU(@RequestBody String jIdEmpleado){
        JSONObject Response = new JSONObject();
        JSONObject obj = new JSONObject(jIdEmpleado);
        JSONObject res = new JSONObject();
        JSONObject msg1 = new JSONObject();
        JSONObject msg2 = new JSONObject();

        try {
            int IdEmpleado = Integer.parseInt(obj.get("IdEmpleado").toString());
            int result = iEmpleadoService.deleteEmpleado(IdEmpleado);
            if (result == 1) {

                res.put("Status", "OK");
                Response.put("Meta", res);
                msg1.put("IDMensaje", "Se eliminó correctamente el empleado con IdEmpleado: " + IdEmpleado);
                msg2.put("Mensaje", msg1);
                Response.put("Data", msg2);
                System.out.println(Response);
            }
            if (result == 0) {
                res.put("Status", "FAILURE");
                Response.put("Meta", res);
                msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar el empleado.");
                Response.put("Data", msg2);
                System.out.println(Response);
            }
        }catch (Exception err){
            res.put("Status", "FAILURE");
            Response.put("Meta",res);
            msg2.put("Mensaje", "Ha ocurrido un error al intentar eliminar el empleado.");
            Response.put("Data",msg2);
            System.out.println(Response);
        }
        return Response.toString();
    }
}
