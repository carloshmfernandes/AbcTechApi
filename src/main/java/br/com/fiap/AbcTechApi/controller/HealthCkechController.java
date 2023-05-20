package br.com.fiap.AbcTechApi.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.AbcTechApi.util.VersionComponent;

@RestController
@RequestMapping("/AbcTechApi/")
public class HealthCkechController {

    private VersionComponent versionComponent;

    public HealthCkechController(@Autowired VersionComponent versionComponent){
        this.versionComponent = versionComponent;
    }
    
    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("UP");
    }

    @GetMapping("version")
    public ResponseEntity<String> version() throws IOException{
        return ResponseEntity.ok(this.versionComponent.getVersion());
    }

}
