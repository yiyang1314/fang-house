package com.fanghouse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fanghouse.dao.HouseDao;
import com.fanghouse.dao.impl.HouseDaoImpl;
import com.fanghouse.dao.impl.UserDaoImpl;
import com.fanghouse.entity.House;
import com.fanghouse.entity.User;
import com.fanghouse.service.HouseService;

public class HouseServiceImpl implements HouseService {
	private HouseDao dao = new HouseDaoImpl();
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<House> findAll(){
		
		List<House> list=new ArrayList<House>();;
		try {
			 list =dao.findAll();
		} catch (Exception e) {
			System.out.println("findAll'查询列表失败！");
			list =Collections.EMPTY_LIST;
		}
		return list;
	}
	
	/**
	 * 根据主键查对象
	 * @param Houseno
	 * @return
	 */
	public House findById(Long houseid){
		
		House house=null;
		try {
			house=dao.findById(houseid);
		} catch (Exception e) {
			System.out.println("findById'查询列表失败！");
		}
		return house;
	}
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param kw : 查询的关键字
	 * @param cp : 起始的行数
	 * @param ps : 每页最多显示多少行数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<House> findPageAll(String column,String keywords,Integer currentPage,Integer pageSize){
		
		try {
			String col="title";
			String key="";
			if(column!=null){
				col=column;
			}
			if(keywords!=null){
				key=keywords;
			}
			List<House> list =dao.findPageAll(
					col, 
					key, 
					currentPage, 
					pageSize);

			return list;
		} catch (Exception e) {
			System.out.println("findPageAll'查询分页列表失败！");
		}
		return Collections.EMPTY_LIST;
	}
	
	
	/**
	 * 增加
	 * @param vo
	 * @return
	 */

	public Map save(House house){
		Map map=new HashMap();
		try {
			if (dao.insert(house)) {
				map.put("status", 200);
				map.put("msg", "添加成功!");
				return map;
			}
		}catch (Exception e) {
			System.out.println("save'注册失败！");
		}
		
		map.put("status", 404);
		map.put("msg", "添加失败!");
		return map;
	}
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public Map update(House house){
		Map map=new HashMap();
		try {
			if(dao.update(house)){
				map.put("status", 200);
				map.put("msg", "修改成功!");
				return map;
			}
		
		}catch (Exception e) {
			System.out.println("update'更新列表失败！");
		}
		map.put("status", 404);
		map.put("msg", "修改失败!");
		return map;
	}
	
	/**
	 * 删除
	 * @param Houseno
	 * @return
	 */

	public Map delete(String id){
		Map map=new HashMap();
		try {
			if(id==null){
				map.put("status", 302);
				map.put("msg", "房源不存在！");
				return map;
			}
			if(dao.del(Long.parseLong(id))){
				map.put("status", 200);
				map.put("msg", "删除成功！");
				return map;
			}
		} catch (Exception e) {
			System.out.println("delete'删除失败！");
		}
		map.put("status", 404);
		map.put("msg", "删除失败！");
		return map;

		
	}

	/**deleteIds
	 * 根据ids 批量删除
	 * @param request
	 * @param response
	 */
	public Map deleteIds(String[] ids){
		Map map=new HashMap();
		int n=0;
		try {
			
			for(String id:ids){
				System.out.println(id);
				dao.del(Long.parseLong(id));
				n++;
			}
			if(n>0){
				map.put("status", 200);
				map.put("msg", "已批量删除"+n+ "条记录！");
				return map;
			}
		} catch (Exception e) {
			System.out.println("deleteIds'删除列表失败！");
		}
		map.put("status", 404);
		map.put("msg", "批量删除失败！");
		return map;
	}
	
	/**
	 * 用来统计满足条件的数据总共有多少行
	 * @param column
	 * @param kw
	 * @return
	 */
	public int getCount(String column,String keywords){
		try{
			String col="title";
			String key="";
			if(column!=null){
				col=column;
			}
			if(keywords!=null){
				key=keywords;
			}
			
			return dao.getCount(column, key);
		} catch (Exception e) {
				System.out.println("deleteIds'删除列表失败！");
		}
		return 0;
	}

	@Override
	public List<House> findByMenuId(Long menuid) {
		
		return dao.findByMenuId(menuid);
	}
}
