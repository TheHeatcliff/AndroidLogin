package ar.com.globallogic.services;

import java.util.Collections;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.Message;

public class SpringAuthenticationService implements IAuthenticationService{

	//VER COMO INYECTAR ESTAS COSAS
	private String url;
	
	public void doLogin(String userName,String password) throws Exception {
		
		HttpAuthentication authHeader = new HttpBasicAuthentication(userName, password);
		
		HttpHeaders requestHeaders = new HttpHeaders();
		
		requestHeaders.setAuthorization(authHeader);
		
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		
		ResponseEntity<Message> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(requestHeaders), Message.class);
		
		if (!response.getStatusCode().equals(HttpStatus.ACCEPTED)){
			throw new Exception("Invalid credentials");
		}
	}
}
