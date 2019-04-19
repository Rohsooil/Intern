package food869.was.lib.request;

import java.util.HashMap;

import food869.was.lib.enums.RequestE;
import food869.was.lib.session.Session;

public class Request {
	private HashMap<String, String> requestDatas;

	public Request(HashMap<String, String> requestDatas) {
		this.requestDatas = requestDatas;
	}

	public String getMethod() {
		return requestDatas.get(RequestE.METHOD.getValue());
	}

	public String getURL() {
		return requestDatas.get(RequestE.URL.getValue());
	}

	public Session getSession() {
		if (requestDatas.get(RequestE.COOKIE.getValue()) != null) {
			String id = requestDatas.get(RequestE.COOKIE.getValue()).replace("RSESSIONID=", "");
			return new Session(id);
		}

		return null;
	}

	public String getPath() {
		String url = requestDatas.get(RequestE.URL.getValue());
		char[] arr = url.toCharArray();
		String path = "";
		int i = 0;
		for (char a : arr) {
			if (a == '/') {
				if (i == 1) {
					break;
				} else {
					i++;
				}
			}
			path += a;
		}

		return path;
	}

}
