package com.cct.restful.wsservice.domain;

import java.util.ArrayList;
import java.util.List;

public class TravellerDAO {

	private List<Traveller> travellerList;
	private List<Address> listAddress;

	public TravellerDAO() {
		travellerList = new ArrayList<Traveller>();
		travellerList.add(new Traveller(1, "Jane", getListAddress1()));
		travellerList.add(new Traveller(2, "Jack", null));
		travellerList.add(new Traveller(3, "June", getListAddress2()));
	}

	private List<Address> getListAddress1() {
		listAddress = new ArrayList<Address>();
		listAddress.add(new Address("123", "0987654321"));
		listAddress.add(new Address("88/12", "029849034"));
		return null;
	}

	private List<Address> getListAddress2() {
		listAddress = new ArrayList<Address>();
		listAddress.add(new Address("99/1", "0989876557"));
		return null;
	}
	
	public List<Traveller> getAllTravellers() {
		return travellerList;
	}

	public Traveller getTraveller(int id) {
		Traveller traveller = new Traveller();
		for (Traveller obj : travellerList) {
			if (obj.getId() == id) {
				traveller = obj;
			}
		}
		
		return traveller;
	}

	public void updateTraveller(Traveller traveller, int id) {
		for (Traveller obj : travellerList) {
			if (obj.getId() == id) {
				obj.setId(traveller.getId());
				obj.setFirstName(traveller.getFirstName());
				return;
			}
		}
	}

	public void deleteTraveller(int id) {
		for (Traveller obj : travellerList) {
			if (obj.getId() == id) {
				travellerList.remove(obj);
				return;
			}
		}
	}

	public void addTraveller(Traveller traveller) {
		for (Traveller obj : travellerList) {
			if (obj.getId() == traveller.getId()) {
				
			}
		}
		travellerList.add(traveller);
	}
	
}
