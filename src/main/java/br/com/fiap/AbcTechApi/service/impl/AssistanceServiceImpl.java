package br.com.fiap.AbcTechApi.service.impl;

import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;
import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.handler.exception.EmptyAssistException;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository assistanceRepository;

    @Autowired
    public AssistanceServiceImpl(AssistanceRepository assistanceRepository){
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public List<Assistance> getAssists() {
        return this.assistanceRepository.findAll();
    }

    @Override
    public void saveAssistance(Assistance assistance) throws Exception {
        //List<Assistance> assistslist = new ArrayList<>();
        
        // assistance.forEach(name -> {
        //    if (name.getName().isEmpty() == false){
        //     throw new EmptyAssistException("Error na assistência", "Informe o nome para a serviço!");
        //    }
        //    if (name.getDescription().isEmpty()){
        //     throw new EmptyAssistException("Error na assistência", "Informe a descrição para a serviço!");
        //     }
        // });

        assistanceRepository.save(assistance);        
    }
}
