package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private Double precio;
    private int stock;
    private int cantidadAComprar;


    public Producto(int idProducto) {

    }

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock= stock;

    }

    public boolean contieneNombre(String busqueda){
        String nombreMinuscula = this.nombre.toLowerCase();

        return nombreMinuscula.contains(busqueda.toLowerCase());
    }

    public void mostrarInfo(){
        System.out.println("#########################");
        System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.idProducto, this.nombre, this.precio, this.stock);
        System.out.println("#########################");
    }

}
