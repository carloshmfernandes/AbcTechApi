package br.com.fiap.AbcTechApi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.service.impl.AssistanceServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
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

    // @Test
    // public void test_list_success(){
    //     Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
    //     Assistance itemAssist2 = new Assistance(2L, "Mock Name 2", "Mock Description 2");

    //     when(assistanceRepository.findAll()).thenReturn(List.of(itemAssist,itemAssist2));

    //     List<Assistance> values = assistanceService.getAssistsList();

    //     Assertions.assertEquals(values.size(), 2);
    //     Assertions.assertSame(values.get(0), itemAssist);
    //     Assertions.assertSame(values.get(1), itemAssist2);
    // }


    // @Test
    // public void test_list_empty(){
    //     when(assistanceRepository.findAll()).thenReturn(List.of());

    //     List<Assistance> values = assistanceService.getAssistsList();

    //     Assertions.assertEquals(values.size(), 0);
    // }
}
