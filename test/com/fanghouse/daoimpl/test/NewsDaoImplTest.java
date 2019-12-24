package com.fanghouse.daoimpl.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fanghouse.dao.NewsDao;
import com.fanghouse.dao.impl.NewsDaoImpl;
import com.fanghouse.entity.News;



@SuppressWarnings("unused")
public class NewsDaoImplTest {
	private NewsDao dao=null;
	@Before
	public void init(){
		dao=new	NewsDaoImpl();
	}

	@Test
	public void testFindAll() {
		//dao.findAll().forEach(System.out::println);
		
		dao.findBymenuId(11l).forEach(System.out::println);
	}

	@Test
	public void testFindById() {

		System.out.println(dao.findById(7l));
	}

	@Test
	public void testFindPageAll() {
		dao.findPageAll("title", "人", 2, 3).forEach(System.out::println);
			
	}

	@Test
	public void testGetCount() {
		System.out.println(dao.getCount("title", "人"));
	}

	@Test
	public void testUpdate() {
		News news=dao.findById(2220l);
		news.setTitle("北约峰会上各成员国");
		news.setContentUrl("client/images/4.jpeg");
		news.setPublishTime(new Date());
		news.setPicpath	("client/images/4.jpeg");
		news.setMenuid(13l);
		news.setSummary("年的北约峰会上各成员国之间频频上演“口水仗”，彼此间的矛盾日益凸显");
		news.setNewStatus("1");
		System.out.println(dao.update(news));
		
	}

	@Test
	public void testInsert() {
		News news=new News();
		news.setTitle("北约峰会上各成员国");
		news.setContentUrl("client/images/4.jpeg");
		news.setPublishTime(new Date());
		news.setPicpath	("client/images/4.jpeg");
		news.setMenuid(13l);
		news.setSummary("年的北约峰会上各成员国之间频频上演“口水仗”，彼此间的矛盾日益凸显");
		news.setNewStatus("1");
		System.out.println(dao.insert(news));
		
	}

	@Test
	public void testDel() {
		
		System.out.println(dao.del(2220l));
	}
	
	@Test
	public void findBymenuId(){
		dao.findBymenuId(13l).forEach(System.out::println);
	}
}
