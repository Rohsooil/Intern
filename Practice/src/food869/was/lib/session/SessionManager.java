package food869.was.lib.session;

import java.io.Serializable;
import java.util.HashMap;

public class SessionManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Session> sessionMap;

	public SessionManager() {
		this.sessionMap = new HashMap<>();
	}

	public boolean contains(String path) {
		if (sessionMap.keySet().contains(path)) {
			return true;
		}
		return false;
	}

	public void add(String path, Session session) {
		sessionMap.put(path, session);
	}

	public void remove(String path) {
		sessionMap.remove(path);
	}
}
