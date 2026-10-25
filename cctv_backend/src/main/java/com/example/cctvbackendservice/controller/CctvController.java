package com.example.cctvbackendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cctvbackendservice.entity.ContactUS;
import com.example.cctvbackendservice.service.CcctvService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class CctvController {
	
	@Autowired
	CcctvService cctvService;

	@PostMapping("/create_contact_us")
	public ResponseEntity<?> createContactUs(@RequestBody ContactUS createContactUs ) {

		System.err.println("-------------");
		System.err.println("Call Come from Broswer");
		
		
		return cctvService.createContactUsService(createContactUs );
	}
	
	

	@GetMapping("/create_contact_us2")
	public String getLead( ) {

		System.err.println("-------------");
		System.err.println("Call Come from Broswer");
		return cctvService.getLead( );
	}
	

}
