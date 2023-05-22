// package br.com.fiap.AbcTechApi.controller;

// import java.nio.charset.StandardCharsets;
// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Optional;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.http.MediaType;

// import br.com.fiap.AbcTechApi.application.dto.OrderDto;
// import br.com.fiap.AbcTechApi.application.dto.OrderLocationDto;
// import br.com.fiap.AbcTechApi.entity.Assistance;
// import br.com.fiap.AbcTechApi.entity.Order;
// import br.com.fiap.AbcTechApi.entity.OrderLocation;
// import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
// import br.com.fiap.AbcTechApi.repository.OrderRepository;
// import br.com.fiap.AbcTechApi.service.impl.OrderServiceImpl;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class OrderControllerTest {    
    
//     private OrderDto orderDto;
//     private Order order;

//     @Autowired
//     private ObjectMapper mapper;
//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private AssistanceRepository assistanceRepository;
//     @MockBean
//     private OrderRepository orderRepository;

//     private OrderServiceImpl orderService;

//     @BeforeEach
//     public void init() {  
//         orderService = new OrderServiceImpl(assistanceRepository, orderRepository);
        
//         MockitoAnnotations.openMocks(this);
//         orderService = new OrderServiceImpl(assistanceRepository,orderRepository);
//         Mockito.when(assistanceRepository.findById(Mockito.any()))
//                 .thenReturn(Optional.of(new Assistance(1L, "Teste", "Teste Description")));
//      }
    
//     @Test
//     void teste_createorder_post() throws Exception {
//         Date datainicial = new Date();    
//         Timestamp tsinicial = new Timestamp(datainicial.getTime());
//         Timestamp tsfinal = new Timestamp(datainicial.getTime() + 7200000);

//         orderDto = new OrderDto();        
//         orderDto.setOperatorId(1L);
//         orderDto.setServices(List.of(1L));
//         orderDto.setStart(new OrderLocationDto(-23.650793978994333, -46.61424611750358, tsinicial)); 
//         orderDto.setEnd(new OrderLocationDto(-23.650793978994333, -46.61424611750358, tsfinal));
        
//         order = new Order();
//         order.setOperatorId(orderDto.getOperatorId());
//         order.setStartOrderLocation(
//                 new OrderLocation(1L,orderDto.getStart().getLatitude(),orderDto.getStart().getLongitude(),new Timestamp(orderDto.getStart().getDate().getTime())));

//         order.setEndOrderLocation(
//                 new OrderLocation(1L,orderDto.getEnd().getLatitude(),orderDto.getEnd().getLongitude(),new Timestamp(orderDto.getEnd().getDate().getTime())));

//        Mockito.verify(orderRepository, Mockito.times(0)).save(order);
        
//         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/AbcTechApi/order/create")
//         .contentType(MediaType.APPLICATION_JSON)
//         .content(mapper.writeValueAsString(orderDto).getBytes(StandardCharsets.UTF_8))
//         .accept(MediaType.APPLICATION_JSON))
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andReturn();
        
//         Assertions.assertThat(result).isNotNull();
//         String userJson = result.getResponse().getContentAsString();
//         Assertions.assertThat(userJson).isNotEmpty();
//         Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(order));
//     }   
// }
