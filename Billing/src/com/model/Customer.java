package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "customer")
@Table(name= "customer")
public class Customer implements Serializable {
	
	
	private int id;
	
	private String uname;
	private String upass;
	private String address;
	private Integer flag;
	private String role;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "UNAME", nullable = false)
	public String getUname() {
		return uname;
	}

	

	public void setUname(String uname) {
		this.uname = uname;
	}
	@Column(name = "UPASS", nullable = false)
	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Column(name = "ADDRESS", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "FLAG", nullable = false)
	@NotNull
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", uname=" + uname + ", upass=" + upass + ", address=" + address + ", flag="
				+ flag + "]";
	}

	
	
	
	
	
}
