package food869.chat.user;

import java.io.Serializable;
import java.net.Socket;

/*
 * 사용자의 이름을 가지고 있는 클래스. 사용자의 아이디는 이름.
 */

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private transient Socket socket;

	public User(String userName) {
		this.userName = userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public boolean equals(Object obj) {
		User otherUser = (User) obj;
		if (this.userName == (otherUser.getUserName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return getUserName();
	}

}
