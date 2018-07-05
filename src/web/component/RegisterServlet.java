package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.Util;

/**
 * 회원 가입 처리 하는 프로그램
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private UserBiz<User, String> biz;
	
    public RegisterServlet() {
        super();
        biz = new UserBiz<>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		name = Util.convertKr(name);
		try {
			biz.register(new User(id, pwd, name));
			//ok
			//request, response 인자 같이 이동
			request.setAttribute("rid", id);
			RequestDispatcher rd = request.getRequestDispatcher("main.cacao?page=regSuccess");
			rd.forward(request, response);
		} catch (Exception e) {
			//fail
			response.sendRedirect("main.cacao?page=regFail");	//단순하게 페이지 이동
			e.printStackTrace();
		}
	}

}
