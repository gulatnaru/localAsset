package web.dispatcher;

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

/**
 * 유저리스트 가져오는 servlet
 */
@WebServlet("/userList")
public class userList extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBiz<User, String> biz = new UserBiz<>();
		ArrayList<User> list = null;
		
		try {
			list = biz.get();
			request.setAttribute("userList", list);
			System.out.println("userList.java: "+ list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("main.cacao?page=userList");
		rd.forward(request, response);
	}

}
