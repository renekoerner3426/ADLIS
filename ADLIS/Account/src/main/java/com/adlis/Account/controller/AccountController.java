package com.adlis.Account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin("*")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean newAccount(@RequestBody Account account) {
		System.out.println(this.accountService.save(account));
		this.loggingController.logger.info("new Account created!");
		return true;
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public boolean checkLogin(@RequestBody Account account) {
		boolean loggedIn = this.accountService.checkLoginData(account);
		if (loggedIn) {
			this.loggingController.logger.info("somebody just logged in!");
		} else {
			this.loggingController.logger.info("somebody failed to log in!");
		}

		return loggedIn;
	}

}
