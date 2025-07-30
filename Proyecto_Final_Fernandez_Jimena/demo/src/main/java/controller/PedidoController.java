package controller;

import entity.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService service;
    public PedidoController(PedidoService pedidoService) {
        this.service = pedidoService;
    }

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return this.service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPorId(@PathVariable Long id) {
        return this.service. obtenerPorId(id);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.crearPedido(pedido)).getBody();
    }


    @DeleteMapping("/{id}")
    public Optional<Pedido> eliminarPedido(@PathVariable Long id) {
        return this.service.eliminarPedido(id);
    }
}


