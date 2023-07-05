package com.cc5002.spring_app.pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pedidoRepository")
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    Page<Pedido> findAllByOrderByIdDesc(Pageable pageable);
}
