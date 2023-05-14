package br.com.fiap.AbcTechApi.handler;

import br.com.fiap.AbcTechApi.handler.exception.MaximumAssistException;
import br.com.fiap.AbcTechApi.handler.exception.MinimumAssistRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimumAssistRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRequired(MinimumAssistRequiredException exception){
        ErrorMessageResponse error = new ErrorMessageResponse(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaximumAssistException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistRequired(MaximumAssistException exception){
        ErrorMessageResponse error = new ErrorMessageResponse(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
