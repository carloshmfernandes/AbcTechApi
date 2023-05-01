package br.com.fiap.AbcTechApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCkechController {
    
    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("UP");
    }
}
