package repository;

import entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Producto> productos;
    public ProductRepository() {
        this.productos = new ArrayList<>();
    }
    public List<Producto> obtenerTodosLosProductos(){
        return this.productos;
    }

    public String agregarProducto(Producto producto){
        productos.add(producto);

        return "☣ Producto cargado exitosamente! ☣ \n ID del Producto: " + producto.getIdProducto();
    }

    public List<Producto> listarProductos() {
        return this.productos;
    }

    public ArrayList<Producto> buscarProducto(String busqueda) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (Producto producto : productos){
            if (producto.contieneNombre(busqueda)){
                productosEncontrados.add(producto);
            }
        }

        return productosEncontrados;
    }

    public Producto buscarPorId(Long id) {
        for (Producto producto : productos){
            if (producto.getIdProducto() == id){
                return producto;
            }
        }


        return null;
    }

    public Producto eliminarProducto(Producto producto) {
        this.productos.remove(producto);

        return producto;
    }
    private void agregarProductosDeEjemplo() {
        productos.add(new Producto("Monitor", 1000, 10));
        productos.add(new Producto("Micrófono", 2000, 10));
        productos.add(new Producto("Teclado mecánico", 1500, 15));
        productos.add(new Producto("Mouse gamer", 1200, 20));
        productos.add(new Producto("Laptop", 15000, 5));
    }

}
