package food869.chat.client.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import food869.chat.client.handler.ClientHandler;
import food869.chat.message.ChattingMessage;

public class SendMessageListener extends KeyAdapter implements ActionListener {

	private ClientHandler clientHandler;
	private JTextField inputText;

	public SendMessageListener(ClientHandler clientHandler, JTextField inputText) {
		this.clientHandler = clientHandler;
		this.inputText = inputText;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == '\n') {
			sendMessage();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}

	private void sendMessage() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientHandler.getSocket().getOutputStream());
			objectOutputStream
					.writeObject(new ChattingMessage(clientHandler.getUser().getUserName(), inputText.getText()));
			objectOutputStream.flush();
			inputText.setText("");
			inputText.requestFocus();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
