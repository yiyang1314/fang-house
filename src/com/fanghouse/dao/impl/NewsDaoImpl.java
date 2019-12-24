package com.fanghouse.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fanghouse.dao.NewsDao;
import com.fanghouse.db.DataBaseConnection;
import com.fanghouse.entity.News;



public class NewsDaoImpl  implements  NewsDao{

	private DataBaseConnection  dbc = new DataBaseConnection();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public List<News> findAll() {
		conn = dbc.getConnection();
		List<News> all = new ArrayList<News>();
		News news = null;
		try {
			String sql = "select newid, title, content_url, publish_time, "
					+ "picpath, menuid, summary, new_status from News";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 
				news=new News();
				news.setNewid(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setContentUrl(rs.getString(3));
				news.setPublishTime(new Date(rs.getDate(4).getTime()));
				news.setPicpath	(rs.getString(5));
				news.setMenuid(rs.getLong(6));
				news.setSummary(rs.getString(7));
				news.setNewStatus(rs.getString(8));
				all.add(news);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}


	public News findById(Long id) {
		conn = dbc.getConnection();
		News news = null;
		String sql = "select newid, title, content_url, publish_time, picpath, menuid, summary, new_status from news"
				+ " where newid=?";
				
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			System.out.println("findById(Integer id):"+rs);
			if(rs.next()) {
				news=new News();
				news.setNewid(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setContentUrl(rs.getString(3));
				news.setPublishTime(new Date(rs.getDate(4).getTime()));
				news.setPicpath	(rs.getString(5));
				news.setMenuid(rs.getLong(6));
				news.setSummary(rs.getString(7));
				news.setNewStatus(rs.getString(8));
			}
			return news;
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<News> findPageAll(String column, String keywords, int currentPage, int pageSize) {
		List<News> all = new ArrayList<News>();
		News news = null;
		int count=0;
		try {
			
			String col="title";
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
			String sql ="select  newid, title, content_url,"
					+ " publish_time, picpath, menuid, summary, "
					+ "new_status from  (select rownum rn, "
					+ "newid, title, content_url, publish_time, "
					+ "picpath, menuid, summary, new_status "
					+ "from (select  newid, title, content_url, "
					+ "publish_time, picpath, menuid, summary, "
					+ "new_status from news where "+col+" like ? order "
					+ "by newid asc) temp  where rownum<=?) t where rn>?";
					
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,"%"+key+"%");
			pstmt.setInt(2,currentPage*pageSize);
			pstmt.setInt(3,(currentPage-1)*pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				news=new News();
				news.setNewid(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setContentUrl(rs.getString(3));
				news.setPublishTime(new Date(rs.getDate(4).getTime()));
				news.setPicpath	(rs.getString(5));
				news.setMenuid(rs.getLong(6));
				news.setSummary(rs.getString(7));
				news.setNewStatus(rs.getString(8));
				all.add(news);
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
		
		String column="title";
		String kw="";
		if(col!=null){
			column=col;
		}
		if(keywords!=null){
			kw=keywords;
		}
		String sql = "select count(1) from news where "+column+" like ?";
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




	public boolean update(News news) {
		conn = dbc.getConnection();
		String sql = "update news set title =?,"
				+ "content_url =?,publish_time = ?,"
				+ "picpath = ?,menuid =?,summary = ?,"
				+ "new_status = ? where newid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1,news.getTitle());
			pstmt.setString( 2,news.getContentUrl());
			pstmt.setDate( 3,new Date(news.getPublishTime().getTime()));
			pstmt.setString( 4,news.getPicpath());
			pstmt.setLong( 5,news.getMenuid());
			pstmt.setString(6,news.getSummary());
			pstmt.setString( 7,news.getNewStatus());
			pstmt.setLong( 8,news.getNewid());

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
	public boolean insert(News news) {
		conn = dbc.getConnection();
		String sql = "insert into news(newid, title, content_url,"
				+ " publish_time, picpath, menuid, summary, "
				+ "new_status)values"
				+ "(news_seq.nextval, ?, ?, ?,?,?,?, ?)";
		System.out.println(news);
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
		
			pstmt.setString( 1,news.getTitle());
			pstmt.setString( 2,news.getContentUrl());
			pstmt.setDate( 3,new Date(news.getPublishTime().getTime()));
			pstmt.setString( 4,news.getPicpath());
			pstmt.setLong( 5,news.getMenuid());
			pstmt.setString(6,news.getSummary());
			pstmt.setString( 7,news.getNewStatus());
			
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


	@Override
	public boolean del(Long id) {
		conn = dbc.getConnection();
		String sql = "delete news where newid = ?";
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
	public List<News> findBymenuId(Long menuid) {
		conn = dbc.getConnection();
		List<News> all = new ArrayList<News>();
		News news = null;
		try {
			String sql = "select newid, title, content_url, publish_time, "
					+ "picpath, menuid, summary, new_status from News where menuid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, menuid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 
				news=new News();
				news.setNewid(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setContentUrl(rs.getString(3));
				news.setPublishTime(new Date(rs.getDate(4).getTime()));
				news.setPicpath	(rs.getString(5));
				news.setMenuid(rs.getLong(6));
				news.setSummary(rs.getString(7));
				news.setNewStatus(rs.getString(8));
				all.add(news);
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
