package food869.chat.server.mainserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import food869.chat.enums.ErrorCodeE;
import food869.chat.enums.RequestCodeE;
import food869.chat.enums.SuccessCodeE;
import food869.chat.message.ConnectMessage;
import food869.chat.user.User;

/*
 * 메인 서버가 각 클라이언트에서 들어온 요청이나, 채팅서버에서 들어온 로그아웃 정보 등을
 * 받아서, 요청을 처리하는 runnable 클래스.
 */
public class MainServerHandler implements Runnable {

	private Socket socket;
	private MainServer mainServer;
	private User user;
	private ObjectInputStream inputStream;

	public MainServerHandler(MainServer mainServer, Socket clientSocket) {
		socket = clientSocket;
		this.mainServer = mainServer;
	}

	@Override
	public void run() {

		while (socket.isConnected()) {
			try {
				inputStream = new ObjectInputStream(socket.getInputStream());
				ConnectMessage readData = (ConnectMessage) inputStream.readObject();

				if (readData.getCode() == RequestCodeE.REQUEST_LOGIN.getCode()) {
					respondLogin(readData.getUser());
				} else if (readData.getCode() == RequestCodeE.REQUEST_MAKE_CHAT.getCode()) {
					int newPort = mainServer.getChatPortManager().getNewPort();
					int code = SuccessCodeE.MAKE_OK.getCode();
					System.out.println("New Port : " + newPort);
					respondChatRoom(code, newPort);
					mainServer.makeChatServer(newPort);
				} else if (readData.getCode() == RequestCodeE.REQUEST_ENTER_CHAT.getCode()) {
					if (mainServer.getChatPortManager().isMadedPort(readData.getPort())) {
						respondChatRoom(SuccessCodeE.ENTER_OK.getCode(), readData.getPort());
					} else {
						respondChatRoom(ErrorCodeE.ENTER_FAIL.getCode(), readData.getPort());
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				break;
			}

		}
		if (user != null) {
			System.out.println(user + " 로그아웃");
			mainServer.getUserManager().removeUser(user);
		}

	}

	private void respondLogin(User user) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		if (mainServer.getUserManager().contains(user)) {
			oos.writeObject(new ConnectMessage(ErrorCodeE.LOGIN_FAIL.getCode()));
			System.out.println(ErrorCodeE.LOGIN_FAIL.getMessage());

		} else {
			this.user = user;
			mainServer.getUserManager().addUser(user);
			oos.writeObject(new ConnectMessage(SuccessCodeE.LOGIN_SUCCESS.getCode(), user));
			System.out.println(user.getUserName() + " 로그인");

		}
		oos.flush();
	}

	private void respondChatRoom(int code, int port) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(new ConnectMessage(code, port));
		oos.flush();
		Thread.currentThread().interrupt();
	}

}
