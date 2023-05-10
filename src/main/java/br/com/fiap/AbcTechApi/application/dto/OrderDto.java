package br.com.fiap.AbcTechApi.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    @NotNull
    private Long operatorId;
    @NotEmpty
    private List<Long> services;

    @Valid
    private OrderLocationDto start;

    @Valid
    private OrderLocationDto end;
}