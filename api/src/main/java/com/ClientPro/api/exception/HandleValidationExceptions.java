package com.ClientPro.api.exception;


import com.ClientPro.api.model.dtos.ErrorDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Order
@Log4j2
@ControllerAdvice
public class HandleValidationExceptions {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(Exception e) {

        ErrorDTO erroCapturado =
                ErrorDTO.builder() //
                        .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) //
                        .detalhes(e.getMessage())
                        .build();

        log.info("Erros", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroCapturado);
    }
}
