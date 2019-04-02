package food869.chat.enums;
/*
 * 요청에대해 성공했다는 것을 서버에서 알려주기 위한 코드를 미리 정의한 enum
 * 1000번대 부터 시작 
 */

public enum SuccessCodeE {
	LOGIN_SUCCESS(1000), ENTER_OK(1001), MAKE_OK(1002), NEW_USER(1003);

	private int code;

	private SuccessCodeE(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
