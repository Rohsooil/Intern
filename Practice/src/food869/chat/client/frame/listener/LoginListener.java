package food869.chat.client.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import food869.chat.client.handler.ClientHandler;
import food869.chat.enums.ErrorCodeE;
import food869.chat.enums.RequestCodeE;
import food869.chat.message.ConnectMessage;
import food869.chat.user.User;

public class LoginListener implements ActionListener {

	private JTextField nameText;
	private ClientHandler clientHandler;

	public LoginListener(JTextField nameText, ClientHandler clientHandler) {
		this.nameText = nameText;
		this.clientHandler = clientHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (nameText.getText() != null && !nameText.getText().equals("")) {

			clientHandler.sendToServer(
					new ConnectMessage(RequestCodeE.REQUEST_LOGIN.getCode(), new User(nameText.getText())));
			clientHandler.getMainServerMessage();

		} else {
			JOptionPane.showMessageDialog(null, ErrorCodeE.EMPTY_INPUT.getMessage());

		}
	}

}
