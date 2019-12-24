package com.fanghouse.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import com.fanghouse.entity.House;
import com.fanghouse.entity.User;
import com.fanghouse.service.HouseService;
import com.fanghouse.service.UserService;
import com.fanghouse.service.impl.UserServiceImpl;

public class UserServiceTest {

	private UserService service=null;
	@Before
	public void init(){
		service=new	UserServiceImpl();
	}
	
	
	@Test
	public void testFindAll() {
		service.findAll().forEach(System.out::println);
	}

	@Test
	public void testFindById() {

		System.out.println(service.findById(1170l));
	}

	@Test
	public void testFindPageAll() {
		service.findPageAll("loginname", "an", 1, 3).forEach(System.out::println);
			
	}

	@Test
	public void testGetCount() {
		System.out.println(service.getCount("loginname", "an"));
	}

	@Test
	public void testUpdate() {
		User u=service.findById(1170l);
		u.setRealname("大唐帝国");
		System.out.println(service.update(u));
	}

	@Test
	public void testInsert() {
//		House house=new House();

//		house.setTitle("李云龙大哥你好");
//		house.setPicpath("client/images/house/3.jpg");
//		house.setSummary("亮剑----抗日英雄");
//		house.setContentUrl("http://client/images/house/3.jpg");
//		house.setMenuid(20l);
//		house.setHouseStatus("0");
//		System.out.println(service.save(house));
		
	}

	@Test
	public void testDel() {
		
		System.out.println(service.delete(""+3350));
	}

	@Test
	public void testLogin() {
		System.out.println(service.login("xiaotang", "123456"));
	}

}
