package food869.was.lib.servlet;

import java.util.Enumeration;
import java.util.HashMap;

public class ServletConfig {
	private HashMap<String, String> initParams;

	ServletConfig() {
		this.initParams = new HashMap<>();
	}

	void setInitParameter(String name, String value) {
		initParams.put(name, value);
	}

	public String getInitParameter(String name) {
		return null;
	}

	public Enumeration<String> getInitParameterNames() {
		return null;
	}

}
