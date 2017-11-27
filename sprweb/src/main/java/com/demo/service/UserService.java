package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.bean.User;

@Service
public class UserService {

	private List<User> allUsers = new ArrayList<>();

	public List<User> getAllUserArticles() {
		return allUsers;
	}

	public void addUser(User user) {
		allUsers.add(user);
	}

}
