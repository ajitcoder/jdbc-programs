package com.jdbc_mini_project;


public class Student {

	int id;
	String name;
	String address;
	String adharNo;
	
	public Student(int id, String name, String address, String adharNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.adharNo = adharNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", adharNo=" + adharNo + "]";
	}

	
}