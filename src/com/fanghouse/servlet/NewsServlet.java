package com.fanghouse.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fanghouse.entity.Menu;
import com.fanghouse.entity.News;
import com.fanghouse.service.MenuService;
import com.fanghouse.service.NewsService;
import com.fanghouse.service.impl.NewsServiceImpl;


public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String GET = "findAll";
	private static final String BYID = "findById";
	private static final String POST = "save";
	private static final String PUT = "updateById";
	private static final String DELIDS ="ids";
	private static final String DEL ="delete";
	private static final String FINDPAGE ="page";
	private static final String BYMENUID ="byMenuid";
	private NewsService service=new NewsServiceImpl();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doGet中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if (path.equals(GET)) {
			this.findAll(request, response);
		}else if(path.equals(BYID)) {
			this.findById(request, response);
		}else if (path.equals(FINDPAGE)) {
			this.findPageAll(request, response);
		}else if(path.equals(DELIDS)||path.equals(DEL)) {
			this.deleteNews(request, response);
		}else if (path.equals(PUT)) {
			this.updateNews(request, response);
		}else if (path.equals(BYMENUID)) {
			this.navNews(request, response);
		}else{
			
			//request.getSession().setAttribute(arg0, arg1);
			response.sendRedirect("rest");
		}
		
		
	}
	public void navNews(HttpServletRequest request, HttpServletResponse response) {
		List<News> list=new ArrayList<News>();
	    News news=new News();
	    String id=request.getParameter("menuid");
	    Long menuid=-1l;
	    if(id!=null){
	    	menuid=Long.valueOf(id);
	    }
		list=service.findNews(menuid);
		request.setAttribute("newsMenuid_list", list);
		try {
			request.getRequestDispatcher("client/firstpage/news/container_news.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> list=new ArrayList<News>();
	    News news=new News();
		list=service.findAll();
		System.out.println(list);
		if(list.size()==0){
			request.getSession().setAttribute("msg", "查询有误!");
			response.sendRedirect("error.jsp");
		}
		request.setAttribute("news_list", list);
		request.setAttribute("enablePage", false);
		request.setAttribute("enableSearch", false);
		request.getRequestDispatcher("admin/menu_container/news-list.jsp").forward(request, response);
	
	}
	public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    News news=new News();
		Long newsid=Long.parseLong(request.getParameter("newsid"));
		System.out.println("newsid:"+ newsid);
		news =service.findById(newsid);
		if(news ==null){
			request.setAttribute("msg", "用户不存在!");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}else{
			request.setAttribute("news", news );
			request.getRequestDispatcher("admin/files/news/news_info.jsp").forward(request, response);
		}
		
	}
	public void findPageAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp=request.getParameter("currentPage");
		String ps=request.getParameter("pageSize");
		List<News> list=new ArrayList<News>();
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
		list=service.findPageAll(
				column,
				keywords,
				currentPage,
				pageSize);
		int count=service.getCount(column,keywords);
		Map columns=new HashMap();
		columns.put("title", "名称");

		request.setAttribute("columns", columns);
		request.setAttribute("keywords", keywords);
		
		request.setAttribute("enablePage", true);
		request.setAttribute("enableSearch", true);
		
		request.setAttribute("column", column);
		request.setAttribute("news_list", list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", (count-1)/pageSize+1);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("admin/menu_container/news-list.jsp")
					.forward(request, response);
		
	}
	
	
	
	
	
	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("已进入MenuServlet'doPost中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		News news=new News();
		String newsid=request.getParameter("newsid");
		news.setTitle(request.getParameter("title"));
		news.setContentUrl(request.getParameter("contentUrl"));
		
		Date publishTime=null;
		SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd");
		try {
			publishTime = sft.parse(request.getParameter("publishTime"));
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		news.setPicpath(request.getParameter("picpath"));
		String menuid=""+request.getParameter("menuid");
		news.setMenuid(Long.valueOf(menuid));
		news.setSummary(request.getParameter("summary"));
		news.setNewStatus(request.getParameter("newStatus"));

		Map map=new HashMap();
		if(newsid!=null&&newsid.length()>0){
			Long id=Long.valueOf(newsid);
			news.setNewid(id);
			news.setPublishTime(new Date());
			map=service.update(news);
		}else{
			news.setPublishTime(publishTime);
			map=service.save(news);
		}

		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		
		
	}

	
	public void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doPut中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		News news=null;
		System.out.println("已进入MenuServlet'doPut中.....");
		Long newsid=Long.parseLong(request.getParameter("newsid"));
		System.out.println(newsid);
		news =service.findById(newsid);
		if(news ==null){
			
			request.setAttribute("msg", "该记录不存在!");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}else{
			request.setAttribute("news", news);
			request.getRequestDispatcher("admin/files/news/news_update.jsp").forward(request, response);
		}
	}

	
	public void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doDelete中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map map=new HashMap();
		if (path.equals(DELIDS)) {
			String ids[]=request.getParameter("ids").split(",");
			map=service.deleteIds(ids);
		}else {
			String id=request.getParameter("newsid");
			map=service.delete(id);
		}
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		
		
		
	}

}
