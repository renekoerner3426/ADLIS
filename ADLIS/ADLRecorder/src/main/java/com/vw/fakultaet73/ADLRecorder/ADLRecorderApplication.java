package com.vw.fakultaet73.ADLRecorder;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ADLRecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ADLRecorderApplication.class, args);
		postADLRecord();
	}

	private static void postADLRecord() {
		try {
			URI POST_URL = new URI("http://34.72.176.97:8081/adl-api/v1/saveADL");
			RestTemplate restTemplate = new RestTemplate();
			// restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
			// restTemplate.getMessageConverters().add(0, new
			// StringHttpMessageConverter(Charset.forName("UTF-8")));
			HttpEntity<ADLRecord> adlRecord = new HttpEntity<>(new ADLRecordGenerator().generateADLRecord(), null);
			restTemplate.postForObject(POST_URL, adlRecord, ADLRecord.class);
		} catch (URISyntaxException e) {
			System.out.println("Falsche URI");
		} catch (RestClientException e) {
			System.out.println("Keine richtige Antwort erhalten");
		}
	}
}
