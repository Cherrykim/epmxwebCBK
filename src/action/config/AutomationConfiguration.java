package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class AutomationConfiguration {

	/**
	 * Use to change node value in automation-config.xml file EX:
	 * ChangeAutomationConfigValue grid no
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Document document = null;
		String filePath = args[0] + "\\src\\main\\configuration\\automation.config.xml";
		System.out.println(filePath);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			InputStream inStream = new FileInputStream(new File(filePath));
			document = builder.parse(inStream);
		} catch (Exception e) {
			System.out.println("Can't configure the XML parser." + e);
		}

		// changeurl
		Node element = document.getElementsByTagName(args[1]).item(0);
		element.setTextContent(args[2]);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(filePath));
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}
