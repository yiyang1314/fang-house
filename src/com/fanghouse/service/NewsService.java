package com.fanghouse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fanghouse.dao.NewsDao;
import com.fanghouse.dao.impl.NewsDaoImpl;
import com.fanghouse.entity.Menu;
import com.fanghouse.entity.News;

public interface NewsService {
	/**
	 * 查询全部
	 * @return
	 */
	public List<News> findAll();
	
	/**
	 * 根据主键查对象
	 * @param Newsid
	 * @return
	 */
	public News findById(Long Newsid);
	
	/**
	 * 模糊查询+分页
	 * @param column : 根据哪一列来模糊查询
	 * @param keywords : 查询的关键字
	 * @param currentPage : 起始的页数
	 * @param pageSize : 每页最多显示多少行数据
	 * @return
	 */
	public List<News> findPageAll(String column,
			String keywords,
			Integer currentPage,Integer pageSize);
	
	
	/**
	 * 增加
	 * @param vo
	 * @return
	 */

	public Map save(News news);
	
	/**
	 * 修改
	 * @param vo : 对象里面，至少，必须有主键在
	 * @return
	 */
	public Map update(News news);
	
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
	 * @param keywords
	 * @return
	 */

	public int getCount(String column,String keywords);

	/**
	 * 根据外键查对象
	 * @param News
	 * @return
	 */
	public List<News> findBymenuId(Long menuid);

	/**
	 * 按照news的类型查询news列表
	 * @param menuid
	 * @return
	 */
	public List<News> findNews(Long menuid);

}
