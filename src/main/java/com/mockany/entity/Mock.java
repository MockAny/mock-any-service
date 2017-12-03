package com.mockany.entity;

import org.springframework.data.annotation.Id;

public class Mock {

	@Id
	private String id;

	private String json;

	public Mock(String json) {
		this.json = json;
	}

	public String getId() {
		return id;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
