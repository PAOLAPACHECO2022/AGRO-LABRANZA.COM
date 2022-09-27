package com.misiontic2022.agrolabranza.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.misiontic2022.agrolabranza.controller.dto.ProductoDto;
import com.misiontic2022.agrolabranza.controller.dto.ProductorDto;
import com.misiontic2022.agrolabranza.service.CproductoService;

 // define que hace  cada una de las clases (Buenas practicas S.O.L.I.D(._.))
 // clase: unica responsabilidad, controlador: getionar peticiones de la vista, mantener vista actualizada
 //SRP(Usuarios) interfaz gráfica
 //OCP (las clases despues de teminadas se aconseja no volver a modificarlas)
 //LSP (Las clases hijas puedan remplazar las clases madre)
 //ISP (Se definen los objetos, comportamientos)
 //DIP (Depende de un objeto que pude ser cambiado en cualquier momento, no afecta las clases)



// (spring) hay una clase que implementa la interfaz que parte del grupo de servivios ( servivio se coloca en la clase)
@Service
public class CproductoServiceImpl implements CproductoService {

    
    private final List<ProductoDto> productos = Arrays.asList(
        new ProductoDto("Papa",1),
        new ProductoDto("Pera",2),
        new ProductoDto("Mango",3),
        new ProductoDto("Durazno",4),
        new ProductoDto("Zanahoria",5),
        new ProductoDto("Brocoli",6));
    private final List<ProductorDto> productores =Arrays.asList(
        new ProductorDto(253572, "Marcos Julian Lozano Perez",1,"se dedica al cultivo de Papa en la vereda del Corazón del municipio de Pesca Boyacá. En su finca El Manzano, cultiva 3 variedades de Papa, con el apoyo del Banco Agrario, que ha financiado desde hace más de una década, sus proyectos productivos. Producto en venta: Papa Criolla, Cantidad: 1 Bulto,  Precio: $ 70.000", "Boyacá-Tutaza", " Vereda- Corrales","marcosjulianp@gmail.com","3205456789",null),
        new ProductorDto(354525,"Oscar Felipe Rubio Moreno",1,"se dedica al cultivo de Papa en la vereda del Corral del municipio de Mongua Boyacá. En su finca El Mirador, cultiva 3 variedades de Papa, con el apoyo del Banco Agrario, que ha financiado desde hace más de una década, sus proyectos productivos. Producto en venta: Papa pastusa, Cantidad: 1 Bulto, Precio: $ 50.000", "Boyacá-Mongua", "Vereda- Corral", "oscarfeliper@gmail.com","3145768979",null),
        new ProductorDto(454725, "Santiago Tenjo Plazas", 2,"se dedica al cultivo de Pera en la vereda del Mirador del municipio de Duitama Boyacá. En su finca El Campo Verde, cultiva 2 variedades de Pera, con el apoyo del Banco Agrario, que ha financiado desde hace más de una década, sus proyectos productivo, Producto en venta: Pera común, Cantidad: 1 Bulto, Precio: $ 90.000", "Boyacá-Duitama", "Vereda- Mirador","santiagotenjop@gmail.co","3145868990",null),
        new ProductorDto(54625, "Luis Fabio Rodriguez Sanchez",2,"se dedica al cultivo de Pera en la vereda del San Antonio del municipio de Duitama Boyacá. En su finca El Mortiño, cultiva 2 variedades de Pera, con el apoyo del Banco Agrario, que ha financiado desde hace más de una década, sus proyectos productivos. Producto en venta: Pera común, Cantidad: 1 Bulto, Precio: $ 70.000","Boyacá-Duitama", "Vereda- San Antonio", "LuisFrodriguez@gmail.com","3125868896",null),
        new ProductorDto(6545725,"Julian Santiago Molina Corredor",2, "se dedica al cultivo de Pera en la vereda las Moyas del municipio de Pesca Boyacá. En su finca El Amanecer, cultiva 2 variedades de Pera, con el apoyo del Banco Agrario, que ha financiado desde hace más de 5 años, sus proyectos productivos, Producto en venta: Pera común, Cantidad: 1 Bulto, Precio: $ 95.000", "Pesca-Boyacá", "Vereda- Las Moyas", "juliansantiagocorredor@gmail.com", "3205868896",null));

   

    @Override
    public List<ProductoDto> getProductos() {
        // TODO Auto-generated method stub
        return productos;
    }

    @Override
    public Optional<ProductoDto> getProductoId(Integer id) {
        // TODO Auto-generated method stub

        
        var producto= productos.stream()
        .filter(c -> c.getId().equals(id))
        .findFirst();
   
        return producto;
    }

 
    @Override
    public List<ProductorDto> getProductoresByProductoId(Integer productoId) {
        // TODO Auto-generated method stub

        var productoProductores = productores.stream()
        .filter(m -> m.getProductoId().equals(productoId))
        .collect(Collectors.toList());
        return productoProductores;
    }
    
    
}
