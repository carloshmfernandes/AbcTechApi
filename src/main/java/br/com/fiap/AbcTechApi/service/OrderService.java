package br.com.fiap.AbcTechApi.service;


import br.com.fiap.AbcTechApi.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> assistsId) throws Exception;
}
