package com.fanghouse.dao;

import java.util.List;

import com.fanghouse.entity.News;
import com.fanghouse.entity.News;

@SuppressWarnings("unused")
public interface NewsDao {

	/**
	 * 查询全部
	 * @return
	 */
	public List<News> findAll();
	
	/**
	 * 根据主键查对象
	 * @param News
	 * @return
	 */
	public News findById(Long id);
	
	
	/**
	 * 根据主键查对象
	 * @param News
	 * @return
	 */
	public List<News> findBymenuId(Long menuid);
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */
	public List<News> findPageAll(String column,String kw,int cp,int ps);
	
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
	public boolean insert(News m);
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public boolean update(News m);
	
	/**
	 * 删除
	 * @param News
	 * @return
	 */
	public boolean del(Long id);


}
