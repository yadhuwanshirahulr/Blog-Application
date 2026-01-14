package com.yadhuwanshirahul.blog.application.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//we can specify the name we want to save in db using column property also we can mark this as not null using same property
	//@Column(name="user_name",nullable = false, length = 100)
	@Nonnull
	private String username;
	private String password;
	private String email;
	private String about;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Nonnull
	public String getUsername() {
		return username;
	}

	public void setUsername(@Nonnull String username) {
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
