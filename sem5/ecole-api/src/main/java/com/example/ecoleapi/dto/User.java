package com.example.ecoleapi.dto;

public class User {
	private Integer id;
	private String login;
	private String mdp;
	private String role;

	public User() {

	}

	public User(Integer id, String login, String mdp, String role) {
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}