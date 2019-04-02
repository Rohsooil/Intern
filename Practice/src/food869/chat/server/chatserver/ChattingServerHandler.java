package food869.chat.server.chatserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import food869.chat.enums.ChatCodeE;
import food869.chat.message.ChattingMessage;
import food869.chat.user.User;

/*
 * 서버에서 클라이언트 간 통신작업을 위해 작업을 하는 runnalbe을 구현한 클래스.
 */

public class ChattingServerHandler implements Runnable {

	private Socket clientSocket;
	private ChattingServer chattingServer;
	private User user;

	public ChattingServerHandler(User user, ChattingServer chattingServer) {
		this.user = user;
		this.clientSocket = user.getSocket();
		this.chattingServer = chattingServer;
	}

	@Override
	public void run() {

		while (clientSocket.isConnected()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				ChattingMessage message = (ChattingMessage) ois.readObject();
				sendToEveryOne(message);
			} catch (IOException | ClassNotFoundException e) {
				break;
			}
		}
		try {
			chattingServer.removeUser(user);
			chattingServer.notifyUserListChange(ChatCodeE.USER_OUT.getCode());
			if (chattingServer.getUserList().isEmpty()) {
				chattingServer.closeServer();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendToEveryOne(ChattingMessage message) throws IOException {
		for (User user : chattingServer.getUserList()) {
			ObjectOutputStream oos = new ObjectOutputStream(user.getSocket().getOutputStream());
			oos.writeObject(new ChattingMessage(message.getUserName(), message.getContent()));
			oos.flush();
		}
	}

}
