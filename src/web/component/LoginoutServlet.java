package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserBiz;
import com.vo.User;


@WebServlet({"/LoginoutServlet", "/loginout"})
public class LoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBiz<User, String> biz;   

    public LoginoutServlet() {
        super();
        biz = new UserBiz<>();
    }
    //LOGOUT
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		//main.jsp
		request.setAttribute("center", "center");
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	//LOGIN
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String center = "center";
		//ID, PWD Verify
		User user = null;
		try {
			user = biz.get(id);
			if(user.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				center = "loginOk";
			} else {
				center = "loginError";
			}
		} catch (Exception e) {
			center = "loginError";
			e.printStackTrace();
		}
		
		//main.jsp
		request.setAttribute("center", center);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
