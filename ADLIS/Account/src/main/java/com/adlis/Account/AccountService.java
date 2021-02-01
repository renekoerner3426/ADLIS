package com.adlis.Account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public boolean checkLoginData(Account account) {
		Optional<Account> acc = this.accountRepository.findByFin(account.getFin());
		return acc != null ? account.getPassword().equals(acc.get().getPassword()) ? true : false : false;
	}

	public Account save(Account account) {
		return this.accountRepository.save(account);
	}
	
	public boolean checkAccountExistence(Account account) {
		Optional<Account> acc = this.accountRepository.findByFin(account.getFin());
		return acc != null;
	}
}
