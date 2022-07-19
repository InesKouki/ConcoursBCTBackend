package tn.gov.bct.concours.models;

import javax.validation.constraints.NotBlank;

public class ConfirmRequest {


	private Long id;
	
	private String username;
	
	private String password;
	
	private String code;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
