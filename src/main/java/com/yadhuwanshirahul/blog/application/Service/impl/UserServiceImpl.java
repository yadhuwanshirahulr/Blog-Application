package com.yadhuwanshirahul.blog.application.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yadhuwanshirahul.blog.application.Exception.ResourceNotFoundException;
import com.yadhuwanshirahul.blog.application.Model.User;
import com.yadhuwanshirahul.blog.application.PayLoad.UserDto;
import com.yadhuwanshirahul.blog.application.Reposirtory.UserRepo;
import com.yadhuwanshirahul.blog.application.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto user) {
		User user1 = dtoToUser(user);
		userRepo.save(user1);
		return user;
	}

	@Override
	@Transactional
	public UserDto updateUser(UserDto user, Integer userId) {
		User dbUser = userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException(  "User",
				"id",
				String.valueOf(userId)));
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
		User user = modelMapper.map(userDto,User.class);
		return user;
	}
	private UserDto mapToDto(User user){
		UserDto dto = modelMapper.map(user,UserDto.class);
		return dto;
	}

}
