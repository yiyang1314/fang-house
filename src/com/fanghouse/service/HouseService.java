package com.fanghouse.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fanghouse.dao.HouseDao;
import com.fanghouse.dao.impl.HouseDaoImpl;
import com.fanghouse.entity.House;



@SuppressWarnings("unchecked")
public interface HouseService {

	
	/**
	 * 查询全部
	 * @return
	 */

	public List<House> findAll();
	
	/**
	 * 根据主键查对象
	 * @param Houseno
	 * @return
	 */
	public House findById(Long houseid);
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */
	public List<House> findPageAll(String column,String keywords,Integer currentPage,Integer pageSize);
	
	
	/**
	 * 增加
	 * @param vo
	 * @return
	 */

	public Map save(House house);
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public Map update(House house);
	
	/**
	 * 删除
	 * @param Houseno
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
	 * @param kw
	 * @return
	 */
	public int getCount(String column,String keywords);

	public List<House> findByMenuId(Long menuid);
}
