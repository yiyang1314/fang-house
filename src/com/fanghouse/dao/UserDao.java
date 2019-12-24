package com.fanghouse.dao;

import java.util.List;


import com.fanghouse.entity.User;
import com.fanghouse.entity.User;

@SuppressWarnings("unused")
public interface UserDao {

	/**
	 * 查询全部
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据主键查对象
	 * @param User
	 * @return
	 */
	public User findById(Long id);
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */
	public List<User> findPageAll(String column,String kw,int cp,int ps);
	
	/**
	 * 用来统计满足条件的数据总共有多少行
	 * @param column
	 * @param kw
	 * @return
	 */
	public int getCount(String column,String kw);
	
	/**
	 * 增加
	 * @param vo
	 * @return
	 */
	public boolean insert(User u);
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public boolean update(User u);
	
	/**
	 * 删除
	 * @param User
	 * @return
	 */
	public boolean del(Long id);
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return  true|false登录成功或者失败
	 */
	public User login(String  username,String password);
	
	/**
	 * 查询用户名
	 * @param username 用户名
	 * @return 返回用户名是否存在
	 */
	public boolean checkName(String username);
}
