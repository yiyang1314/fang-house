package com.fanghouse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fanghouse.dao.UserDao;
import com.fanghouse.dao.UserDao;
import com.fanghouse.dao.impl.UserDaoImpl;
import com.fanghouse.entity.News;
import com.fanghouse.entity.User;

public interface UserService {

	/**
	 * 查询全部
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据主键查对象
	 * @param userno
	 * @return
	 */
	public User findById(Long userid);
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */
	public List<User> findPageAll(String column,
			String keywords,Integer currentPage,Integer pageSize);
	
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	public Map save(User user);
	
	/**
	 * 修改
	 * @param user : 对象里面，至少，必须有主键在
	 * @return
	 */
	public Map update(User user);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */

	public Map delete(String id);
	/**deleteIds
	 * 根据ids 批量删除
	 * @param request
	 * @param response
	 */
	public Map deleteIds(String[] ids);
	
	/**
	 * 用来统计满足条件的数据总共有多少行
	 * @param column
	 * @param keywords
	 * @return
	 */
	public int getCount(String column,String keywords);
	
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return  true|false登录成功或者失败
	 */
	public Map login(String  username,String password);
	
	
	/**
	 * 查询用户名
	 * @param username 用户名
	 * @return 返回用户名是否存在
	 */
	public Map checkName(String username);
}
