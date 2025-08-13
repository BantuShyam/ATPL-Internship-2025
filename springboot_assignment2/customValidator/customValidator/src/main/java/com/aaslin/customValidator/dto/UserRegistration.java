package com.aaslin.customValidator.dto;

import com.aaslin.customValidator.annotation.PasswordMatches;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@PasswordMatches
public class UserRegistration {

	@NotBlank(message="Username is required")
	private String userName;
	
	@NotBlank(message="Password is required")
	private String password;
	
	
	@NotBlank(message="confirm passord is required")
	private String confirmPassword;
	
	@Min(value=18,message="age must be atleast 18")
	private int age;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
