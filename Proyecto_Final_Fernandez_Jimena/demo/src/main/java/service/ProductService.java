package service;

import entity.Producto;
import exception.ProductNotFound;
import org.springframework.stereotype.Service;

import repository.ProductRepository;
import repository.ProductoRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;
    private ProductoRepository repositoryJpa;
    private final ArrayList<Producto> productos;
    public ProductService(ProductRepository repository, ProductoRepository repositoryJpa) {
        this.repository = repository;
        this.repositoryJpa = repositoryJpa;
        this.productos = new ArrayList<>();
    }


    public Producto agregarProducto(Producto producto){

        Producto productoGuardado = this.repositoryJpa.save(producto);

        return productoGuardado;
    }

    public List<Producto> listarProductos() {
        return this.repositoryJpa.findAll();
    }

    // GET
    public ArrayList<Producto> buscarProducto(String busqueda) {
        ArrayList<Producto> encontrados = this.repository.buscarProducto(busqueda);

        if (encontrados.isEmpty()){
            throw new ProductNotFound(busqueda);
        }

        return encontrados;
    }

    public Producto buscarPorId(Long id) {
        Optional<Producto> encontrado = this.repositoryJpa.findById(id);
        if (encontrado.isEmpty()){
            throw new ProductNotFound(id.toString());
        }

        return encontrado.get();
    }

    public Producto buscarPorIdv2(Long id) {
        return this.repositoryJpa.findById(id).orElseThrow(() -> new ProductNotFound(id.toString()));
    }

    public Producto editarProducto(Long id, Double nuevoPrecio){
        Producto encontrado = this.buscarPorId(id);

        encontrado.setPrecio(nuevoPrecio);
        this.repositoryJpa.save(encontrado);

        return encontrado;
    }

    // DELETE
    public Producto eliminarProducto(Long id) {
        Producto encontrado = this.buscarPorId(id);

        this.repositoryJpa.delete(encontrado);

        return encontrado;
    }


}
