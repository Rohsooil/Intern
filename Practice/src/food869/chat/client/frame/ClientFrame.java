package food869.chat.client.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import food869.chat.client.frame.enums.FrameStringE;
import food869.chat.client.handler.ClientHandler;
import food869.chat.user.User;

public class ClientFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3807726013937650229L;
	private User user;
	private JPanel panel;

	public ClientFrame() {
		setFrame();
		new ClientHandler(this);
	}

	public void setFrame() {
		setTitle(FrameStringE.TITLE.getValue());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 320);
	}

	public void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		this.panel = panel;
		revalidate();
		repaint();
	}

	public JPanel getCurrentPanel() {
		return this.panel;
	}

	public void exit() {
		System.exit(0);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}
}
