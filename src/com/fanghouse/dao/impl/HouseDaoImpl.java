package com.fanghouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fanghouse.dao.HouseDao;
import com.fanghouse.db.DataBaseConnection;
import com.fanghouse.entity.House;


public  class HouseDaoImpl implements HouseDao {

	private DataBaseConnection  dbc = new DataBaseConnection();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public List<House> findAll() {
		conn = dbc.getConnection();
		List<House> all = new ArrayList<House>();
		House house = null;
		try {
			String sql = "select houseid, title, picpath, summary, "
					+ "content_url, menuid, house_status from house";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				house=new House();
				house.setHouseid(rs.getLong(1));
				house.setTitle(rs.getString(2));
				house.setPicpath(rs.getString(3));
				house.setSummary(rs.getString(4));
				house.setContentUrl(rs.getString(5));
				house.setMenuid(rs.getLong(6));
				house.setHouseStatus(rs.getString(7));
				all.add(house);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}


	public House findById(Long id) {
		conn = dbc.getConnection();
		House house = null;
		String sql =  "select houseid, title, picpath, summary, "
				+ "content_url, menuid, house_status from house where houseid=?";
				
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			System.out.println("findById(Integer id):"+rs);
			if(rs.next()) {
				house=new House();
				house.setHouseid(rs.getLong(1));
				house.setTitle(rs.getString(2));
				house.setPicpath(rs.getString(3));
				house.setSummary(rs.getString(4));
				house.setContentUrl(rs.getString(5));
				house.setMenuid(rs.getLong(6));
				house.setHouseStatus(rs.getString(7));
			}
			return house;
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return house;
	}

	
	@SuppressWarnings("unchecked")
	public List<House> findPageAll(String column, String keywords, int currentPage, int pageSize) {
		List<House> all = new ArrayList<House>();
		House house = null;
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
			String sql ="select houseid, title, picpath, summary,"
					+ "content_url, menuid, house_status from  "
					+ "(select rownum rn,houseid, title, picpath, "
					+ "summary,content_url, menuid, house_status "
					+ "from (select houseid, title, picpath, "
					+ "summary,content_url, menuid, house_status "
					+ "from house where "+col+" like ? order by houseid asc) temp  where rownum<=?) t where rn>?";
					
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,"%"+key+"%");
			pstmt.setInt(2,currentPage*pageSize);
			pstmt.setInt(3,(currentPage-1)*pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				house=new House();
				house.setHouseid(rs.getLong(1));
				house.setTitle(rs.getString(2));
				house.setPicpath(rs.getString(3));
				house.setSummary(rs.getString(4));
				house.setContentUrl(rs.getString(5));
				house.setMenuid(rs.getLong(6));
				house.setHouseStatus(rs.getString(7));
				all.add(house);
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
		String sql = "select count(1) from house where "+column+" like ?";
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

	public boolean update(House house) {
		conn = dbc.getConnection();
		String sql = "update house set title = ?,picpath =?,summary =?,content_url =?,menuid =?,house_status =? where houseid =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,house.getTitle());
			pstmt.setString(2,house.getPicpath());
			pstmt.setString(3,house.getSummary());
			pstmt.setString(4,house.getContentUrl());
			pstmt.setLong(5,house.getMenuid());
			pstmt.setString(6,house.getHouseStatus());
			pstmt.setLong(7,house.getHouseid());
			System.out.println(sql);
			if(pstmt.executeUpdate()>0) {
				conn.setAutoCommit(true);
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
	public boolean insert(House house) {
		conn = dbc.getConnection();
		String sql = "insert into house(houseid, title, picpath, summary, content_url, menuid, house_status)values(house_seq.nextval, ?, ?, ?, ?, ?, ?)";
		System.out.println(house);
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,house.getTitle());
				pstmt.setString(2,house.getPicpath());
				pstmt.setString(3,house.getSummary());
				pstmt.setString(4,house.getContentUrl());
				pstmt.setLong(5,house.getMenuid());
				pstmt.setString(6,house.getHouseStatus());
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


	@Override
	public boolean del(Long id) {
		conn = dbc.getConnection();
		String sql = "delete house where houseid =?";
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
	public List<House> findByMenuId(Long menuid) {
		conn = dbc.getConnection();
		List<House> all = new ArrayList<House>();
		House house = null;
		try {
			String sql = "select houseid, title, picpath, summary, "
					+ "content_url, menuid, house_status from house where menuid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, menuid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				house=new House();
				house.setHouseid(rs.getLong(1));
				house.setTitle(rs.getString(2));
				house.setPicpath(rs.getString(3));
				house.setSummary(rs.getString(4));
				house.setContentUrl(rs.getString(5));
				house.setMenuid(rs.getLong(6));
				house.setHouseStatus(rs.getString(7));
				all.add(house);
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
