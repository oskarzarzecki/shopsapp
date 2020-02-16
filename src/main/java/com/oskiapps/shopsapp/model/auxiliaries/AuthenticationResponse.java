package com.oskiapps.shopsapp.model.auxiliaries;

public class AuthenticationResponse {

	private String email;

	private String jwtToken;

	public AuthenticationResponse(String email, String jwtToken) {
		super();
		this.email = email;
		this.jwtToken = jwtToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
