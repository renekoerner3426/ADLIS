package com.adlis.Account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.adlis.Account.controller.AccountController;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AccountController.class)
public class AccountControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private AccountService service;

	@Test
	public void correctResponseForNewAccount() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/account/new").content(asJsonString(new Account()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

	@Test
	public void correctLoginCheck() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/account/login").content(asJsonString(new Account()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
