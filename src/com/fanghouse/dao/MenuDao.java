package com.fanghouse.dao;

import java.util.List;

import com.fanghouse.entity.Menu;

public interface MenuDao {

		/**
		 * 查询全部
		 * @return
		 */
		public List<Menu> findAll();
		
		/**
		 * 根据主键查对象
		 * @param Menu
		 * @return
		 */
		public Menu findById(Long id);
		
		/**
		 * 模糊查询+分页
		 * @param column : 根据哪一列来模糊查询
		 * @param kw : 查询的关键字
		 * @param cp : 起始的行数
		 * @param ps : 每页最多显示多少行数据
		 * @return
		 */
		public List<Menu> findPageAll(String column,String kw,int cp,int ps);
		
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
		public boolean insert(Menu m);
		
		/**
		 * 修改
		 * @param vo : 对象里面，至少，必须有主键在
		 * @return
		 */
		public boolean update(Menu m);
		
		/**
		 * 删除
		 * @param Menu
		 * @return
		 */
		public boolean del(Long id);
		
		/**
		 * 
		 * @param parentid 上级id
		 * @return 上级
		 */
		public Menu parent(Long id);
		
		/**
		 * 获取下级id
		 * @param parentid 上级id
		 * @return
		 */
		public List<Menu> sub(Long parentid);
}
