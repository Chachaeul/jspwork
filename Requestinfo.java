package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Requestinfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");

		out.println("method : " + req.getMethod() + "<br>");
		out.println("request uri : " + req.getRequestURI() + "<br>");
		out.println("protocol : " + req.getProtocol() + "<br>");
		out.println("remote address : " + req.getRemoteAddr() + "<br>");
		out.println("context path : " + req.getContextPath() + "<br>");
		out.println("servlet context : " + req.getServletContext() + "<br>");
		out.println("servlet path : " + req.getServletPath() + "<br>");
		
		Enumeration en = req.getHeaderNames();
		while(en.hasMoreElements()) {
		out.println(en.nextElement() + "<br>");
		}

		out.println("<hr/>");
		out.println("<br><br>");

		out.println(req.getHeader("accept-language") + "<br>");
		out.println(req.getHeader("user-agent") + "<br>");
		out.println(req.getHeader("host") + "<br>");
		out.println(req.getHeader("accept-encoding") + "<br>");
		out.println(req.getHeader("cache-control") + "<br>");
		out.println(req.getHeader("ua-cpu") + "<br>");
		out.println(req.getHeader("connection") + "<br>");

		out.println("</body></html>");
		out.close();
	}

}
