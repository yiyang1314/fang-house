package com.fanghouse.daoimpl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fanghouse.dao.UserDao;
import com.fanghouse.dao.impl.UserDaoImpl;
import com.fanghouse.entity.User;




@SuppressWarnings("unused")
public class UserDaoImplTest {

	private UserDao dao=null;
	@Before
	public void init(){
		dao=new	UserDaoImpl();
	}
	
	
	@Test
	public void testFindAll() {
		dao.findAll().forEach(System.out::println);
	}

	@Test
	public void testFindById() {

		System.out.println(dao.findById(1170l));
	}

	@Test
	public void testFindPageAll() {
		dao.findPageAll("loginname", "n", 3, 1).forEach(System.out::println);
			
	}

	@Test
	public void testGetCount() {
		System.out.println(dao.getCount("loginname", "n"));
	}

	@Test
	public void testUpdate() {
		User user=dao.findById(1250l);
		user.setLoginname("xiangyu");
		System.out.println(dao.update(user));
		
	}

	@Test
	public void testInsert() {
		User user=new User();
		user.setLoginname("jiangzhiqing");
		user.setLoginpwd("123456");
		user.setRealname("江小青");
		System.out.println(dao.insert(user));
		
	}

	@Test
	public void testDel() {
		
		System.out.println(dao.del(2222l));
	}

	@Test
	public void testLogin() {
		
		System.out.println(dao.login("tangyi", "123456"));
	}

}
