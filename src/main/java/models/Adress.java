package models;

import java.lang.String;

public class Adress {
	// todo: исправить модификаторы доступа
	public int _id;
	public String _city;
	public String _street;
	public int _house;
	public int _floor;
	public int _flatNumber;

	public Adress(int id, String city, String street, int house, int floor, int flatNumber) {
		_id = id;
		_city = city;
		_street = street;
		_house = house;
		_floor = floor;
		_flatNumber = flatNumber;
	}

	public Adress(Adress other) {
		_id = other._id;
		_city = other._city;
		_street = other._street;
		_house = other._house;
		_floor = other._floor;
		_flatNumber = other._flatNumber;
	}
}
