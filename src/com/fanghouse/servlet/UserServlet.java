package com.fanghouse.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanghouse.entity.User;
import com.fanghouse.service.UserService;
import com.fanghouse.service.impl.UserServiceImpl;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private static final String GET = "findAll";
	private static final String BYID = "findById";
	private static final String POST = "save";
	private static final String PUT = "updateById";
	private static final String IDS ="ids";
	private static final String DELETE ="delete";
	private static final String FINDPAGE ="page";
	
	
	
	private UserService service=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doGet中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if (path.equals(GET)) {
			this.findAll(request, response);
		}else if(path.equals(BYID)) {
			this.findById(request, response);
		}else if (path.equals(FINDPAGE)) {
			this.findPageAll(request, response);
		}else if(path.equals(DELETE)||path.equals(IDS)) {
			this.deleteUser(request, response);
		}else if (path.equals(PUT)) {
			this.updateById(request, response);;
		}else{
			request.setAttribute("msg", "请求异常");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}
		
		
	}


	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list=new ArrayList<User>();
	    User user=new User();
		list=service.findAll();
		System.out.println(list);
		if(list.size()==0){
			request.getSession().setAttribute("msg", "查询有误!");
			response.sendRedirect("error.jsp");
		}
		request.setAttribute("user_list", list);
		request.setAttribute("enablePage", false);
		request.setAttribute("enableSearch", false);
		request.getRequestDispatcher("admin/menu_container/users-list.jsp").forward(request, response);
	
		
	}
	
	public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long userid=Long.parseLong(request.getParameter("userid"));
		System.out.println("userid:"+ userid);
		 User user=new User();
		user =service.findById(userid);
		if(user ==null){
			request.getSession().setAttribute("msg", "用户不存在!");
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}else{
			request.setAttribute("user", user );
			request.getRequestDispatcher("admin/files/user/userinfo.jsp").forward(request, response);
		}
		
	}
	public void findPageAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp=request.getParameter("currentPage");
		String ps=request.getParameter("pageSize");
		Integer pageSize=3;
		Integer currentPage=1;
		if(ps!=null){
			pageSize=Integer.parseInt(ps);
		}
		if(cp!=null){
			currentPage=Integer.parseInt(cp);
		}
		String column= request.getParameter("column");
		String keywords=request.getParameter("keywords");
		List<User> list=new ArrayList<User>();
		list=service.findPageAll(
				column,
				keywords,
				currentPage,
				pageSize);
		int count=service.getCount(column,keywords);
		Map columns=new HashMap();
		columns.put("loginname", "用户名");
		columns.put("realname", "真实性名");
		request.setAttribute("columns", columns);
		request.setAttribute("keywords", keywords);
		
		request.setAttribute("enablePage", true);
		request.setAttribute("enableSearch", true);
		
		request.setAttribute("column", column);
		request.setAttribute("user_list", list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", (count-1)/pageSize+1);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("admin/menu_container/users-list.jsp")
					.forward(request, response);
		
	}
	
	public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doPut中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user=null;
		System.out.println("已进入MenuServlet'doPut中.....");
		Long userid=Long.parseLong(request.getParameter("userid"));
		System.out.println(userid);
		user =service.findById(userid);
		if(user ==null){
			request.getSession().setAttribute("msg", "用户不存在!");
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}else{
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/files/user/update.jsp").forward(request, response);
		}
		
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("已进入MenuServlet'doDelete中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map map=new HashMap();
		if (path.equals(IDS)) {
			String s=request.getParameter("ids");
			String ids[]=s.split(" ,");
			map=service.deleteIds(ids);
		}else {
			String id=request.getParameter("userid");
			map=service.delete(id);
		}
	
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("已进入MenuServlet'doPost中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		
		User user=new User();
		String userid=request.getParameter("userid");
		user.setLoginname(request.getParameter("username"));
		user.setLoginpwd(request.getParameter("password"));
		user.setRealname(request.getParameter("realname"));
		Map map=new HashMap();
		if(userid!=null&&userid.length()>0){
			Long id=Long.valueOf(userid);
			user.setUserid(id);;
			map=service.update(user);
		}else{
			map=service.save(user);
		}
		Integer status=(Integer) map.get("status");
		
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
	
		
	}



}
