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

import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {



    private AssistanceService assistanceService;
    @MockBean
    private AssistanceRepository assistanceRepository;


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
    public void  create_assist() {
        Assistance assistance = new Assistance();
        assistance.setName("Create Assist Test");
        assistance.setDescription("Create Assist Test");

        Mockito.verify(assistanceRepository, Mockito.times(0)).save(assistance);
        
    }

    // @Test public void create_asssist_vazio() {
    //     List<Assistance> assistance = new Assistance();
    //     assistance.setName("");
    //     assistance.setDescription("");
    //     Assertions.assertThrows(EmptyAssistException.class, () -> assistanceService.saveAssistance(assistance));
    // }

    @Test public void get_assists(){
        assistanceService.getAssists();
    }

}
