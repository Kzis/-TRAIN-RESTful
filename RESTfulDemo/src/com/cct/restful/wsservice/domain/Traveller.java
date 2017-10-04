package com.cct.restful.wsservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Traveller implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;

	private List<Address> listAddress = new ArrayList<Address>();

	public Traveller() {

	}

	public Traveller(int id, String firstName, List<Address> listAddress) {
		this.id = id;
		this.firstName = firstName;
		this.listAddress = listAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

}
