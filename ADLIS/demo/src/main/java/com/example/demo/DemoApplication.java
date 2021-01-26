package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/adl-api/v1")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@CrossOrigin("*")
	@PostMapping("/saveADL")
	@ResponseStatus(HttpStatus.CREATED)
	public ADLRecord getRecord(@RequestBody ADLRecord adlRecord) {
		System.out.println(adlRecord);
		return adlRecord;
	}
	
	@GetMapping("/exception/throw")
	public void getException() throws Exception {
	    throw new Exception("error");
	}
}
