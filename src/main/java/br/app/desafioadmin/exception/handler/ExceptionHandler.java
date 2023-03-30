package br.app.desafioadmin.exception.handler;

import br.app.desafioadmin.exception.UsuarioBusinessExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UsuarioBusinessExcepetion.class)
    public ResponseEntity<DefaultException> handlerbadrequest(UsuarioBusinessExcepetion e) {
        DefaultException defaultException = new DefaultException();
        defaultException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        defaultException.setMessage("ERRO!");
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    public ResponseEntity<DefaultException> handler(UsuarioBusinessExcepetion e) {
        DefaultException defaultException = new DefaultException();
        defaultException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        defaultException.setMessage("ERRO!500 INTERNAL SERVER ERRO");
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }
}