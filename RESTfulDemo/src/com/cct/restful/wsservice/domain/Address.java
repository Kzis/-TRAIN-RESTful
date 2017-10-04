package com.cct.restful.wsservice.domain;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 5154330036970613143L;

	private String addr;
	private String mobile;

	public Address() {

	}

	public Address(String addr, String mobile) {
		this.addr = addr;
		this.mobile = mobile;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
