package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("success");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		HttpSession sess = req.getSession();
		
		String msg = null;
		if(id.equals("tiger") && pw.contentEquals("1111")) {
			sess.setAttribute("id", id);
			msg = "로그인 되었습니다.";
		}
		
		resp.setCharacterEncoding("euc-kr");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println(msg);
		out.println("</body></html>");
		out.close();
		
		System.out.println(sess.getAttribute("id"));
		
		//sess.invalidate(); //세션메모리를 삭제 하겠다.
		
		System.out.println("접속 시간 : " + new Date(sess.getCreationTime()));
		System.out.println("세션만료시간 시간 : " + sess.getMaxInactiveInterval());
	
		
	}

}
