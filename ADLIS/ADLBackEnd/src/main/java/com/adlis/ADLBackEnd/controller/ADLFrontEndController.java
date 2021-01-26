package com.adlis.ADLBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adlis.ADLBackEnd.entities.ADLRecord;
import com.adlis.ADLBackEnd.services.ADLRecordService;


@RestController
@RequestMapping("/adl-api/v1")
public class ADLFrontEndController {

	@Autowired
	private ADLRecordService adlRecordService;

	@CrossOrigin("*")
	@GetMapping("/adlRecords")
	@ResponseStatus(HttpStatus.OK)
	public List<ADLRecord> getAdlRecords() {
		return this.adlRecordService.getRecordList();
		
		
	}
}
