package web.dispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductBiz;
import com.vo.Product;


/**
 * product 리스트 가져오는 servlet
 */
@WebServlet("/productList")
public class productList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBiz<Product, String> user = new ProductBiz<>();
		ArrayList<Product> list;
		
		try {
			list = user.get();
			request.setAttribute("productList", list);
			System.out.println("productList: "+list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("main.cacao?page=productList");
		rd.forward(request, response);
	}

}
