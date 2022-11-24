package com.turkcell.OBS;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.turkcell.OBS.core.exceptions.BusinessException;

@SpringBootApplication
@RestControllerAdvice
public class ObsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObsApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public String badSqlGrammarException(BadSqlGrammarException badSqlGrammarException) {

		return "SQL Grammar Error : \r\n" + badSqlGrammarException.getMessage();
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public String badSqlGrammarException(SQLException sqlException) {

		return "SQL Exception : \r\n" + sqlException.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public String badSqlGrammarException(IllegalStateException illegalStateException) {

		return "Illegal State Exception : \r\n" + illegalStateException.getMessage()
				+ "\r\n\r\n Note: Control the parameter key values are correct!!";
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleBusinessExceptions(BusinessException businessException) {

		return "Business Error : \r\n" + businessException.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleHttpMessageNotReadableException(
			HttpMessageNotReadableException httpMessageNotReadableException) {

		return "JSONPARSE Error : \r\n" + httpMessageNotReadableException.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleValidationExceptions(MethodArgumentNotValidException argumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : argumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return "Validation Error : \r\n" + validationErrors;
	}

}
