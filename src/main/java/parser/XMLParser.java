package parser;

import models.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class XMLParser implements Parser {

	@Override
	public void parseAddress(File file) {
		var addressList = readAddresses(file);
		for (Address address : addressList) {
			System.out.println(address.toString());
		}
	}

	@Override
	public void parseClient(File file) {
		var clientList = readClients(file);
		for (Client client : clientList) {
			System.out.println(client.toString());
		}
	}

	private XMLStreamReader read(File file) {
		XMLStreamReader parser = null;
		try {
			parser = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.out.println("Check file path");
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}
		return parser;
	}

	private List<Address> readAddresses(File file) {
		var parser = read(file);
		List<Address> addressList = new ArrayList<Address>();
		try {
			while (true) {
				assert parser != null;
				if (!parser.hasNext()) {
					break;
				}
				int event = parser.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					if (parser.getLocalName().equalsIgnoreCase("address")) {
						var id = Integer.parseInt(parser.getAttributeValue(0));
						var city = parser.getAttributeValue(1);
						var street = parser.getAttributeValue(2);
						var house = Integer.parseInt(parser.getAttributeValue(3));
						var floor = Integer.parseInt(parser.getAttributeValue(4));
						var flatNumber = Integer.parseInt(parser.getAttributeValue(5));
						addressList.add(new Address(id, city, street, house, floor, flatNumber));
					}
				}
			}
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}
		return addressList;
	}

	private List<Client> readClients(File file) {
		var parser = read(file);
		List<Client> clientList = new ArrayList<Client>();
		try {
			while (true) {
				assert parser != null;
				if (!parser.hasNext()) {
					break;
				}
				int event = parser.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					if (parser.getLocalName().equalsIgnoreCase("client")) {
						var id = Integer.parseInt(parser.getAttributeValue(0));
						var name = parser.getAttributeValue(1);
						var personnelNumber = parser.getAttributeValue(2);
						var addressId = Integer.parseInt(parser.getAttributeValue(3));
						clientList.add(new Client(id, name, personnelNumber, addressId));
					}
				}
			}
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}
		return clientList;
	}
}