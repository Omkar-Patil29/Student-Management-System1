package com.bo;

public class Student 
{
private String name;
private String email;
private String username;
private String password;
private int id;

private String forgetpwd;
/**
 * @param username
 * @param forgetpwd
 */
public Student(String name, String email, String username, String password) 
{
	super();
	this.name = name;
	this.email = email;
	this.username = username;
	this.password = password;
	
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public void setName(String name) {
	this.name = name;
}


public void setEmail(String email) {
	this.email = email;
}


public void setUsername(String username) {
	this.username = username;
}


public void setPassword(String password) {
	this.password = password;
}


public String getUsername() {
	return username;
}
public String getPassword() 
{
	return password;
}






/**
 * @param email
 * @param id
 * @param forgetpwd
 */
public Student(String email, int id, String forgetpwd) {
	super();
	this.email = email;
	this.id = id;
	this.forgetpwd = forgetpwd;
}
public String getForgetpwd() {
	return forgetpwd;
}
public void setForgetpwd(String forgetpwd) {
	this.forgetpwd = forgetpwd;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}

