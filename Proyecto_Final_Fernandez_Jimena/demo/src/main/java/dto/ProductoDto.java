package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    private Long id;

    private String nombre;
    private double precio;
    private int stock;
    private int cantidadAComprar;
    private String description;

}
