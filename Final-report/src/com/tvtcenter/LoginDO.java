package com.tvtcenter;
import java.util.Calendar;
public class LoginDO { //java beans Å¬·¡½º
	private String id;
	private String password;
	private String name;
	private String birth;
	private String email;
	private String Role;
	
	
	public LoginDO() {}
	public LoginDO(String id, String password, String name, String birth, String email, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.email = email;
		Role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	

}
