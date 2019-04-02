package food869.chat.message;

import java.io.Serializable;

public class ChattingMessage implements Serializable {
	private static final long serialVersionUID = 3L;

	private int code;
	private String userName;
	private String content;

	public ChattingMessage(int code, String content) {
		this.code = code;
		this.content = content;
	}

	public ChattingMessage(String userName, String content) {
		this.userName = userName;
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public int getCode() {
		return code;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return this.userName + " : " + this.content + "\n";
	}

}
