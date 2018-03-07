package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ExceptionController {

	@RequestMapping(value="/badRequest.do")
	public String badRequestException(
				Model model
			){
		
		return "error/exception";
	}
	
	
	@RequestMapping(value="/sqlException.do")
	public String sqlException(
				Model model
			){
		
		return "error/exception";
	}
	
}
