package models;

import java.lang.String;

public class Client {
	// todo: исправить модификаторы доступа
	public int _id;
	public String _name;
	public String _personnelNumber;
	public int _addressId;

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
}