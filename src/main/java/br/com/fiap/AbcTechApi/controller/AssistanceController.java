package br.com.fiap.AbcTechApi.controller;


import br.com.fiap.AbcTechApi.application.AssistanceApplication;
import br.com.fiap.AbcTechApi.application.dto.AssistResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RequestMapping("/AbcTechApi/assists/")
@RestController
public class AssistanceController {


    private final AssistanceApplication assistanceApplication;

    @Autowired
    public AssistanceController(AssistanceApplication assistanceApplication){
        this.assistanceApplication = assistanceApplication;
    }

    @GetMapping("get")
    public ResponseEntity<List<AssistResponseDto>> getAssists(){

        return ResponseEntity.ok(assistanceApplication.getAssists());
    }

    @PostMapping("post")
    public ResponseEntity<String> create(@Valid @RequestBody AssistResponseDto assistDto) throws Exception {

        this.assistanceApplication.createAssist(assistDto);
        return ResponseEntity.ok().build();
    }


}
