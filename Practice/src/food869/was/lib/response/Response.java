package food869.was.lib.response;

import java.io.PrintWriter;

public class Response {
	public static final int RESPONSE_OK = 200;
	public static final int SERVER_ERR = 503;
	public static final int NOT_FOUND = 404;

	private PrintWriter writer;

	public Response(PrintWriter out) {
		writer = out;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setStatus(int code) {
		writer.write(RESPONSE_OK + "\r\n");
	}
}
