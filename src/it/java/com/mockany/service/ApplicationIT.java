package com.mockany.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIT {

	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();
	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void saveTest() {
		save();
	}

	@Test
	public void findTest() {
		String id = save();
		ResponseEntity<String> response = template.getForEntity(createURLWithPort("/mock/" + id), String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		String json = response.getBody();
		assertThat(json, equalTo(createJson()));
	}

	private String save() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(createJson(), headers);
		String id = template.postForObject(createURLWithPort("/mock"), entity, String.class);
		assertThat(id, notNullValue());
		return id;
	}

	private String createJson() {
		JSONObject obj = new JSONObject();
		obj.put("Name", "Batman");
		return obj.toString();
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
