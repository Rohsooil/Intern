package food869.chat.enums;

/*
 * 메인서버, 채팅서버, 클라이언트 간에 통신 시에
 * 발생하는 오류를 미리 정의해놓은 enum
 * 2000번 부터 시작, 에러 메시지
 */
public enum ErrorCodeE {

	CONNECT_FAIL(2000, "서버와 연결되지 않음."), LOGIN_FAIL(2001, "중복된 이름입니다."), MESSAGE_TYPE_ERR("Message Type Error"),
	ENTER_FAIL(2002, "존재하지 않는 채팅 서버 입니다."), NOT_NUMBER_FORMAT("Not Number Format"), INDEX_ERR("Overflow Index"),
	EMPTY_INPUT("InputText Empty");

	private int code;
	private String message;

	private ErrorCodeE(int code) {
		this.code = code;
	}

	private ErrorCodeE(String message) {
		this.message = message;
	}

	private ErrorCodeE(int code, String message) {
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
