package com.adlis.Account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adlis.Account.Account;
import com.adlis.Account.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private LoggingController loggingController;

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Account saveAccount(@RequestBody Account account) {
		this.loggingController.logger.info("new Account created!");
		System.out.println("neu klappt");
		return this.accountService.save(account);
	}

	@GetMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public boolean checkLogin(@RequestBody Account account) {
		this.loggingController.logger.info("somebody just logged in!");
		return this.accountService.checkLoginData(account);
	}

}
