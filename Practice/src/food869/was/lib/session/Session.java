package food869.was.lib.session;

import java.io.Serializable;

public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sessionID;

	public Session(String seesionID) {
		this.sessionID = seesionID;
	}

	public String getID() {
		return this.sessionID;
	}

}
