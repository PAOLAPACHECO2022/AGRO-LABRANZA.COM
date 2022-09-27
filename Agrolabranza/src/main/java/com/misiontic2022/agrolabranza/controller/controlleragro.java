package com.misiontic2022.agrolabranza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.misiontic2022.agrolabranza.service.CproductoService;


 //CONTROLADOR: RESPONSABILIDAD UNICA, LLAMA AL SERVICIO PARA TRAER LOS DATOS QUE VA A MOSTRAR EN PANTALLA

@Controller

public class controlleragro {
    //appi(procesa solicitud)
    //renderizar (mostrar pagina)

    // Ddevuelve las peticiones solicitadas, para inicializar los atributos
    private CproductoService cproductoService;   
    

    public controlleragro(CproductoService cproductoService) {
        // atributo
        this.cproductoService =cproductoService;
    }

    // RECIBE LOS DATOS PARA ORGANIZARLOS Y LUEGO ENVIARLOS A LA PANTALLA
    @GetMapping ("/cproductos")
    public String goToCproductos(Model model) {
        //obtiene los productos, carga los productos
        var productos = this.cproductoService.getProductos();

        model.addAttribute("name","Welcome to my site" );
        
   
        model.addAttribute("productos", productos);
        
        return "cproductos";
    }

    @GetMapping ("/cproductos/{id}")
    public String loadCproductoById(@PathVariable("id") Integer id, Model model) {

        var productos =cproductoService.getProductos();
        model.addAttribute("productos", productos);

        // pregunta cual es el tipo producto

        var productoOp= this.cproductoService.getProductoId(id);
        if (productoOp.isEmpty()){
            //Mostrar mensaje de error
            model.addAttribute("error", "El producto NO existe");

        } else {
            var producto = productoOp.get();
            

        model.addAttribute("name", producto.getName());
        model.addAttribute("id", producto.getId());
       
    

        //busca un producto por id- para traer los productores del producto

        var productoProductores = this.cproductoService.getProductoresByProductoId(id);

       

        model.addAttribute("productores", productoProductores);
        
    }
        return "cproductos";
    }
        
  

    @GetMapping ("/registro")
    public String goToRegistro(Model model) {
        return "registro";
        
    }

    @GetMapping ("/login")
    public String goToLogin(Model model) {
        return "Ingreso";
    }

}




    


