package br.com.fiap.AbcTechApi.service;
import br.com.fiap.AbcTechApi.entity.Assistance;
import java.util.List;

public interface AssistanceService {
    List<Assistance> getAssists();

    void saveAssistance(Assistance assistance) throws Exception;
}
