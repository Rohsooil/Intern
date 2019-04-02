package food869.chat.client.frame.enums;

public enum ColorE {

	GRAY("0x2c3135"), DARK_GRAY("0x1c1f22"), YELLOW("0xffc800"), GREEN("0xa5aa41"), BLUE("0x5a78ff"),
	SKY_WHITE("0xbed6ff"), ORANGE("0xcc782d");

	private String value;

	private ColorE(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
