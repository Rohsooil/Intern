package food869.chat.client.frame;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import food869.chat.client.frame.enums.ColorE;
import food869.chat.client.frame.enums.FrameStringE;
import food869.chat.client.frame.listener.SendMessageListener;
import food869.chat.client.handler.ClientHandler;

/*
 * 채팅 패널
 */

public class ChatPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -420847068237796961L;
	private JTextArea chatContents, userListText;
	private JTextField inputText, userNameText;
	private JScrollPane qScroller;
	private JButton sendButton, getCodeBtn;

	public ChatPanel(ClientHandler clientHandler) throws IOException {
		setBackground(Color.decode(ColorE.GRAY.getValue()));

		makeUserNameText(clientHandler);

		makeChatContentsText();

		makeUserListText();

		makeInputText(clientHandler);

		makeSendBtn(clientHandler);

		makeGetCodeBtn(clientHandler);

		requestFocus();

		clientHandler.start();
	}

	private void makeUserNameText(ClientHandler clientHandler) {
		userNameText = new JTextField(37);
		userNameText.setBackground(Color.black);
		userNameText.setForeground(Color.decode(ColorE.YELLOW.getValue()));
		userNameText.setHorizontalAlignment(JTextField.CENTER);
		userNameText.setEditable(false);
		userNameText.setText(clientHandler.getUser().getUserName());

		add(userNameText);
	}

	private void makeChatContentsText() {
		chatContents = new JTextArea(14, 37);
		chatContents.setBackground(Color.decode(ColorE.DARK_GRAY.getValue()));
		chatContents.setForeground(Color.decode(ColorE.SKY_WHITE.getValue()));
		chatContents.setLineWrap(true);
		chatContents.setWrapStyleWord(true);
		chatContents.setEditable(false);

		qScroller = new JScrollPane(chatContents);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		add(qScroller);
	}

	private void makeUserListText() {
		userListText = new JTextArea(14, 13);
		userListText.setBackground(Color.decode(ColorE.DARK_GRAY.getValue()));
		userListText.setForeground(Color.decode(ColorE.ORANGE.getValue()));
		userListText.setLineWrap(true);
		userListText.setWrapStyleWord(true);
		userListText.setEditable(false);

		add(userListText);

	}

	private void makeInputText(ClientHandler clientHandler) {
		inputText = new JTextField(20);
		inputText.addKeyListener(new SendMessageListener(clientHandler, inputText));
		inputText.setMargin(new Insets(0, 5, 0, 0));
		inputText.setBackground(Color.black);
		inputText.setForeground(Color.decode(ColorE.YELLOW.getValue()));

		add(inputText);
	}

	private void makeSendBtn(ClientHandler clientHandler) {
		sendButton = new JButton(FrameStringE.SEND.getValue());
		sendButton.addActionListener(new SendMessageListener(clientHandler, inputText));

		add(sendButton);
	}

	private void makeGetCodeBtn(ClientHandler clientHandler) {
		getCodeBtn = new JButton(FrameStringE.GET_INVITE_CODE.getValue());
		getCodeBtn.setBackground(Color.BLACK);
		getCodeBtn.setForeground(Color.decode(ColorE.GREEN.getValue()));
		getCodeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						FrameStringE.INVITE_CODE.getValue() + " : " + clientHandler.getSocket().getPort());
			}
		});

		add(getCodeBtn);
	}

	public void appendChat(String message) {
		chatContents.append(message);
		inputText.requestFocus();
	}

	public void changeUserList(String userList) {
		userListText.setText("");
		userListText.append(userList);
		// chatContents.append(message);
		inputText.requestFocus();
	}

}
