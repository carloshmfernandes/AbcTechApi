package br.com.fiap.AbcTechApi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;

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
