package br.com.fiap.AbcTechApi.application;

import br.com.fiap.AbcTechApi.application.dto.OrderDto;

public interface OrderApplication {

    public void createOrder(OrderDto orderDto) throws Exception;
}
