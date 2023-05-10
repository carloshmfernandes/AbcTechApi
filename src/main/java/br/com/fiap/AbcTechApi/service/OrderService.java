package br.com.fiap.AbcTechApi.service;

import java.util.List;

import br.com.fiap.AbcTechApi.entity.Order;

public interface OrderService {
    void saveOrder(Order order, List<Long> assistsId) throws Exception;
}
