package com.mockany.service.com.mockany.service.ws;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = "mock", produces = MediaType.APPLICATION_JSON_VALUE)
public class MockAnyController {

	private HashMap<String, JSONObject> DATA = new HashMap<>();

	@GetMapping("{key}")
	public String retrieve(@PathVariable("key") String key) {
		return DATA.get( key ).toString();
	}

	@PostMapping(produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody String json) {
		String id = "FF90U021U939JHF2M";
		DATA.put( id, new JSONObject( json ) );
		return ResponseEntity.ok( id );
	}
}
