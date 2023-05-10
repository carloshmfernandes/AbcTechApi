package br.com.fiap.AbcTechApi.application.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.AbcTechApi.application.OrderApplication;
import br.com.fiap.AbcTechApi.application.dto.OrderDto;
import br.com.fiap.AbcTechApi.entity.Order;
import br.com.fiap.AbcTechApi.entity.OrderLocation;
import br.com.fiap.AbcTechApi.service.OrderService;

@Component
public class OrderApplicationImpl implements OrderApplication {


    private final OrderService orderService;

    @Autowired
    public OrderApplicationImpl(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public void createOrder(OrderDto orderDto) throws Exception {
        //service?
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(
                new OrderLocation(null,
                        orderDto.getStart().getLatitude(),
                        orderDto.getStart().getLongitude(),
                        new Timestamp(orderDto.getStart().getDate().getTime())));

        order.setEndOrderLocation(
                new OrderLocation(null,
                        orderDto.getEnd().getLatitude(),
                        orderDto.getEnd().getLongitude(),
                        new Timestamp(orderDto.getEnd().getDate().getTime())));

        this.orderService.saveOrder(order, orderDto.getServices());
    }
}
