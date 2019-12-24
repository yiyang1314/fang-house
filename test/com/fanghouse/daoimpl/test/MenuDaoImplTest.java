package com.fanghouse.daoimpl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fanghouse.dao.HouseDao;
import com.fanghouse.dao.MenuDao;
import com.fanghouse.dao.impl.HouseDaoImpl;
import com.fanghouse.dao.impl.MenuDaoImpl;
import com.fanghouse.entity.House;
import com.fanghouse.entity.Menu;

@SuppressWarnings("unused")
public class MenuDaoImplTest {

	
	private MenuDao dao=null;
	@Before
	public void init(){
		dao=new	MenuDaoImpl();
	}
	@Test
	public void testFindAll() {
		dao.findAll().forEach(System.out::println);
	}

	@Test
	public void testFindById() {
		System.out.println(dao.findById(1l));
	}

	@Test
	public void testFindPageAll() {
		dao.findPageAll("menu_name", "聘", 2, 3).forEach(System.out::println);
		
	}

	@Test
	public void testGetCount() {
		System.out.println(dao.getCount("menu_name", "公司"));
	}

	@Test
	public void testInsert() {
		Menu menu =new Menu();
		menu.setMenuName("面试流程");
		menu.setParentid(5l);
		menu.setPicpath	("/client/menu/0l.jpg");
		menu.setMenuStatus("1");
		menu.setMenuUrl("http://localhost:8080/fang-house/client/firstpage/zhaopin.jsp");
		
		System.out.println(dao.insert(menu));
		
	}

	@Test
	public void testUpdate() {
		Menu menu =dao.findById(2l);
		//menu.setMenuUrl("news_findAll");

		//menu.setMenuUrl("news_findAll");
		menu.setMenuUrl("news_nav");
		menu.setPicpath("/client/menu/0l.jpg");
		System.out.println(dao.update(menu));
	}

	@Test
	public void testDel() {
		System.out.println(dao.del(1111l));
	}

	@Test
	public void testParent() {
		Menu menu =dao.parent(0l);
		System.out.println(menu);
	
	}

	@Test
	public void testSub() {
		dao.sub(0l).forEach(System.out::println);
	}

}
