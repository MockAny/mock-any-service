package com.mockany.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockany.entity.Mock;
import com.mockany.repository.MockRepository;

@RestController
@RequestMapping(path = "mock", produces = MediaType.APPLICATION_JSON_VALUE)
public class MockController {

	@Autowired
	private MockRepository repository;

	@GetMapping("{key}")
	public String retrieve(@PathVariable("key") String key) {
		return repository.findOne(key).getJson();
	}

	@PostMapping(produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody String json) {
		String id = repository.save(new Mock(json)).getId();
		return ResponseEntity.ok(id);
	}
}
