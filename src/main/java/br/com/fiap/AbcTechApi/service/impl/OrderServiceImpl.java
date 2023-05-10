package br.com.fiap.AbcTechApi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.entity.Order;
import br.com.fiap.AbcTechApi.handler.exception.MaximumAssistException;
import br.com.fiap.AbcTechApi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.repository.OrderRepository;
import br.com.fiap.AbcTechApi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final AssistanceRepository assistanceRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(
            AssistanceRepository assistanceRepository,
            OrderRepository orderRepository
    ) {
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> assistsId) throws Exception {
        ArrayList<Assistance> list = new ArrayList<>();
        assistsId.forEach( id -> {
            Optional<Assistance> assistance = assistanceRepository.findById(id);
            assistance.ifPresent(list::add);

        });

        if (list.isEmpty()){
            throw new MinimumAssistRequiredException("Error nas assistências", "Não encontramos nenhuma assistência valida");
        } else  if (list.size() > 15){
            throw new MaximumAssistException("Error nas assistências", "Não devemos enviar mais de 15 assistências");
        }
        order.setAssists(list);

        orderRepository.save(order);
    }
}
