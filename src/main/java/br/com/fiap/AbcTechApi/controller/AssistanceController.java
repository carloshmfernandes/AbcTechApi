package br.com.fiap.AbcTechApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AbcTechApi.application.AssistanceApplication;
import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;

@RequestMapping("/assists")
@RestController
public class AssistanceController {

    private final AssistanceApplication assistanceApplication;

    @Autowired
    public AssistanceController(AssistanceApplication assistanceApplication){
               this.assistanceApplication = assistanceApplication;
    }
    
    @GetMapping
    public ResponseEntity<List<AssistResponseDto>> getAssists(){
         return ResponseEntity.ok(assistanceApplication.getAssists());
    }
    
}
