package com.adlis.ADLBackEnd;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.adlis.ADLBackEnd.controller.ADLFrontEndController;
import com.adlis.ADLBackEnd.services.ADLRecordService;



@WebMvcTest(ADLFrontEndController.class)
public class ADLFrontEndControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ADLRecordService service;
	
	@Test
	public void sendTheCorrectResponseForGetADLRecords() throws Exception {
	    this.mvc.perform( MockMvcRequestBuilders
	    		.get("/adl-api/v1/adlRecords")
	    		.accept(MediaType.APPLICATION_JSON))
	    		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void sendTheCorrectResponseForRetrieveADLByFin() throws Exception {
	    this.mvc.perform( MockMvcRequestBuilders
	    		.get("/adl-api/v1/retrieveADLByFin/FHDKFFD")
	    		.accept(MediaType.APPLICATION_JSON))
	    		.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
