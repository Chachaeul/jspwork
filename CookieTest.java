package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cook")
public class CookieTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("success");
		
		req.setCharacterEncoding("euc-kr");
		resp.setCharacterEncoding("euc-kr");
		
		String iscook = req.getParameter("iscook");
		
		if(req.getMethod().equals("POST") && iscook.contentEquals("false")) {
			String id = req.getParameter("id");
			String addr = req.getParameter("addr");
			
			System.out.println(id + ", " + addr);
			
			Cookie cookId = new Cookie("id", id);
			Cookie cookAddr = new Cookie("addr", addr);
			
			cookId.setMaxAge(60 * 60 * 24); // 초 단위로 설정
			cookAddr.setMaxAge(60 * 60 * 24);
			
			resp.addCookie(cookId);
			resp.addCookie(cookAddr);
			
			PrintWriter out = resp.getWriter();
			out.println("<html><body>쿠키가 설정되었습니다.</body></html>");
			out.close();
		}
		else {
			Cookie[] cooks = req.getCookies();
			
			PrintWriter out = resp.getWriter();
			out.println("<html><body>");
			
			for(Cookie c : cooks) {
				out.println(c.getName() +  ": " + c.getValue()+ "<br>");
			}
			
			out.println("</body></html>");
			out.close();
			
		}
	}
}

// http://localhost:8080/MyServlet3/cook을 실행했을 때 서버 메시지에 success라고 출력