package food869.chat.user;

import java.util.ArrayList;

/*
 * 메인 서버에서 사용자 목록을 관리하고, 이미 로그인 되어있는 사용자인지 확인할 수 있도록 
 * 사용자 클래스를 관리하는 매니저 클래스. 
 */

public class UserManager {

	private ArrayList<User> users;

	public UserManager() {
		users = new ArrayList<>();
	}

	public void addUser(User user) {
		if (!contains(user)) {
			users.add(user);
		}
	}

	public void removeUser(User user) {
		User removedUser = null;
		for (User u : users) {
			if (u.getUserName().equals(user.getUserName())) {
				removedUser = u;
				break;
			}
		}
		if (removedUser != null) {
			users.remove(removedUser);
		}
	}

	public User getUser(User user) {
		return users.get(users.indexOf(user));
	}

	public boolean contains(User user) {
		for (User u : users) {
			if (u.getUserName().equals(user.getUserName())) {
				return true;
			}
		}
		return false;
	}
}
