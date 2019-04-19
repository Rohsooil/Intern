package food869.was.lib.enums;

public enum DeployDescriptorE {
	
	URL_PATTERN("url-pattern"),
	SERVLET("servlet"),
	SERVLET_NAME("servlet-name"),
	SERVLET_CLASS("servlet-class"),
	SERVLET_MAPPING("servlet-mapping"),
	INIT_PARAMS("init-param"),
	PARAM_NAME("param-name"),
	PARAM_VALUE("param-value");
	
	private String value;

	private DeployDescriptorE(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
