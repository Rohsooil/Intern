package food869.chat.enums;

/*
 * 사용자가 메인서버에 어떤 요청을 할 때 필요한 값을 정의해 놓은 enum
 * 3000번 부터 시작.
 */

public enum RequestCodeE {
	REQUEST_LOGIN(3000), REQUEST_MAKE_CHAT(3001), REQUEST_ENTER_CHAT(3002), END_CHAT(3003);

	private int code;

	private RequestCodeE(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
