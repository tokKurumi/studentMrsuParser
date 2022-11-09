package models;

import java.lang.String;

public class Address {
	private int _id;
	private String _city;
	private String _street;
	private int _house;
	private int _floor;
	private int _flatNumber;

	public Address(int id, String city, String street, int house, int floor, int flatNumber) {
		_id = id;
		_city = city;
		_street = street;
		_house = house;
		_floor = floor;
		_flatNumber = flatNumber;
	}

	public Address(Address other) {
		_id = other._id;
		_city = other._city;
		_street = other._street;
		_house = other._house;
		_floor = other._floor;
		_flatNumber = other._flatNumber;
	}

	public String toString() {
		return String.format("{ %d, %s, %s, %d, %d, %d }", _id, _city, _street, _house, _floor, _flatNumber);
	}
}
