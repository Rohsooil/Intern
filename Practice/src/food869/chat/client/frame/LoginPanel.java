package food869.chat.client.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import food869.chat.client.frame.enums.ColorE;
import food869.chat.client.frame.enums.FrameStringE;
import food869.chat.client.frame.listener.LoginListener;
import food869.chat.client.handler.ClientHandler;

/*
 * 로그인 패널. 첫 화면
 */

public class LoginPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4089762922877625126L;
	private JTextField nameText;
	private JLabel title;
	private JButton loginBtn;

	public LoginPanel(ClientHandler clientHandler) {
		setBackground(Color.decode(ColorE.GRAY.getValue()));

		makeTitleLabel();

		makeNametext();

		makeLoginBtn(clientHandler);

		requestFocus();
	}

	private void makeTitleLabel() {
		title = new JLabel(FrameStringE.TITLE.getValue());
		title.setForeground(Color.decode(ColorE.BLUE.getValue()));
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 150));

		add(title);
	}

	private void makeNametext() {
		nameText = new JTextField();
		nameText.setEditable(true);
		nameText.setBackground(Color.black);
		nameText.setForeground(Color.decode(ColorE.YELLOW.getValue()));
		nameText.setHorizontalAlignment(SwingConstants.CENTER);
		nameText.setColumns(15);
		nameText.setPreferredSize(new Dimension(600, 26));

		add("Center", nameText);
	}

	private void makeLoginBtn(ClientHandler clientHandler) {
		loginBtn = new JButton(FrameStringE.LOGIN.getValue());
		loginBtn.setBackground(Color.BLACK);
		loginBtn.setForeground(Color.decode(ColorE.YELLOW.getValue()));
		loginBtn.addActionListener(new LoginListener(nameText, clientHandler));

		add("South", loginBtn);
	}
}
