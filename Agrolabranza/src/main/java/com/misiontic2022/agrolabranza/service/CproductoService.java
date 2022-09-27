package com.misiontic2022.agrolabranza.service;

import java.util.List;
import java.util.Optional;

import com.misiontic2022.agrolabranza.controller.dto.ProductoDto;
import com.misiontic2022.agrolabranza.controller.dto.ProductorDto;

// Se crean/publicar los métodos que el controlador va a poder utilizar

public interface CproductoService {
    //devuelve una lista de productos
    List<ProductoDto> getProductos();
    // define una producto por id y devuelve un producto, es un contenedor que informa si o no existe el dato 
    Optional<ProductoDto> getProductoId(Integer id);

    // devulve la lista de productores

    List <ProductorDto> getProductoresByProductoId(Integer productoId);

   
    
}
