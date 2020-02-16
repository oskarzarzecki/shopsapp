package com.oskiapps.shopsapp.model.auxiliaries;

public class AuthenticatedUser {

	private String username;

	public AuthenticatedUser(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
