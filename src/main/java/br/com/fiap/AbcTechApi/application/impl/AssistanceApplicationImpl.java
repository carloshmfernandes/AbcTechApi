package br.com.fiap.AbcTechApi.application.impl;

import br.com.fiap.AbcTechApi.application.AssistanceApplication;
import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;
import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .map(o -> new AssistResponseDto(o.getId(), o.getName(), o.getDescription()))
                .collect(Collectors.toList());
        return assistDtos;
    }

    @Override
    public void createAssist(List<AssistResponseDto> assistResponseDtos) throws Exception {
        ArrayList<Assistance> list = new ArrayList<>();

        for(AssistResponseDto aDto: assistResponseDtos){
            Assistance assistance = new Assistance();
            assistance.setName(aDto.getName());
            assistance.setDescription(aDto.getDescription());
            
            list.add(assistance);    
        }        
        
        this.assistanceService.saveAssistance(list);
    }

}
