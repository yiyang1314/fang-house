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
import com.fanghouse.entity.Menu;
import com.fanghouse.service.MenuService;
import com.fanghouse.service.impl.MenuServiceImpl;


public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NAV = "nav";
	private static final String GET = "findAll";
	private static final String ById = "findById";
	private static final String BACK = "parentlist";
	private static final String POST = "post";
	private static final String PUT = "updateById";
	private static final String DEIDS ="ids";
	private static final String DEL ="delete";
	private static final String FINDPAGE ="page"; 
	private static final String SUB ="sub";  
	private MenuService service=new MenuServiceImpl();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doGet中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    //查询所有
		if (path.equals(GET)) {
			this.findAll(request, response);
			//回到上级菜单列表
		}else if(path.equals(BACK)) {
			this.backParent(request, response);
			//分页查询
		}else if(path.equals(ById)) {
			this.findById(request, response);
			//分页查询
		}else if (path.equals(FINDPAGE)) {
			this.page(request, response);
			//查询顶级菜单，在主页显示
		}else if(path.equals(NAV)){
			this.nav(request, response);
			//根据上级id，查询下级菜单
		}else if(path.equals(SUB)){
			this.sub(request, response);
			//修改菜单
		}else if(path.equals(PUT)){
			this.updateMenu(request, response);
			//根据id，批量删除
		}else if(path.equals(DEIDS)||path.equals(DEL)){
			this.deleteMenu(request, response);
		}else{
			request.setAttribute("msg", "请求出错！");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}	
	}
	
	/**
	 *用于添加或修改
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("已进入MenuServlet'doPost中.....");
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Menu menu=new Menu();
		String menuid=request.getParameter("menuid");
       
		menu.setMenuName(request.getParameter("menuName"));        
		menu.setPicpath(request.getParameter("picpath"));      
		menu.setMenuStatus(request.getParameter("menuStatus"));
		menu.setMenuUrl(request.getParameter("menuUrl"));      
		String parentid=request.getParameter("parentid");
		menu.setParentid(Long.valueOf(parentid));
		
		
		Map map=new HashMap();
		if(menuid!=null&&menuid.length()>0){
			Long id=Long.valueOf(menuid);
			menu.setMenuid(id);
			map=service.update(menu);
		}else{
			map=service.save(menu);
		}
		request.setAttribute("resultmap", map);
		request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);

		
	}
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> list=new ArrayList<Menu>();
	    Menu menu=new Menu();
		list=service.findAll();
		System.out.println(list);
		if(list.size()==0){
			request.getSession().setAttribute("msg", "查询有误!");
			response.sendRedirect("error.jsp");
		}
		request.setAttribute("menu_list", list);
		request.setAttribute("enablePage", false);
		request.setAttribute("enableSearch", false);
		request.getRequestDispatcher("admin/menu_container/menu-list.jsp").forward(request, response);
		
	}
	
	public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    Menu menu=null;
	    String  id =request.getParameter("menuid");
	    Long menuid=-1l;
		if(id!=null&&id.length()>0){
	    	menuid=Long.valueOf(id);
	    }
		menu=service.findById(menuid );
		if(menu==null){
			request.setAttribute("msg", "请求频繁过度，请稍后再试");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}
		request.setAttribute("m", menu);
		request.getRequestDispatcher("admin/files/menu/menu_info.jsp").forward(request, response);
		
	}
	
	
	
	
	
	
	
	
	
	public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> list=new ArrayList<Menu>();
	    Menu menu=new Menu();
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
		list=service.findPageAll(
				column,
				keywords,
				currentPage,
				pageSize);
		int count=service.getCount(column,keywords);
		Map columns=new HashMap();
		columns.put("menu_name", "名称");

		request.setAttribute("columns", columns);
		request.setAttribute("keywords", keywords);
		
		request.setAttribute("enablePage", true);
		request.setAttribute("enableSearch", true);
		
		request.setAttribute("column", column);
		request.setAttribute("menu_list", list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", (count-1)/pageSize+1);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.getRequestDispatcher("admin/menu_container/menu-list.jsp")
					.forward(request, response);
	}
	public void backParent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("parentid");
		Long parentid=-1l;
		if(id!=null&&id.length()>0){
			parentid=Long.parseLong(id);//parentid
		}
		System.out.println("parentid:"+ parentid);
		 Menu menu=new Menu();
		menu =service.findById(parentid);
		if(menu!=null){
			List<Menu> menu_list=service.sub(menu.getParentid());
			if(menu_list.size()>0){
				request.setAttribute("menu_list", menu_list);
			}
			request.setAttribute("parentid:",parentid);
			request.getRequestDispatcher("admin/menu_container/menu-list.jsp")
						.forward(request, response);
		}else{
			request.setAttribute("msg", "请求繁忙");
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}
	}

	public void nav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parentid=request.getParameter("parentid");
		Long id=parentid==null?0l:Long.valueOf(parentid);
		List<Menu> menu_list=service.sub(id);
		request.setAttribute("menu_list", menu_list);
		request.getRequestDispatcher("client/index.jsp")
					.forward(request, response);
	}
	public void sub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parentid=request.getParameter("parentid");
		Long id=parentid==null?0l:Long.valueOf(parentid);
		List<Menu> menu_list=service.sub(id);
		request.setAttribute("menu_list", menu_list);
		request.getRequestDispatcher("admin/menu_container/menu-list.jsp")
					.forward(request, response);
	}

	public void updateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu menu=null;
		System.out.println("已进入MenuServlet'doPut中.....");
		Long menuid=Long.parseLong(request.getParameter("menuid"));
		System.out.println(menuid);
		menu =service.findById(menuid);
		if(menu ==null){
			request.setAttribute("msg ", "该菜单项不存在" );
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		}else{
			request.setAttribute("menu", menu );
			request.getRequestDispatcher("admin/files/menu/menu_update.jsp").forward(request, response);
		}
	}
	
	public void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map map=new HashMap();
		String serverpath=request.getServletPath();
		System.out.println("serverpath: "+serverpath);
		String path=serverpath.substring(serverpath.indexOf("_")+1);
		System.out.println("path: "+path);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if (path.equals(DEIDS)) {
			String ids[]=request.getParameter("ids").split(",");
			map=service.deleteIds(ids);
		}else {
			String id=request.getParameter("menuid");
			map=service.delete(id);
		}
		
			request.setAttribute("resultmap", map);
			request.getRequestDispatcher("admin/files/wain.jsp").forward(request, response);
		
		
		
	}


}
