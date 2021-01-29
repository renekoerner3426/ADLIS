package com.adlis.Account;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	private String accountServiceEnvVar = System.getenv("Account_Service_IP");
	private final String GET_URL = "http://" + this.accountServiceEnvVar + ":8083";

	@CrossOrigin("*")
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Account saveAccount(@RequestBody Account account) {
		System.out.println("neu klappt");
		return this.accountService.save(account);
	}
	
	@CrossOrigin("*")
	@GetMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public boolean checkLogin(@RequestBody Account account) {
		System.out.println("login klappt");
		return this.accountService.checkLoginData(account);
	}

}
