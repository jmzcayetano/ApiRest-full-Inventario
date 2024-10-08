package com.example.restinventario.entity;

public class Casa {

	private Long id;
	private String description;

	public Casa() {
		super();
	}

	public Casa(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
