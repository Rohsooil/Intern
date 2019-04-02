package food869.q20;

public class Info {
	private String key;
	private String value;
	static int index = 0;

	public Info(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
