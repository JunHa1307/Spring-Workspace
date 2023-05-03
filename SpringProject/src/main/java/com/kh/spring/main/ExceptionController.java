package com.kh.spring.main;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	/*
	 * 스프링 예외 처리 방법(3가지, 중복사용가능)
	 * 
	 * 1 순위 : 메서드별 예외처리(try/catch, throws)
	 * 
	 * 2 순위 : 하나의 컨트롤러에서 발생하는 예외를 싹 모아서 처리 -> @ExceptionHandler
	 * 
	 * 3 순위 : 웹 애플리케이션 전역에서 발생하는 예외를 다 모아서 처리 -> @ControllerAdvice
	 */
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		e.printStackTrace();
		
		model.addAttribute("errorMsg","서비스 이용중 문제가 발생했습니다.");
		model.addAttribute("e",e);
		return "common/errorPage";
	}
	
}
