package com.adlis.ADLBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adlis.ADLBackEnd.entities.ADLRecord;
import com.adlis.ADLBackEnd.services.ADLRecordService;

@RestController
@RequestMapping("/adl-api/v1")
public class ADLRecorderController {

	@Autowired
	private ADLRecordService adlRecordService;

	@Autowired
	LoggingController loggingController;

	@PostMapping("/saveADL")
	@ResponseStatus(HttpStatus.CREATED)
	public ADLRecord createAdlRecord(@RequestBody ADLRecord adlRecord) {
		this.loggingController.logger.info("new ADLRecord saved!");
		return this.adlRecordService.saveRecord(adlRecord);
	}
}
