package com.adlis.Account.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	Logger logger = LoggerFactory.getLogger(LoggingController.class);
}