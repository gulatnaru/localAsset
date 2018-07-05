package web.component;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class user
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBiz<User, String> biz;
	
	public UserServlet() {
		super();
		biz = new UserBiz<>();
	}
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		ArrayList<User> list = null;
		if(cmd.equals("add")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			System.out.println("id"+id+"pwd"+pwd+"name"+name);
			User u = new User(
					id,
					pwd,
					name);
			try {
				biz.register(u);
				request.setAttribute("center", "user/ok");
			} catch (Exception e) {
				request.setAttribute("center", "user/fail");
				e.printStackTrace();
			}
		}else if(cmd.equals("list")) {
			try {
				list = biz.get();
				request.setAttribute("navi", "userList");
				request.setAttribute("userlist", list);
				request.setAttribute("center", "user/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("detail")) {
			String id = request.getParameter("id");
			User user = null;
			try {
				user = biz.get(id);
				request.setAttribute("navi", "detail");
				request.setAttribute("userdetail", user);
				request.setAttribute("center", "user/detail");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("delete")) {
			String id = request.getParameter("id");
			try {
				biz.remove(id);
				response.sendRedirect("user.cacao?cmd=list");
				return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			User user = null;
			try {
				user = biz.get(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				biz.modify(user);
				request.setAttribute("navi", "update");
				request.setAttribute("userupdate", user);
				request.setAttribute("center", "user/update");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			name = Util.convertKr(name);
			User user = null;
			try {
				user = new User(id,pwd,name);
				request.setAttribute("navi", "detail");
				request.setAttribute("userdetail", user);
				request.setAttribute("center", "user/detail");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
		
	}
	

}
