package br.com.fiap.AbcTechApi.application;

import java.util.List;

import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;

public interface AssistanceApplication {
    public List<AssistResponseDto> getAssists();
}
