package controller;

import dto.ProductResponseDto;
import entity.Producto;
import exception.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;


import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }
    @PostMapping("/")
    public ResponseEntity<Producto> createProduct(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.agregarProducto(producto));
    }

    @GetMapping("/list")
    public List<Producto> obtenerListadoProductos(){
        return this.service.listarProductos();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Producto>> obtenerProductos(@RequestParam String nombreBusqueda){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarProducto(nombreBusqueda));
        }catch (ProductNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return this.service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Producto editarPrecioProducto(@PathVariable Long id, @RequestParam Double nuevoPrecio){
        return this.service.editarProducto(id, nuevoPrecio);
    }

    @DeleteMapping("/{id}")
    public Producto borrarProducto(@PathVariable Long id){
        return this.service.eliminarProducto(id);
    }



}