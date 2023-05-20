package br.com.fiap.AbcTechApi.service;
 
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.entity.Order;
import br.com.fiap.AbcTechApi.entity.OrderLocation;
import br.com.fiap.AbcTechApi.handler.exception.MaximumAssistException;
import br.com.fiap.AbcTechApi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.repository.OrderRepository;
import br.com.fiap.AbcTechApi.service.impl.OrderServiceImpl;

@SpringBootTest
public class OrderServiceTest {

    @MockBean
    private AssistanceRepository assistanceRepository;
    @MockBean
    private OrderRepository orderRepository;

    private OrderService orderService;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(assistanceRepository,orderRepository);
        Mockito.when(assistanceRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Assistance(1L, "Teste", "Teste Description")));
    }

    //minimum assistencias > 0
    @Test
    public void create_order_error_min_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    //maximo assistencias <= 15
    @Test
    public void create_order_error_max_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L)));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void create_order(){
        //-23.650793978994333, -46.61424611750358        
        Date datainicial = new Date();
        Date datafinal = datainicial;        
        Timestamp tsinicial = new Timestamp(datainicial.getTime());
        datafinal.setTime(7200000);
        Timestamp tsfinal = new Timestamp(datafinal.getTime());

        Order order = new Order();
        order.setOperatorId(1L);
        order.setStartOrderLocation(
                new OrderLocation(1L, -23.650793978994333, -46.61424611750358, tsinicial));
        order.setStartOrderLocation(
                    new OrderLocation(1L, -23.650793978994333, -46.61424611750358, tsfinal));

        Mockito.verify(orderRepository, Mockito.times(0)).save(order);
    }

    //cenario criando order
    //Para entrega
}
   

