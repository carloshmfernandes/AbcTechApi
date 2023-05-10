package br.com.fiap.AbcTechApi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.validation.constraints.PastOrPresent;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLocationDto {

    private Double latitude;
    private Double longitude;

    @PastOrPresent
    @JsonProperty("dateTime")
    private Date date;
}
