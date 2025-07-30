package repository;

import entity.Pedido;
import entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Pedido> pedidos;
    public OrderRepository() {
        this.pedidos = new ArrayList<>();
    }

    public Pedido eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);

        return pedido;
    }
}
