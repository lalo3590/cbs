package com.hsbc.eep.cbs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/")
	public String index() {
		return "Hola crayola";
	}
	
	@GetMapping("/hola")
	public String other() {
		return "Hola crayola";
	}
}
