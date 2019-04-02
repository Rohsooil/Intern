package food869.chat.client.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import food869.chat.client.handler.ClientHandler;
import food869.chat.enums.RequestCodeE;
import food869.chat.message.ConnectMessage;

public class MakeNewChatListener implements ActionListener {

	private ClientHandler clientHandler;

	public MakeNewChatListener(ClientHandler clientHandler) {
		this.clientHandler = clientHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clientHandler.sendToServer(new ConnectMessage(RequestCodeE.REQUEST_MAKE_CHAT.getCode()));
		clientHandler.getMainServerMessage();
	}

}