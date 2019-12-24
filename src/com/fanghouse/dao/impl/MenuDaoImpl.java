package com.fanghouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fanghouse.dao.MenuDao;
import com.fanghouse.db.DataBaseConnection;
import com.fanghouse.entity.House;
import com.fanghouse.entity.Menu;

@SuppressWarnings("unused")
public class MenuDaoImpl implements MenuDao {

	private DataBaseConnection  dbc = new DataBaseConnection();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public List<Menu> findAll() {
		conn = dbc.getConnection();
		List<Menu> all = new ArrayList<Menu>();
		Menu menu = null;
		try {
			String sql = "select menuid, menu_name, parentid, "
					+ "picpath, menu_status, "
					+ "menu_url from menu";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 //menu=new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4));
				menu=new Menu();
				menu.setMenuid(rs.getLong(1));
				menu.setMenuName(rs.getString(2));
				menu.setParentid(rs.getLong(3));
				menu.setPicpath	(rs.getString(4));
				menu.setMenuStatus(rs.getString(5));
				menu.setMenuUrl(rs.getString(6));
				all.add(menu);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}


	public Menu findById(Long id) {
		conn = dbc.getConnection();
		Menu menu = null;
		String sql = "select menuid, menu_name, parentid, "
				+ "picpath, menu_status, menu_url "
				+ "from menu where menuid=?";
				
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			System.out.println("findById(Integer id):"+rs);
			if(rs.next()) {
				menu=new Menu();
				menu.setMenuid(rs.getLong(1));
				menu.setMenuName(rs.getString(2));
				menu.setParentid(rs.getLong(3));
				menu.setPicpath	(rs.getString(4));
				menu.setMenuStatus(rs.getString(5));
				menu.setMenuUrl(rs.getString(6));
			}
			return menu;
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return menu;
	}

	
	@SuppressWarnings("unchecked")
	public List<Menu> findPageAll(String column, String keywords, int currentPage, int pageSize) {
		List<Menu> all = new ArrayList<Menu>();
		Menu menu = null;
		int count=0;
		try {
			
			String col="menu_name";
			String key=""; 
			if(!(column==null||column.length()==0)){
				col=column;
			}
			if(!(keywords==null||keywords.length()==0)){
				key=keywords;
			}
			count=getCount(col,key);
			System.out.println(count);
			if(count<1){
				return Collections.EMPTY_LIST;
			}
			conn = dbc.getConnection();
			//
			String sql ="select menuid, menu_name, parentid,picpath, menu_status, "
					+ "menu_url  from  (select rownum rn,menuid, "
					+ "menu_name, parentid,picpath, menu_status, "
					+ "menu_url  from (select menuid, menu_name, "
					+ "parentid,picpath, menu_status, menu_url  "
					+ "from menu where "+col+" like ? order by  menuid asc)"
							+ " temp  where rownum<=?) t where rn>?";
					
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,"%"+key+"%");
			pstmt.setInt(2,currentPage*pageSize);
			pstmt.setInt(3,(currentPage-1)*pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu=new Menu();
				menu.setMenuid(rs.getLong(1));
				menu.setMenuName(rs.getString(2));
				menu.setParentid(rs.getLong(3));
				menu.setPicpath	(rs.getString(4));
				menu.setMenuStatus(rs.getString(5));
				menu.setMenuUrl(rs.getString(6));
				all.add(menu);
			}
			System.out.println(all);
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}

	
	public int getCount(String col, String keywords) {
		int count=0;
		conn = dbc.getConnection();
		
		String column="menu_name";
		String kw="";
		if(col!=null){
			column=col;
		}
		if(keywords!=null){
			kw=keywords;
		}
		String sql = "select count(1) from  menu where "+column+" like ?";
		System.out.println("sql:\n"+sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+kw+"%");
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return count;
	}

	

	public boolean insert(Menu menu) {
		conn = dbc.getConnection();
		String sql = "insert into menu(menuid, menu_name, parentid, "
				+ "picpath, menu_status, menu_url)values"
				+"(menu_seq.nextval, ?, ?, ?, ?, ?)";
		System.out.println(menu);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, menu.getMenuName());
			pstmt.setLong( 2, menu.getParentid());
			pstmt.setString( 3, menu.getPicpath());
			pstmt.setString( 4, menu.getMenuStatus());
			pstmt.setString( 5, menu.getMenuUrl());
			System.out.println(sql);
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return false;
	}


	public boolean update(Menu menu) {
		conn = dbc.getConnection();
		String sql = "update menu set "
				+ "menu_name = ?,parentid =?,"
				+ "picpath =?,menu_status =?,"
				+ "menu_url =? where menuid =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, menu.getMenuName());
			pstmt.setLong( 2, menu.getParentid());
			pstmt.setString( 3, menu.getPicpath());
			pstmt.setString( 4, menu.getMenuStatus());
			pstmt.setString( 5, menu.getMenuUrl());
			pstmt.setLong( 6, menu.getMenuid());
			System.out.println(sql);
			if(pstmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return false;
	}



	@Override
	public boolean del(Long id) {
		conn = dbc.getConnection();
		String sql = "delete menu where menuid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			if(pstmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return false;
	}


	@Override
	public Menu parent(Long id) {
		   Menu menu =null;
	
			conn = dbc.getConnection();
			String sql = "select menuid, menu_name, parentid, "
					+ "picpath, menu_status, menu_url "
					+ "from menu where menuid=(select parentid "
					+ "from menu where menuid=?)";
			try {
				
					pstmt = conn.prepareStatement(sql);
					System.out.println(sql);
					pstmt.setLong(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						menu = new Menu();
						menu.setMenuid(rs.getLong(1));
						menu.setMenuName(rs.getString(2));
						menu.setParentid(rs.getLong(3));
						menu.setPicpath	(rs.getString(4));
						menu.setMenuStatus(rs.getString(5));
						menu.setMenuUrl(rs.getString(6));
					}
					return menu;
			}catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				dbc.close(conn, pstmt, rs);
			}
			return null;
		
	}


	
	@SuppressWarnings("unchecked")
	public List<Menu> sub(Long parentid) {
		conn = dbc.getConnection();
		List<Menu> all = new ArrayList<Menu>();
		Menu menu = null;
		try {
			String sql = "select menuid, menu_name, parentid, "
					+ "picpath, menu_status, "
					+ "menu_url from menu where parentid=?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setLong(1, parentid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu=new Menu();
				menu.setMenuid(rs.getLong(1));
				menu.setMenuName(rs.getString(2));
				menu.setParentid(rs.getLong(3));
				menu.setPicpath	(rs.getString(4));
				menu.setMenuStatus(rs.getString(5));
				menu.setMenuUrl(rs.getString(6));
				System.out.println(menu);
				all.add(menu);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}


}
