package com.project1.employee.advice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.project1.employee.entity.ErrorResponse;
import com.project1.employee.entity.Stud;
import com.project1.employee.exception.NotFoundException;

@RestControllerAdvice
public class Exceptionhandler {
    
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public Map<String , Object> exception(MethodArgumentNotValidException except){
		
		Map<String, Object> errorMap=new HashMap<>();
		except.getBindingResult().getFieldErrors().forEach(error ->
		errorMap.put(error.getField(), error.getDefaultMessage())
				);
		
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setCode(200);
		errorResponse.setStatus("Enter proper valid result");
		errorResponse.setStackTrace(except.getCause());
		
		 Map<String, Object> errorMap1=new HashMap<>();    
		 errorMap1.put("Errors", errorResponse);
		errorMap1.put("FieldErrors", errorMap);
		return  errorMap1;
		
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= NotFoundException.class)
	public Map<String, Stud> handlerExc(NotFoundException exce){
		
		Map<String, String> erro=new  HashMap<>();
		erro.put("Errors", exce.getMessage());
		
		Stud stud=new Stud();
		stud.setTimestamp(LocalDateTime.now());
		stud.setCode(HttpStatus.BAD_REQUEST.value());
		stud.setStatus("Good crediantials will be there");
		stud.setMessage("Exception Handle");
		
		Map<String, Stud> stu=new HashMap<>();
		stu.put("Errors", stud);
		return stu;
		
	}

}
