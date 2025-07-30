package service;

import entity.Pedido;
import entity.Producto;
import repository.PedidoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoService {
    private PedidoRepository repository;
    private PedidoRepository repositoryJpa;

    private final ArrayList<Pedido> pedidos;

    public PedidoService (PedidoRepository repository, PedidoRepository repositoryJpa) {
        this.repository = repository;
        this.repositoryJpa = repositoryJpa;
        this.pedidos = new ArrayList<>();
    }
    public List<Pedido> obtenerTodos() {
        return this.repositoryJpa.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido crearPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public Optional<Pedido> eliminarPedido(Long id) {
        Optional<Pedido> encontrado = this.obtenerPorId(id);

        this.repositoryJpa.delete(encontrado);

        return encontrado;
    }

}
