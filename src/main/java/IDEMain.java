import parser.XMLParser;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class IDEMain {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XMLParser xmlParser = new XMLParser();
		xmlParser.parseAddress(new File("address.xml"));
		xmlParser.parseClient(new File("client.xml"));
	}
}