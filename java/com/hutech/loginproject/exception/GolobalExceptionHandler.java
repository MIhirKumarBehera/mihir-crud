package com.hutech.loginproject.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.hutech.loginproject.response.ApiResponse;

@RestControllerAdvice
public class GolobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(msg,false);
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> notValidExceptionHandler(MethodArgumentNotValidException expt){
		Map<String, String> resp=new HashMap<>();
		expt.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName=((FieldError)error).getField();
		String msg=error.getDefaultMessage();
		resp.put(fieldName, msg);
		});
		return new ResponseEntity<Map<String,String>> (resp,HttpStatus.BAD_REQUEST);
		
	}

}
