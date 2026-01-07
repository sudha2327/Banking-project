package com.bank.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/audit")
public class Auditpdfcontrller {
	
	@GetMapping("/")
	public String  hello() {
		return "Active page successfull";
	}
	
}
