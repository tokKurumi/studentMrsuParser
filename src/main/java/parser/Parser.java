package parser;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface Parser {
	void parseAddress(File file) throws FileNotFoundException, XMLStreamException;

	void parseClient(File file) throws FileNotFoundException, XMLStreamException;
}
