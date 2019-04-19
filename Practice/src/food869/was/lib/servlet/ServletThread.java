package food869.was.lib.servlet;

import food869.was.lib.enums.MethodE;
import food869.was.lib.request.Request;
import food869.was.lib.response.Response;

public class ServletThread extends Thread {
	private Servlet servlet;
	private Request request;
	private Response response;

	public ServletThread(Servlet servlet, Request request, Response response) {
		this.servlet = servlet;
		this.request = request;
		this.response = response;
	}

	@Override
	public void run() {
		if (request.getMethod().equals(MethodE.GET.name())) {
			servlet.doGet(request, response);
		} else if (request.getMethod().equals(MethodE.POST.name())) {
			servlet.doPost(request, response);
		}
		
		response.getWriter().close();
	}

}
