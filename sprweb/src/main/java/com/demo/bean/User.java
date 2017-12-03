package com.demo.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	@Size(min = 3, max = 10)
	private String userId;
	@NotNull
	@Size(min = 5, max = 20)
	private String userName;
	@NotNull
	private String gender;
	private Boolean married;
	private String profile;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId) {
		super();
		this.userId = userId;
	}

	public User(String userId, String userName, String gender, Boolean married, String profile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.married = married;
		this.profile = profile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public int compareTo(String anotherString) {
		return userId.compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return userId.compareToIgnoreCase(str);
	}
	
	

}
