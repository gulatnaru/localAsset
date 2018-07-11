package web.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeUi")
public class MakeUi extends HttpServlet {
		// make ui
		public static void build(HttpServletRequest request, String view){
			if(view.equals("login")) {
				request.setAttribute("center", "login");
				request.setAttribute("nav", "login");
			}else if(view.equals("register")) {
				request.setAttribute("center", "register");
				request.setAttribute("nav", Navi.register);
			}else if(view.equals("aboutUs")) {
				request.setAttribute("center", "about");
				request.setAttribute("nav", Navi.aboutUs);
			}else if(view.equals("userAdd")) {
				request.setAttribute("center", "/user/add");
				request.setAttribute("nav", Navi.userAdd);
			}else if(view.equals("productAdd")) {
				request.setAttribute("center", "/product/add");
				request.setAttribute("nav", Navi.productAdd);
			}else if(view.equals("regSuccess")) {
				request.setAttribute("center", "regSuccess");
				request.setAttribute("nav", Navi.register);
			}else if(view.equals("regFail")) {
				request.setAttribute("center", "regFail");
				request.setAttribute("nav", Navi.register);
			}else if(view.equals("userList")) {
				request.setAttribute("center", "/user/list");
				request.setAttribute("nav", Navi.userList);
			}else if(view.equals("productList")) {
				request.setAttribute("center", "/product/list");
				request.setAttribute("nav", Navi.productList);
			}else if(view.equals("weather")) {
				request.setAttribute("center", "weather");
				request.setAttribute("nav", Navi.weather);
			}else if(view.equals("chart")) {
				request.setAttribute("center", "table");
				request.setAttribute("nav", Navi.chart);
			}
	}
}
