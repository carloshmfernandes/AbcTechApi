package br.com.fiap.AbcTechApi.repository;

import br.com.fiap.AbcTechApi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
