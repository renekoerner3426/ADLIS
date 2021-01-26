package com.adlis.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Chris Froemling
 * @author Rene Koerner
 * AccountEntity
 */
@Entity
public class Account {
	
	@Id
	@Column
	private String fin;
	@Column
	private String password;
	
	public Account(String fin, String password) {
		this.fin = fin;
		this.password = password;
	}

	public Account() {
		//for DB only
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
