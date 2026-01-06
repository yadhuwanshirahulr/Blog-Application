package com.yadhuwanshirahul.blog.application.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yadhuwanshirahul.blog.application.Model.User;
import com.yadhuwanshirahul.blog.application.PayLoad.UserDto;
import com.yadhuwanshirahul.blog.application.Reposirtory.UserRepo;
import com.yadhuwanshirahul.blog.application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto addUser(UserDto user) {
		User user1 = dtoToUser(user);
		userRepo.save(user1);
		return user;
	}

	@Override
	@Transactional
	public UserDto updateUser(UserDto user, Integer userId) {
		User dbUser = userRepo.findById(userId).get();
		dbUser.setUsername(user.getUsername());
		dbUser.setPassword(user.getPassword());
		dbUser.setEmail(user.getEmail());
		dbUser.setAbout(user.getAbout());
		user.setId(dbUser.getId());
		return user;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> allUsers = userRepo.findAll();
		List<UserDto> response = new ArrayList<>();
		for(User u:allUsers){
			UserDto user = mapToDto(u);
			response.add(user);
		}
		return response;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
		
	}
	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		return user;
	}
	private UserDto mapToDto(User user){
		UserDto dto = new UserDto();
		dto.setAbout(user.getAbout());
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setPassword(user.getPassword());
		dto.setUsername(user.getUsername());
		return dto;
	}

}
