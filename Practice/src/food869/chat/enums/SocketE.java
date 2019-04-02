package food869.chat.enums;
/*
 *	소켓을 생성 할때 host, port번호를 미리 지정해 놓은 enum
 *  subport는 20000번 부터 시작 
 */

public enum SocketE {
	HOST("127.0.0.1"), MAIN_PORT(5000), SUB_PORT(20000);

	private int port;
	private String host;

	private SocketE(int port) {
		this.port = port;
	}

	private SocketE(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public String getHost() {
		return host;
	}

}
