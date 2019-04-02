package food869.chat.server.mainserver;

import java.util.ArrayList;

import food869.chat.enums.SocketE;

/*
 * 메인 서버에서 채팅 서버 리스트를 포트로 관리하기 위한 클래스.
 */

public class ChatPortManager {
	private ArrayList<Integer> chatPortList;
	private final int initNum = 0;

	ChatPortManager() {
		chatPortList = new ArrayList<>();
	}

	int getNewPort() {
		if (chatPortList.size() == initNum) {
			chatPortList.add(initNum);
		} else {
			chatPortList.add(chatPortList.size());
		}
		return chatPortList.get(chatPortList.size() - 1) + SocketE.SUB_PORT.getPort();
	}

	boolean isMadedPort(int port) {

		if (chatPortList.contains(port - SocketE.SUB_PORT.getPort())) {
			return true;
		} else {
			return false;
		}
	}

	public void removeChatPort(int removePort) {
		if (isMadedPort(removePort)) {
			chatPortList.remove(removePort - SocketE.SUB_PORT.getPort());
		}
	}

}
