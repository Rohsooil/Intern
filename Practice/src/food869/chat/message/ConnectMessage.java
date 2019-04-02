package food869.chat.message;

import java.io.Serializable;

import food869.chat.user.User;

/*
 * 메인서버와 클라이언트, 메인서버와 채팅서버 간에 통신에 사용할 메세지
 * 다양한 형태로 만들어서 구현.
 */

public class ConnectMessage implements Serializable {
	private static final long serialVersionUID = 2L;
	private int code;
	private int port;
	private User user;

	public ConnectMessage(int code) {
		this.code = code;
	}

	public ConnectMessage(int code, User user) {
		this.code = code;
		this.user = user;
	}

	public ConnectMessage(int code, int port) {
		this.code = code;
		this.port = port;
	}

	public int getCode() {
		return this.code;
	}

	public User getUser() {
		return user;
	}

	public int getPort() {
		return this.port;
	}

}
