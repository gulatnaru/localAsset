package web.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.table.TableBiz;
import com.vo.Table;

import web.dispatcher.Util;


@WebServlet({ "/TableServlet", "/table" })
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TableBiz<Table,Integer> biz;
	
	public TableServlet() {
		super();
		biz = new TableBiz<>();	
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ArrayList<Table> list = null;
		  
	      try {
	          list = biz.getAvg();
	          //[ { data:[] } ]
	          JSONArray result = new JSONArray();
	          JSONArray category = new JSONArray();
	          JSONArray ja = new JSONArray();//json배열
	          JSONObject jo = new JSONObject();//json 객체
	          JSONArray ija = new JSONArray();//json 배열 
	          
	          //디비에서 뺀 데이터를 넣어줌
	          for(Table t : list) {
	        	 category.add(t.getLocalname());
	             ija.add(t.getAvg());
	          }
	          jo.put("data", ija);
	          ja.add(jo);
	          result.add(category);
	          result.add(ja);
	          //
	          response.setContentType("text/json;charset=EUC-KR");
	          PrintWriter out =response.getWriter();
	          out.print(result.toJSONString());
	          
	       } catch (Exception e) {
	          e.printStackTrace();
	       }
	}

}
