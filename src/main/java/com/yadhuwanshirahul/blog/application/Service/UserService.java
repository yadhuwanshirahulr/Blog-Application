package com.yadhuwanshirahul.blog.application.Service;

import java.util.List;

import com.yadhuwanshirahul.blog.application.PayLoad.UserDto;

public interface UserService {
	UserDto addUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	List<UserDto> getAllUser();
	void deleteUser(Integer userId);

}
