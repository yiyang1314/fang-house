package com.fanghouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fanghouse.entity.Menu;
import com.fanghouse.service.MenuService;
import com.fanghouse.service.impl.MenuServiceImpl;


public class MenuNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AOBOUT_NAV = "about_nav";
	private static final String NEWS_NAV = "news_nav";
	private static final String SERVER_NAV = "server_nav";
	private static final String PRODUCT_NAV = "product_nav";
	private static final String ZHAOPIN_NAV = "zhaopin_nav";
	private static final String CONTACT_NAV = "contact_nav";
	
	private MenuService service=new MenuServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doGet中.....");
		String path=request.getServletPath().substring(1);
		System.out.println("path: "+path);

		List<Menu> list=new ArrayList<Menu>();
		
		if(path.equals(NEWS_NAV)) {
			list=service.sub(2l);
			request.getSession().setAttribute("news_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/news.jsp")
			.forward(request, response);
			
		}else if (path.equals(SERVER_NAV)) {
			list=service.sub(3l);
			request.getSession().setAttribute("server_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/server.jsp")
			.forward(request, response);
			
		}else if(path.equals(PRODUCT_NAV)){
			list=service.sub(4l);
			request.getSession().setAttribute("product_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/product.jsp")
			.forward(request, response);
			
		}else if (path.equals(ZHAOPIN_NAV)) {
			list=service.sub(5l);
			request.getSession().setAttribute("zhaopin_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/zhaopin.jsp")
			.forward(request, response);
			
		}else if(path.equals(CONTACT_NAV)){
			list=service.sub(6l);
			request.getSession().setAttribute("contact_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/contact.jsp")
			.forward(request, response);
			
		}else{//ABOUT_NAV
			list=service.sub(1l);
			request.getSession().setAttribute("about_nemu_list", list);
			request.getRequestDispatcher("client/firstpage/about.jsp")
			.forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
