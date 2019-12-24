package com.fanghouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.fanghouse.dao.UserDao;
import com.fanghouse.db.DataBaseConnection;
import com.fanghouse.entity.User;

public class UserDaoImpl implements UserDao {
	private DataBaseConnection dbc = new DataBaseConnection();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		conn = dbc.getConnection();
		List<User> all = new ArrayList<User>();
		User user = null;
		try {
			String sql ="select userid, loginname, loginpwd, realname from t_users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUserid(rs.getLong(1));
				user.setLoginname(rs.getString(2));
				user.setLoginpwd(rs.getString(3));
				user.setRealname (rs.getString(4));
				System.out.println(user);
				all.add(user);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return Collections.EMPTY_LIST;
	}


	public User findById(Long id) {
		conn = dbc.getConnection();
		User user = null;
		String sql = "select userid, loginname, "
				+ "loginpwd, realname from t_users where userid=?";
				
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setUserid(rs.getLong(1));
				user.setLoginname(rs.getString(2));
				user.setLoginpwd(rs.getString(3));
				user.setRealname (rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public List<User> findPageAll(String column, String keywords, int currentPage, int pageSize) {
		List<User> all = new ArrayList<User>();
		User user = null;
		int count=0;
		try {
			
			String col="loginname";
			String key="n"; 
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
			String sql ="select userid, loginname, loginpwd, realname"
					+ " from  (select rownum rn,userid, loginname, "
					+ "loginpwd, realname from (select userid, "
					+ "loginname, loginpwd, realname from t_users"
					+ " where "+col+" like ? order by userid asc) temp  "
					+ "where rownum<=?) t where rn>?";
					
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,"%"+key+"%");
			pstmt.setInt(2,currentPage*pageSize);
			pstmt.setInt(3,(currentPage-1)*pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUserid(rs.getLong(1));
				user.setLoginname(rs.getString(2));
				user.setLoginpwd(rs.getString(3));
				user.setRealname (rs.getString(4));
				all.add(user);
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
		
		String column="loginname";
		String kw="";
		if(col!=null){
			column=col;
		}
		if(keywords!=null){
			kw=keywords;
		}
		String sql = "select count(1) from t_users where "+column+" like ?";
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


	public boolean insert(User user) {
		conn = dbc.getConnection();
		String sql = "insert into t_users(userid, loginname, "
				+ "loginpwd, realname)values(users_seq.nextval, ?, ?, ?)";
		System.out.println(user);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getLoginname());
			pstmt.setString(2,user.getLoginpwd());
			pstmt.setString(3,user.getRealname());
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


	public boolean update(User user) {
		conn = dbc.getConnection();
		String sql = "update t_users set loginname = ?,"
				+ "loginpwd = ?,realname = ? where userid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,user.getLoginname());
			pstmt.setString(2,user.getLoginpwd());
			pstmt.setString(3,user.getRealname());
			pstmt.setLong(4,user.getUserid());
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


	public boolean del(Long id) {
		conn = dbc.getConnection();
		String sql = "delete t_users where userid =?";
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
	public User login(String username, String password) {
		conn = dbc.getConnection();
		User user = null;
		String sql = "select userid, loginname, "
				+ "loginpwd, realname from t_users where loginname=? and loginpwd=?";	
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setUserid(rs.getLong(1));
				user.setLoginname(rs.getString(2));
				user.setLoginpwd(rs.getString(3));
				user.setRealname (rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return null;
	}


	@Override
	public boolean checkName(String username) {
		conn = dbc.getConnection();
		User user = null;
		String sql = "select count(1) from t_users where loginname=?";	
		System.out.println("sql:"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)>0?true:false;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}finally {
			dbc.close(conn, pstmt, rs);
		}
		return false;
	}

}
