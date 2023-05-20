package br.com.fiap.AbcTechApi.handler.exception;

import lombok.Getter;

@Getter
public class EmptyAssistException extends RuntimeException {
    private String description;
    
    public EmptyAssistException(String message, String description){
        super(message);
        this.description = description;
    }
}
