package food869.chat.server.chatserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import food869.chat.enums.ChatCodeE;
import food869.chat.enums.SuccessCodeE;
import food869.chat.message.ChattingMessage;
import food869.chat.message.ConnectMessage;
import food869.chat.server.mainserver.MainServer;
import food869.chat.user.User;

/*
 * 클라이언트 간, 채팅 작업이 이루어지는 서버,
 * 사용 종료된 클라이언트 발생 시, 메인서버로 클라이언트 정보를 넘겨줌.
 */

public class ChattingServer {
	private ServerSocket serverSocket;
	private ArrayList<User> userList;

	public ChattingServer(MainServer mainServer, int port) {
		userList = new ArrayList<>();
		try {
			serverSocket = new ServerSocket(port);
			startChatting();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("All Client Out");
			mainServer.getChatPortManager().removeChatPort(port);
		}
	}

	private void startChatting() throws IOException, ClassNotFoundException {
		do {
			Socket clientSocket = serverSocket.accept();
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
			ConnectMessage message = (ConnectMessage) ois.readObject();
			if (message.getCode() == SuccessCodeE.NEW_USER.getCode()) {
				User newUser = message.getUser();
				newUser.setSocket(clientSocket);
				userList.add(newUser);
				notifyUserListChange(ChatCodeE.NEW_USER_COME.getCode());
				Thread t = new Thread(new ChattingServerHandler(newUser, this));
				t.start();
			}
		} while (!userList.isEmpty());
	}

	void closeServer() throws IOException {
		serverSocket.close();
	}

	void notifyUserListChange(int code) throws IOException {
		String allUserName = getAllUser();
		for (User u : userList) {
			ObjectOutputStream oos = new ObjectOutputStream(u.getSocket().getOutputStream());
			oos.writeObject(new ChattingMessage(code, allUserName));
			oos.flush();
		}
	}

	void removeUser(User user) {
		userList.remove(user);
	}

	private String getAllUser() {
		String allUser = "";
		for (User u : userList) {
			allUser = allUser + u.getUserName() + "\n";
		}
		return allUser;
	}

	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}

	public ArrayList<User> getUserList() {
		return this.userList;
	}

}
