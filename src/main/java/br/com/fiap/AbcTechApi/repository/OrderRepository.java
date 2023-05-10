package br.com.fiap.AbcTechApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.AbcTechApi.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

