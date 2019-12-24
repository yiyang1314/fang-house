package com.fanghouse.service;

import java.util.List;
import java.util.Map;

import com.fanghouse.entity.Menu;

public interface MenuService {
	

	/**
	 * 查询全部
	 * @return
	 */

	public List<Menu> findAll();
	/**
	 * 根据主键查对象
	 * @param menuno
	 * @return
	 */
	public Menu findById(Long menuid);
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */

	public List<Menu> findPageAll(String column,String keywords,Integer currentPage,Integer pageSize);
	
	
	/**
	 * 增加
	 * @param vo
	 * @return
	 */

	public Map save(Menu menu);
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public Map update(Menu menu);
	
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
	
	/**
	 * 根据id获取上级菜单
	 * @param id
	 * @return Menu 上级菜单对象
	 */
	public Menu parent(Long id);
	/**
	 * 根据上级id 获取下一级子菜单
	 * @param parentid 上级id
	 * @return List 返回下级所有菜单
	 */
	public List<Menu> sub(Long parentid);
}
