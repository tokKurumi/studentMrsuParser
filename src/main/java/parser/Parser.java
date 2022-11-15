package parser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;

import models.Address;
import models.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Parser {
	List<Address> parseAddress(File file) throws ParserConfigurationException, SAXException, IOException;

	List<Client> parseClient(File file) throws ParserConfigurationException, SAXException, IOException;
}
