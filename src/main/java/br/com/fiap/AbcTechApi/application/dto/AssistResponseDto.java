package br.com.fiap.AbcTechApi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssistResponseDto {
    private Long id;
    private String title;
    private String description;
}
