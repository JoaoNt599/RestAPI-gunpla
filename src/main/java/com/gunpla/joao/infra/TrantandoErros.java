package com.gunpla.joao.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TrantandoErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> erro404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)	
	public ResponseEntity<?> erro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
	}
	
	public record DadosErros(String campo, String mensagem) {
		
		public DadosErros(FieldError erro) {
			this(
					erro.getField(),
					erro.getDefaultMessage()
				);
		}
	}
}
