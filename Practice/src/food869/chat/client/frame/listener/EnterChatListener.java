package food869.chat.client.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import food869.chat.client.handler.ClientHandler;
import food869.chat.enums.ErrorCodeE;
import food869.chat.enums.RequestCodeE;
import food869.chat.message.ConnectMessage;

public class EnterChatListener implements ActionListener {

	private ClientHandler clientHandler;

	public EnterChatListener(ClientHandler clientHandler) {
		this.clientHandler = clientHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String chatCode = JOptionPane.showInputDialog("채팅코드 입력 : 포트는 20000~");
		if (chatCode == null || chatCode.equals("")) {
			JOptionPane.showMessageDialog(null, ErrorCodeE.EMPTY_INPUT.getMessage());
		} else if (chatCode.matches("\\d*")) {
			int port = Integer.parseInt(chatCode);
			if (port < 20000) {
				JOptionPane.showMessageDialog(null, ErrorCodeE.INDEX_ERR.getMessage());
			} else {
				clientHandler.sendToServer(new ConnectMessage(RequestCodeE.REQUEST_ENTER_CHAT.getCode(), port));
				clientHandler.getMainServerMessage();
			}
		} else {
			JOptionPane.showMessageDialog(null, ErrorCodeE.MESSAGE_TYPE_ERR.name());
		}
	}

}
