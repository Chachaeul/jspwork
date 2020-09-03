package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service ȣ���..");
	}

	@Override
	public void destroy() {
		System.out.println("destroy ȣ���..");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init ȣ���..");
	}

}
