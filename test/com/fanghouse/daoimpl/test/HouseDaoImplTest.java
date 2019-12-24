package com.fanghouse.daoimpl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fanghouse.dao.HouseDao;
import com.fanghouse.dao.impl.HouseDaoImpl;
import com.fanghouse.entity.House;

@SuppressWarnings("unused")
public class HouseDaoImplTest {
	private HouseDao dao=null;
	@Before
	public void init(){
		dao=new	HouseDaoImpl();
	}
	
	
	@Test
	public void testFindAll() {
		dao.findByMenuId(18l).forEach(System.out::println);
	}

	@Test
	public void testFindById() {

		System.out.println(dao.findById(3l));
	}

	@Test
	public void testFindPageAll() {
		dao.findPageAll("title", "城", 1, 1).forEach(System.out::println);
			
	}

	@Test
	public void testGetCount() {
		System.out.println(dao.getCount("title", "大"));
	}

	@Test
	public void testUpdate() {
		House h=dao.findById(4l);
		h.setTitle("大唐帝国");
		System.out.println(dao.update(h));
	}

	@Test
	public void testInsert() {
		House house=new House();

		house.setTitle("李云龙大哥你好");
		house.setPicpath("client/images/house/3.jpg");
		house.setSummary("亮剑----抗日英雄");
		house.setContentUrl("http://client/images/house/3.jpg");
		house.setMenuid(20l);
		house.setHouseStatus("0");
		System.out.println(dao.insert(house));
		
	}

	@Test
	public void testDel() {
		
		System.out.println(dao.del(3350l));
	}
	@Test
	public void findByMenuId() {
		
		dao.findByMenuId(11l).forEach(System.out::println);
	}
	
	
}
