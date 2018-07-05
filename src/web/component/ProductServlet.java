package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;
import com.vo.User;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductBiz<Product,Integer> biz;
	
	public ProductServlet() {
		super();
		biz = new ProductBiz<>();
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		MultipartRequest mRequest = null;
		String dir = "C:\\Users\\Yang's\\eclipse-workspace\\day08\\web\\img";
		int size = 1024 * 1024 * 1024;
		
		if(cmd.equals("add")) {
			mRequest = new MultipartRequest(
					request, dir, size,			//upload 이미지 하면 자동으로 dir위치에 이미지데이터 이동.
					"EUC-KR"
					);
			String name = mRequest.getParameter("name");
			String price = mRequest.getParameter("price");
			String imgname = mRequest.getOriginalFileName("imgname");
			Product p = new Product(
					name,
					Integer.parseInt(price),
					imgname);
			try {
				biz.register(p);
				request.setAttribute("center", "product/ok");
			} catch (Exception e) {
				request.setAttribute("center", "product/fail");
				e.printStackTrace();
			}
		} else if(cmd.equals("list")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
				request.setAttribute("nav", "userList");
				request.setAttribute("productList", list);
				request.setAttribute("center", "product/list");
				System.out.println("here is list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(cmd.equals("detail")) {
			String id = request.getParameter("id");
			Product product = null;
			try {
				product = biz.get(Integer.parseInt(id));
				request.setAttribute("navi", "detail");
				request.setAttribute("pdetail", product);
				request.setAttribute("center", "product/detail");
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(cmd.equals("delete")) {
			String id = request.getParameter("id");
			try {
				biz.remove(Integer.parseInt(id));
				response.sendRedirect("product.cacao?cmd=list");
				return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			Product product = null;
			try {
				product = biz.get(Integer.parseInt(id));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				biz.modify(product);
				request.setAttribute("navi", "update");
				request.setAttribute("pupdate", product);
				request.setAttribute("center", "product/update");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			System.out.println("updateimpl");
			mRequest = new MultipartRequest(
					request, dir, size,			//upload 이미지 하면 자동으로 dir위치에 이미지데이터 이동.
					"EUC-KR"
					);
			String id = mRequest.getParameter("id");
			String name = mRequest.getParameter("name");
			String price = mRequest.getParameter("price");
			String imgname = mRequest.getOriginalFileName("imgname");
			String newimgname = mRequest.getOriginalFileName("newimgname");
			System.out.println("newimgname: "+newimgname);
			System.out.println("Integer.parseInt(id): "+Integer.parseInt(id));
			
			Product p = null;
			if(newimgname == null || newimgname.equals("")) {	//기존 이미지가 있으면 기존이미지 생성
				p = new Product(Integer.parseInt(id), name, Integer.parseInt(price), imgname);
			} else {											//없으면 새로운 이미지 생성
				p = new Product(Integer.parseInt(id), name, Integer.parseInt(price), newimgname);
			}
			try {
				biz.modify(p);
				//상세화면
				response.sendRedirect("product.cacao?cmd=detail&id="+id);
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}
}
