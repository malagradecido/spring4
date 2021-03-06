package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.bean.Profile;
import com.demo.bean.User;

@Service
public class UserService {

	private List<User> allUsers = new ArrayList<>();
	private List<Profile> allProfiles = new ArrayList<>();

	public List<User> getAllUserArticles() {
		return allUsers;
	}

	public void addUser(User user) {
		allUsers.add(user);
	}
	
	public List<Profile> getAllProfiles() {
		return allProfiles;
	}

	public void addProfile(Profile profile) {
		allProfiles.add(profile);
	}
	
	public void deleteUser(String userId) {
		allUsers.remove(new User(userId));
		//allUsers.removeIf(user -> user.getUserId().compareTo(userId) == 0);
	}
}
