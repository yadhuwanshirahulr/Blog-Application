package com.yadhuwanshirahul.blog.application.PayLoad;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class UserDto {
	private int id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@Email(message = "Please enter a valid email address")
	private String email;
	@NotEmpty
	@Size(min = 4, max = 50, message = "Please enter about between 4 to 50 characters")
	private String about;

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
}
