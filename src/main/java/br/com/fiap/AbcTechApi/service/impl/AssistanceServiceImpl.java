package br.com.fiap.AbcTechApi.service.impl;

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
    public void saveAssistance(List<Assistance> assistances) throws Exception {    
        List<Assistance> assists = new ArrayList<>(); 

        assistances.forEach(name -> {
            Assistance assistance = assistanceRepository.findByName(name.getName()); 

            if (name.getName() == "" ){
                throw new EmptyAssistException("Error na(s) assistência(s)", "Nome deve ser informado!");
            } else if (name.getDescription() == ""){
                throw new EmptyAssistException("Error na(s) assistência(s)", "Descrição deve ser informada!");
            }

            if (assistance == null){
                assists.add(name);
            }
        }
        );
        
        assistanceRepository.saveAll(assists);
    }
}
