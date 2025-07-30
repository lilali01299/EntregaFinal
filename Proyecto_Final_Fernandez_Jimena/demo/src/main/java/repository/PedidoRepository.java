package repository;

import entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

    void delete(Optional<Pedido> encontrado);
}
