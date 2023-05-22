package br.com.fiap.AbcTechApi.application;

import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;

import java.util.List;

public interface AssistanceApplication {

    public List<AssistResponseDto> getAssists();

    public void createAssist(List<AssistResponseDto> assistDto) throws Exception;
}
