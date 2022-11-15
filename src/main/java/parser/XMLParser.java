package parser;

import models.*;
import java.util.List;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser implements Parser {

	@Override
	public List<Address> parseAddress(File file) throws ParserConfigurationException, SAXException, IOException {
		return readAddresses(file);
	}

	@Override
	public List<Client> parseClient(File file) throws ParserConfigurationException, SAXException, IOException {
		return readClients(file);
	}

	private NodeList getNodeList(File file, String superiorNode)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		NodeList list = doc.getElementsByTagName(superiorNode);
		return list;
	}

	private List<Address> readAddresses(File file) throws ParserConfigurationException, SAXException, IOException {
		List<Address> listAdresses = new ArrayList<>();

		NodeList list = getNodeList(file, "address");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				int id = Integer.parseInt(element.getAttribute("id"));
				String city = element.getElementsByTagName("city").item(0).getTextContent();
				String street = element.getElementsByTagName("street").item(0).getTextContent();
				int house = Integer.parseInt(element.getElementsByTagName("house").item(0).getTextContent());
				int floor = Integer.parseInt(element.getElementsByTagName("floor").item(0).getTextContent());
				int flatNumber = Integer.parseInt(element.getElementsByTagName("flatNumber").item(0).getTextContent());

				listAdresses.add(new Address(id, city, street, house, floor, flatNumber));
			}
		}
		return listAdresses;
	}

	private List<Client> readClients(File file) throws ParserConfigurationException, SAXException, IOException {
		List<Client> listClients = new ArrayList<>();

		NodeList list = getNodeList(file, "client");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				int id = Integer.parseInt(element.getAttribute("id"));
				String name = element.getElementsByTagName("name").item(0).getTextContent();
				String personnelNumber = element.getElementsByTagName("personnelNumber").item(0).getTextContent();
				int addressId = Integer.parseInt(element.getElementsByTagName("addressId").item(0).getTextContent());

				listClients.add(new Client(id, name, personnelNumber, addressId));
			}
		}
		return listClients;
	}
}