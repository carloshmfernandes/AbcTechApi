package br.com.fiap.AbcTechApi.application.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.AbcTechApi.application.AssistanceApplication;
import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;
import br.com.fiap.AbcTechApi.service.AssistanceService;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {
    private final AssistanceService assistanceService;

    @Autowired
    public AssistanceApplicationImpl(AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }

    @Override
    public List<AssistResponseDto> getAssists() {
        
        List<AssistResponseDto> assistDtos = this.assistanceService.getAssists()
                .stream()
                        .map(x -> new AssistResponseDto(x.getId(), x.getName(), x.getDescription()))
                                .collect(Collectors.toList());
                                
        return assistDtos;
    }
    
}
