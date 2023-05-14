package br.com.fiap.AbcTechApi.service.impl;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.entity.Order;
import br.com.fiap.AbcTechApi.handler.exception.MaximumAssistException;
import br.com.fiap.AbcTechApi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.repository.OrderRepository;
import br.com.fiap.AbcTechApi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final AssistanceRepository assistanceRepository;
    private final OrderRepository orderRepository;
    private boolean ExisteAssistanceInvalidas;

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
        ExisteAssistanceInvalidas = false;
        assistsId.forEach( id -> {
            Optional<Assistance> assistance = assistanceRepository.findById(id);
            if(assistance.isPresent()) {
               list.add(assistance.get());
            }
            else{
                ExisteAssistanceInvalidas = true;
            }
        });

        if (ExisteAssistanceInvalidas){
            throw new MinimumAssistRequiredException("Error na(s) assistência(s)", "Informado ordem para assistência inexistente!");
        }
        else if (list.isEmpty()){
            throw new MinimumAssistRequiredException("Error na(s) assistência(s)", "Não encontramos nenhuma assistência valida");
        } else  if (list.size() > 15){
            throw new MaximumAssistException("Error nas assistências", "Não devemos enviar mais de 15 assistências");
        }
        order.setAssists(list);

        orderRepository.save(order);
    }
}
