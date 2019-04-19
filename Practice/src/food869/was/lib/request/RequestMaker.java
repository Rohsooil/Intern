package food869.was.lib.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import food869.was.lib.enums.RequestE;

public class RequestMaker {
	private BufferedReader in;

	public RequestMaker(BufferedReader in) {
		this.in = in;
	}

	public Request makeRequest() throws IOException {
		HashMap<String, String> requestDatas = new HashMap<>();

		String requestLine = in.readLine();
		String requestHeader = "";

		String line;
		while ((line = in.readLine()) != null) {
			requestHeader = requestHeader + line + "\n";
			if (line.equals("")) {
				break;
			}
		}
		if (requestHeader != null) {
			putRequestHeader(requestDatas, requestHeader);
		}
		if (requestLine != null) {
			putRequestLine(requestDatas, requestLine);
		}
		if (in.ready()) {
			putRequestBody(requestDatas);
		}
		return new Request(requestDatas);

	}

	private void putRequestLine(HashMap<String, String> requestDatas, String requestLine) {
		String[] requestLineData = requestLine.split(" ");
		requestDatas.put(RequestE.METHOD.getValue(), requestLineData[0]);
		requestDatas.put(RequestE.URL.getValue(), requestLineData[1]);
		requestDatas.put(RequestE.PROTOCOL.getValue(), requestLineData[2]);
	}

	private void putRequestHeader(HashMap<String, String> requestDatas, String requestHeader) {
		String[] requestHeaderData = requestHeader.split("\n");
		for (int i = 0; i < requestHeaderData.length; i++) {
			int index = requestHeaderData[i].indexOf(": ");
			if (index > -1) {
				String name = requestHeaderData[i].substring(0, index);
				String value = requestHeaderData[i].substring(index + 2, requestHeaderData[i].length());
				requestDatas.put(name, value);
			}
		}
	}

	private void putRequestBody(HashMap<String, String> requestDatas) throws IOException {
		String requestBody = "";
		StringBuilder sb = new StringBuilder();
		int content_length = Integer.parseInt(requestDatas.get(RequestE.CONTENT_LENGTH.getValue()));
		for (int i = 0; i < content_length; i++) {
			byte thisByte = (byte) in.read();
			sb.append((char) thisByte);
		}
		requestBody = sb.toString();
		requestDatas.put(RequestE.BODY.getValue(), requestBody);
	}
}
