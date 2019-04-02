package food869.chat.client.frame.enums;

public enum FrameStringE {
	LOGIN("Login"), TITLE("My Discord"), MAKE_CHAT("채팅방 만들기"), ENTER_CHAT("채팅방 들어가기"), GET_INVITE_CODE("초대 코드 받기"),
	INVITE_CODE("초대 코드"), SEND("Send");

	private String value;

	private FrameStringE(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
