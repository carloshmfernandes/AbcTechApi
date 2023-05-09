package br.com.fiap.AbcTechApi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.repository.AssistanceRepository;
import br.com.fiap.AbcTechApi.service.AssistanceService;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository assistanceRepository;

    public AssistanceServiceImpl(AssistanceRepository assistanceRepository){
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public List<Assistance> getAssistsList() { return this.assistanceRepository.findAll();}    
}
