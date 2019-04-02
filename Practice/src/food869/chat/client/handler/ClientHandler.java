package food869.chat.client.handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import food869.chat.client.frame.ChatPanel;
import food869.chat.client.frame.ClientFrame;
import food869.chat.client.frame.EnterPanel;
import food869.chat.client.frame.LoginPanel;
import food869.chat.enums.ChatCodeE;
import food869.chat.enums.ErrorCodeE;
import food869.chat.enums.SocketE;
import food869.chat.enums.SuccessCodeE;
import food869.chat.message.ChattingMessage;
import food869.chat.message.ConnectMessage;
import food869.chat.user.User;

public class ClientHandler extends Thread {
	private Socket socket;
	private ClientFrame clientFrame;
	private User user;

	public ClientHandler(ClientFrame clientFrame) {
		this.clientFrame = clientFrame;
		setConnection();
	}

	@Override
	public void run() {
		while (socket.isConnected()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ChattingMessage message = (ChattingMessage) ois.readObject();

				ChatPanel chatPanel = (ChatPanel) clientFrame.getCurrentPanel();
				if (message.getCode() == ChatCodeE.NEW_USER_COME.getCode()) {
					chatPanel.changeUserList(message.getContent());
				} else if (message.getCode() == ChatCodeE.USER_OUT.getCode()) {
					chatPanel.changeUserList(message.getContent());
				} else {
					chatPanel.appendChat(message.toString());
				}
			} catch (IOException | ClassNotFoundException e) {
				break;
			}
		}
		looseConnection();

	}

	private void setConnection() {
		try {
			socket = new Socket(SocketE.HOST.getHost(), SocketE.MAIN_PORT.getPort());
			clientFrame.changePanel(new LoginPanel(this));
		} catch (IOException e) {
			looseConnection();
		}

	}

	public void getMainServerMessage() {
		try {
			if (socket.isConnected()) {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ConnectMessage readData = (ConnectMessage) ois.readObject();

				if (readData.getCode() == SuccessCodeE.LOGIN_SUCCESS.getCode()) {
					this.user = readData.getUser();
					clientFrame.changePanel(new EnterPanel(this));
				} else if (readData.getCode() == SuccessCodeE.ENTER_OK.getCode()
						|| readData.getCode() == SuccessCodeE.MAKE_OK.getCode()) {

					socket = new Socket(SocketE.HOST.getHost(), readData.getPort());
					sendToServer(new ConnectMessage(SuccessCodeE.NEW_USER.getCode(), user));
					clientFrame.changePanel(new ChatPanel(this));

				} else if (readData.getCode() == ErrorCodeE.LOGIN_FAIL.getCode()) {
					JOptionPane.showMessageDialog(clientFrame, ErrorCodeE.LOGIN_FAIL.getMessage());
				} else if (readData.getCode() == ErrorCodeE.ENTER_FAIL.getCode()) {
					JOptionPane.showMessageDialog(clientFrame, ErrorCodeE.ENTER_FAIL.getMessage());
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			looseConnection();
		}
	}

	public void sendToServer(ConnectMessage message) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(message);
			oos.flush();
		} catch (IOException e) {
			looseConnection();
		}
	}

	public Socket getSocket() {
		return this.socket;
	}

	public User getUser() {
		return user;
	}

	private void looseConnection() {
		JOptionPane.showMessageDialog(clientFrame, ErrorCodeE.CONNECT_FAIL.getMessage());
		clientFrame.exit();
	}

}
