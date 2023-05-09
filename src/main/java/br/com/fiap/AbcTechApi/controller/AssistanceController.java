package br.com.fiap.AbcTechApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AbcTechApi.entity.Assistance;
import br.com.fiap.AbcTechApi.service.AssistanceService;

@RequestMapping("/assists")
@RestController
public class AssistanceController {
    
    private final AssistanceService assistanceService;

    @Autowired
    public AssistanceController(AssistanceService assistanceService){
       this.assistanceService = assistanceService;
    }
    
    @GetMapping
     public ResponseEntity<List<Assistance>> getAssists(){
         return ResponseEntity.ok(assistanceService.getAssistsList());
     }
    
}
