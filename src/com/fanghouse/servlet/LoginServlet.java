package com.fanghouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanghouse.entity.User;
import com.fanghouse.service.UserService;
import com.fanghouse.service.impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN ="login";
	private static final String REG ="reg";
	private static final String SEARCH ="search";
	private static final String LOGOUT ="logout";
	
	private UserService service =new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		System.out.println("已进入LoginServlet'doGet中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);	
		if(path.equals(LOGIN)){
			String code1=(String) request.getSession().getAttribute("checkcode");
			request.getSession().setAttribute("checkcode","");
			String code2=request.getParameter("code");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Map map=service.login(username, password);
			System.out.println(code1+code2+(code1.equals(code2)));
			Integer status=(Integer) map.get("status");
			if(!code1.equals(code2)){
				status=406;
			}

			if(status==200){
				request.setAttribute("msg","");
				request.getSession().setAttribute("u",(User)map.get("user"));
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			}
			if(status==406){
				request.setAttribute("msg","验证码错误");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}else{
				request.setAttribute("msg","登录失败！");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}
			
		}else if(path.equals(LOGOUT)){
			request.getSession().removeAttribute("u");
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
	}

}
