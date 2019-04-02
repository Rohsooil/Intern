package food869.chat.client.frame;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import food869.chat.client.frame.enums.ColorE;
import food869.chat.client.frame.enums.FrameStringE;
import food869.chat.client.frame.listener.EnterChatListener;
import food869.chat.client.frame.listener.MakeNewChatListener;
import food869.chat.client.handler.ClientHandler;

/*
 * 채팅을 만들것인가, 기존 방에 입장할것인가
 */

public class EnterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6042848479270905972L;
	private JButton newChatBtn, enterChatBtn;

	public EnterPanel(ClientHandler clientHandler) {

		setBackground(Color.decode(ColorE.GRAY.getValue()));
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));

		makeNewChatBtn(clientHandler);

		makeEnterChatBtn(clientHandler);

	}

	private void makeNewChatBtn(ClientHandler clientHandler) {
		newChatBtn = new JButton(FrameStringE.MAKE_CHAT.getValue());
		newChatBtn.setBackground(Color.BLACK);
		newChatBtn.setForeground(Color.decode(ColorE.YELLOW.getValue()));

		newChatBtn.addActionListener(new MakeNewChatListener(clientHandler));

		add(newChatBtn);
	}

	private void makeEnterChatBtn(ClientHandler clientHandler) {
		enterChatBtn = new JButton(FrameStringE.ENTER_CHAT.getValue());
		enterChatBtn.setBackground(Color.BLACK);
		enterChatBtn.setForeground(Color.decode(ColorE.YELLOW.getValue()));

		enterChatBtn.addActionListener(new EnterChatListener(clientHandler));

		add(enterChatBtn);
	}

}
