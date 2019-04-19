package food869.was.lib.servlet;

import food869.was.lib.request.Request;
import food869.was.lib.response.Response;

public abstract class Servlet {
	private int serviceNum;
	private ServletConfig servletConfig;

	public void init() {
		System.out.println("init");
	}

	public void init(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
		init();
	}

	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	protected void doGet(Request request, Response response) {
	}

	protected void doPost(Request request, Response response) {
	}

	public void service(Request request, Response response) {
		System.out.println("service " + serviceNum++);
		new ServletThread(this, request, response).start();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			return true;
		}
		return false;
	}

}
