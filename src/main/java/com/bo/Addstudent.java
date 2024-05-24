package com.bo;

public class Addstudent 
{
	private int id;

private String sname;
private String email;
private String phone;
private String stream;
private String clgname;
private String DOB;
private String city;
private String state;
private String country;
private int zip;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}
public String getClgname() {
	return clgname;
}
public void setClgname(String clgname) {
	this.clgname = clgname;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getZip() {
	return zip;
}
public void setZip(int zip) {
	this.zip = zip;
}
/**
 
 * @param sname
 * @param email
 * @param phone
 * @param stream
 * @param clgname
 * @param dOB
 * @param city
 * @param state
 * @param country
 * @param zip
 */
public Addstudent(String sname, String email, String phone, String stream, String clgname, String dOB, String city,
		String state, String country, int zip) {
	super();
	
	this.sname = sname;
	this.email = email;
	this.phone = phone;
	this.stream = stream;
	this.clgname = clgname;
	DOB = dOB;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zip = zip;
}
/**
 * @param id
 * @param sname
 * @param email
 * @param phone
 * @param stream
 * @param clgname
 * @param dOB
 * @param city
 * @param state
 * @param country
 * @param zip
 */
public Addstudent(int id, String sname, String email, String phone, String stream, String clgname, String dOB,
		String city, String state, String country, int zip) {
	super();
	this.id = id;
	this.sname = sname;
	this.email = email;
	this.phone = phone;
	this.stream = stream;
	this.clgname = clgname;
	DOB = dOB;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zip = zip;
}
/**
 * 
 * 
 */
public Addstudent() {
	super();
	// TODO Auto-generated constructor stub
}


  


}