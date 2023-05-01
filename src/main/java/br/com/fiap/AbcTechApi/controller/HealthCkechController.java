package br.com.fiap.AbcTechApi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.http.ResponseEntity;
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


    @GetMapping("version")
    public ResponseEntity<String> version() throws IOException{
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);

        return ResponseEntity.ok(properties.get("build_name") + " - " + properties.get("build_version"));

        
    }

}
