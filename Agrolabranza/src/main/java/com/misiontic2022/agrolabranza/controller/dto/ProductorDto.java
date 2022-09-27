package com.misiontic2022.agrolabranza.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductorDto {

    private long id;
    private String name;
    private Integer productoId;
    private String descripcion;
    private String municipio;
    private String direccion;
    private String correo;
    private String celular;
    private String imageUrl;
    


    
    
    
    
}
