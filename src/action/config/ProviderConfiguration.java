package config;

import java.util.List;

import org.w3c.dom.Element;

import common.Constant;

public class ProviderConfiguration {
	public static synchronized ProviderConfiguration getProvider() {
		if (provider == null) {
			provider = new ProviderConfiguration();
		}
		return provider;
	}

	public void loadInstance() {
		loadInstance(Constant.PathConfig.AUTOMATION_CONFIG_XML, null);
	}

	public void loadInstance(String instance) {
		loadInstance(Constant.PathConfig.AUTOMATION_CONFIG_XML, instance);
	}

	public void loadInstance(String filename, String instance) {
		try {
			provider.load(filename, instance);
		} catch (Exception e) {
			instance = null;
			System.out.println("Failed to load due to an XML problem." + e);
		}
	}

	public DataInstanceConfiguration getInstance() {
		return instance;
	}

	/**
	 * Load all data from automation.config.xml
	 * 
	 * @param filename
	 * @param instanceTag
	 */
	private void load(String filename, String instanceTag) {
		XmlHelper xml = new XmlHelper();

		System.out.println("Loading configuration from file " + filename);
		xml.parseResource(filename);

		if (instanceTag == null) {
			instanceTag = xml.getStringAttribute(xml.getElement("/automation"), "instance");
			if (instanceTag == null) {
				System.out.println("You must provide an instance name to the load function or define a default in the XML file <automation instance=\"DEFAULT INSTANCE NAME\"");
			}
		}

		System.out.println("Using the test configuration instance " + instanceTag);

		instance = null;
		for (Element element : xml.getElements("/automation/instances/instance")) {
			instance = new DataInstanceConfiguration();
			instance.fromElement(xml, element);
			if (instance.getTag().equals(instanceTag) == false) {
				instance = null;
			} else {
				break;
			}
		}

		if (instance == null) {
			System.out.println("The test configuration instance " + instanceTag + " has not been defined in " + filename);
		}

		System.out.println("Configuration loaded");
	}

	/**
	 * get current running URL
	 * 
	 * @return
	 */
	public String getUrl() {
		XmlHelper xml = new XmlHelper();
		xml.parseResource(Constant.PathConfig.AUTOMATION_CONFIG_XML);
		Element element = xml.getElement("/automation/instances/instance/url");
		return element.getTextContent();
	}

	/**
	 * get current running Username
	 * 
	 * @return
	 */
	public String getUsername() {
		XmlHelper xml = new XmlHelper();
		xml.parseResource(Constant.PathConfig.AUTOMATION_CONFIG_XML);
		Element element = xml.getElement("/automation/instances/instance/username");
		return element.getTextContent();
	}

	/**
	 * get current running Accesskey
	 * 
	 * @return
	 */
	public String getAccessKey() {
		XmlHelper xml = new XmlHelper();
		xml.parseResource(Constant.PathConfig.AUTOMATION_CONFIG_XML);
		Element element = xml.getElement("/automation/instances/instance/accessKey");
		return element.getTextContent();
	}

	/**
	 * get current running Host
	 * 
	 * @return
	 */
	public String getHost() {
		XmlHelper xml = new XmlHelper();
		xml.parseResource(Constant.PathConfig.AUTOMATION_CONFIG_XML);
		Element element = xml.getElement("/automation/instances/instance/host");
		return element.getTextContent();
	}

	/**
	 * get current running Host with Tag
	 * 
	 * @param tag
	 * @return
	 */
	public String getHost(String tag) {
		String host = null;
		XmlHelper xml = new XmlHelper();
		xml.parseResource(Constant.PathConfig.AUTOMATION_CONFIG_XML);
		List<Element> elements = xml.getElements("/automation/grids/grid");
		for (Element element : elements) {
			String tagName = element.getAttribute("tag");
			if (tagName.equals(tag)) {
				host = element.getElementsByTagName("host").item(0).getTextContent();
			}
		}
		return host;
	}

	private ProviderConfiguration() {
	}

	private static ProviderConfiguration provider;

	private DataInstanceConfiguration instance = null;

}
