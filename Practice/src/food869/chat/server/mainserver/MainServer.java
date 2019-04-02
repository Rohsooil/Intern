package food869.chat.server.mainserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import food869.chat.enums.SocketE;
import food869.chat.server.chatserver.ChattingServer;
import food869.chat.user.UserManager;

/*
 * 로그인, 로그아웃, 채팅서버 생성, 채팅서버 삭제 등의 작업이 이루어지는
 * 메인 서버 클래스.
 */

public class MainServer {

	private UserManager userManager;
	private ChatPortManager chatPortManager;

	public MainServer() {
		userManager = new UserManager();
		chatPortManager = new ChatPortManager();
	}

	public static void main(String[] args) {
		new MainServer().start();
	}

	private void start() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSock = new ServerSocket(SocketE.MAIN_PORT.getPort());
			while (true) {
				Socket clientSocket = serverSock.accept();
				Thread t = new Thread(new MainServerHandler(this, clientSocket));
				t.start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	UserManager getUserManager() {
		return userManager;
	}

	public ChatPortManager getChatPortManager() {
		return chatPortManager;
	}

	void makeChatServer(int port) {
		new ChattingServer(this, port);
	}
}
