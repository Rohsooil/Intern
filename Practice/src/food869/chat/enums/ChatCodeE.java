package food869.chat.enums;
/*
 * 채팅에 필요한 코드를 미리 정의한 enum
 * 4000번 부터 시작
 */

public enum ChatCodeE {
	NEW_USER_COME(4001, "님이 들어오셨습니다.\n"), USER_OUT(4002, "님이 퇴장하셨습니다.\n"), ALL_USER_OUT(4003),
	CHATTING_SERVER("SERVER");

	private int code;
	private String message;

	private ChatCodeE(int code) {
		this.code = code;
	}

	private ChatCodeE(String message) {
		this.message = message;
	}

	private ChatCodeE(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
