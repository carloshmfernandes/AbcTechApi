package br.com.fiap.AbcTechApi.application.dto;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssistResponseDto {
    private Long id;
    @Valid
    private String name;
    @Valid
    private String description;
}
