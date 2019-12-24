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

import com.fanghouse.entity.House;
import com.fanghouse.service.HouseService;
import com.fanghouse.service.impl.HouseServiceImpl;


@SuppressWarnings("unused")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET = "findAll";
	private static final String BYID = "findById";
	private static final String POST = "save";
	private static final String PUT = "updateById";
	private static final String IDS ="ids";
	private static final String DEL ="delete";
	private static final String FINDPAGE ="page";
	private static final String HMENUID="Bymenuid";
	private HouseService restful=new HouseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		System.out.println("已进入HouseServlet'doGet中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		if (path.equals(GET)) {
			this.findAll(request, response);
		}else if(path.equals(BYID)) {
			this.findById(request, response);
		}else if (path.equals(FINDPAGE)) {
			this.findPageAll(request, response);
		}else if(path.equals(IDS)||path.equals(DEL)) {
			this.deleteHouse(request, response);
		}else if (path.equals(PUT)) {
			this.updateHouse(request, response);
		}else if (path.equals(HMENUID)) {
			this.findByMenuId(request, response);
		}else{
			
			//request.getSession().setAttribute(arg0, arg1);
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}
		
	}

	public void findByMenuId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<House> list=new ArrayList<House>();
	    House house=new House();
	    String id=request.getParameter("menuid");
	    Long menuid=-1l;
	    if(id!=null){
	    	menuid=Long.valueOf(id);
	    }
		list=restful.findByMenuId(menuid);
		System.out.println(list);
		
		request.setAttribute("houseMenuid_list", list);
		request.getRequestDispatcher("client/firstpage/product/container_product.jsp").forward(request, response);
		
		
	}

	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<House> list=new ArrayList<House>();
	    House house=new House();
		list=restful.findAll();
		System.out.println(list);
		if(list.size()==0){
			request.getSession().setAttribute("msg", "查询有误!");
			response.sendRedirect("error.jsp");
		}
		request.setAttribute("house_list", list);
		request.setAttribute("enablePage", false);
		request.setAttribute("enableSearch", false);
		request.getRequestDispatcher("admin/menu_container/house-list.jsp").forward(request, response);
	
	}
	
	
	public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long houseid=Long.parseLong(request.getParameter("houseid"));
		System.out.println("houseid:"+ houseid);
		if(!(houseid!=null&&houseid.intValue()>0)){
			request.getSession().setAttribute("msg", "请求失败，请稍后重试!");
			response.sendRedirect("error.jsp");
		}
		House house = restful.findById(houseid);
		if(house ==null){
			request.getSession().setAttribute("msg", "用户不存在!");
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}else{
			request.setAttribute("h", house);
			System.out.println(house);
			request.getRequestDispatcher("admin/files/house/house_info.jsp").forward(request, response);
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
		List<House> list = restful.findPageAll(
				column,
				keywords,
				currentPage,
				pageSize);
		int count=restful.getCount(column,keywords);
		Map columns=new HashMap();
		columns.put("title", "名称");
		request.setAttribute("columns", columns);
		request.setAttribute("keywords", keywords);
		
		request.setAttribute("enablePage", true);
		request.setAttribute("enableSearch", true);
		
		request.setAttribute("column", column);
		request.setAttribute("house_list", list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", (count-1)/pageSize+1);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("admin/menu_container/house-list.jsp")
					.forward(request, response);
	}
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入HouseServlet'doPost中.....");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String path=request.getParameter("path");
		System.out.println("POST	       : "+path);
		House house=new House();
		
		String houseid=request.getParameter("houseid");     
		String title=request.getParameter("title");      
		String picpath=request.getParameter("picpath");    
		String summary=request.getParameter("summary");    
		String contentUrl=request.getParameter("contentUrl"); 
		String menuid=request.getParameter("menuid");       
		String houseStatus=request.getParameter("houseStatus");
		
		house.setTitle(title);
		house.setPicpath(picpath);
		house.setSummary(summary);
		house.setContentUrl(contentUrl);
		house.setMenuid(Long.valueOf(menuid));
		house.setHouseStatus(houseStatus);

		Map map=new HashMap();
		if(houseid!=null&&houseid.length()>0){
			Long id=Long.valueOf(houseid);
			house.setHouseid(id);;
			map=restful.update(house);
		}else{
			map=restful.save(house);
		}
		
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);

		
	}


	public void updateHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		House house=null;
		String id=request.getParameter("houseid");
		System.out.println("已进入HouseServlet'doPut中.....");
		Long houseid=null;
		if(id!=null){
			houseid=Long.parseLong(id);
		}
		
		System.out.println(houseid);
		
		if(!(houseid!=null&&houseid.intValue()>0)){
			request.setAttribute("msg", "编号不能为空！");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}
		house =restful.findById(houseid);
		if(house ==null){
			request.setAttribute("msg", "用户不存在!");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}else{
			request.setAttribute("h", house );
			request.getRequestDispatcher("admin/files/house/house_update.jsp").forward(request, response);
		}
		
	}


	public void deleteHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("已进入HouseServlet'doDelete中.....");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		Map map=new HashMap();
		if (path.equals(IDS)) {
			String ids[]=request.getParameter("ids").split(",");
			map=restful.deleteIds(ids);
		}else {
			String id=request.getParameter("houseid");
			map=restful.delete(id);
		}
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
	}
}
