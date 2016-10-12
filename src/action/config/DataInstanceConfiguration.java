package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The instance element brings together all of the testbed components to fully
 * define everything That a test needs to execute.
 * 
 */
public class DataInstanceConfiguration extends DataConfiguration {
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public String getGrid() {
		return grid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getAccessKey() {
		return accessKey;
	}

	@Override
	public Element toElement(Document document) {
		Element instance = document.createElement("customer");
		instance.setAttribute("tag", getTag());

		Element host = document.createElement("url");
		host.setTextContent(getUrl());
		instance.appendChild(host);

		Element grid = document.createElement("grid");
		grid.setTextContent(getGrid());
		instance.appendChild(grid);

		return instance;
	}

	@Override
	public void fromElement(XmlHelper xml, Element base) {
		setTag(base.getAttribute("tag"));
		setUrl(xml.getText(base, "url"));
		setGrid(xml.getText(base, "grid"));
		setAccessKey(xml.getText(base, "accessKey"));
		setUsername(xml.getText(base, "username"));
	}

	private String url;
	private String grid;
	private String accessKey;
	private String username;
}
