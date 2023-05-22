package br.com.fiap.AbcTechApi.service;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.handler.exception.EmptyAssistException;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {

    @MockBean
    private AssistanceRepository assistanceRepository;

    private AssistanceService assistanceService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }


    @Test
    public void test_list_assistance(){
        Mockito.when(assistanceRepository.findAll())
                .thenReturn(
                        List.of(new Assistance(1L, "Test", "Test Description")));
        List<Assistance> list = assistanceService.getAssists();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    public void test_create_assist() {
        List<Assistance> assists = new ArrayList<>(); 
        assists.add(new Assistance(null, "Test", "Test Description"));
        assists.add(new Assistance(null, "Test", "Test Description"));

        Mockito.verify(assistanceRepository, Mockito.times(0)).saveAll(assists);        
    }

    @Test
    public void test_create_assist_vazio() {
        List<Assistance> assists = new ArrayList<>(); 
        assists.add(new Assistance(null, "Test 999", "Test Description"));
        assists.add(new Assistance(null, "", "Test Description"));
        Assertions.assertThrows(EmptyAssistException.class, () -> assistanceService.saveAssistance(assists));
        
        Mockito.verify(assistanceRepository, Mockito.times(0)).saveAll(assists);
    }
}
