package com.vw.fakultaet73.ADLRecorder;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
		List<String> fins = new ArrayList<>(Arrays.asList("WVWZZZ1JZ3W386752", "WVWABC1JZ3W324523", "WVWZKL5TG0W365465", "WVWSDF1CP3W456646",
				"WVWDTK1JZ3W198834", "WVWZOB1JZ3W553532", "WVWDRH1JZ3W164931", "WVWDUT1JZ3W897456", "WVWJUL1JZ3W123568", "WVWSER1JZ3W786541"));
		for (String fin : fins) {
			try {
				// URL for local testing
				// URI POST_URL = new URI("http://localhost:8082/adl-api/v1/saveADL");
				URI POST_URL = new URI("http://localhost:8082/adl-api/v1/saveADL");
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setBasicAuth("admin", "admin");
				System.out.println(headers);
				// restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
				// restTemplate.getMessageConverters().add(0, new
				// StringHttpMessageConverter(Charset.forName("UTF-8")));
				HttpEntity<ADLRecord> adlRecord = new HttpEntity<>(new ADLRecordGenerator().generateADLRecord(fin), headers);
				restTemplate.postForObject(POST_URL, adlRecord, ADLRecord.class);
			} catch (URISyntaxException e) {
				System.out.println("Falsche URI");
			} catch (RestClientException e) {
				System.out.println(e);
			}		
		}
		
	}
}
