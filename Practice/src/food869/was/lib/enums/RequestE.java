package food869.was.lib.enums;

public enum RequestE {

	METHOD("Method"),
	URL("URL"),
	PROTOCOL("Protocol"),
	CONTENT_LENGTH("Content-Length"),
	BODY("body"),
	COOKIE("Cookie");

	private String value;

	private RequestE(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
