import parser.XMLParser;
import java.io.File;

public class IDEMain {
	public static void main(String[] args) {
		XMLParser xmlParser = new XMLParser();
		xmlParser.parseAddress(new File(new File("").getAbsolutePath() + "//address.xml"));
		xmlParser.parseClient(new File(new File("").getAbsolutePath() + "//client.xml"));
	}
}