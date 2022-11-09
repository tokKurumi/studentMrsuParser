package models;

import java.lang.String;

public class Client {
	private int _id;
	private String _name;
	private String _personnelNumber;
	private int _addressId;

	public Client(int id, String name, String personnelNumber, int adressId) {
		_id = id;
		_name = name;
		_personnelNumber = personnelNumber;
		_addressId = adressId;
	}

	public Client(Client other) {
		_id = other._id;
		_name = other._name;
		_personnelNumber = other._personnelNumber;
		_addressId = other._addressId;
	}

	public String toString() {
		return String.format("{ %d, %s, %s, %d }", _id, _name, _personnelNumber, _addressId);
	}
}