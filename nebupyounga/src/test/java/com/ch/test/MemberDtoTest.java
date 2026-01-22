package com.ch.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ch.dao.memberDao;
import com.ch.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class) // ->"이테으트는 스프링과 함계 실행하겠다"
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDtoTest {
	@Autowired
	memberDao mDao;
	
	@Test
	public void TestLoginCheck() {
		//1.Given
		String id = "chan";
		String pw  = "ch";
		//2.When
		MemberDto mDto = mDao.loginCheck(id, pw);
		//3.Then
		System.out.println(mDto.getId()+","+mDto.getPw()+","+ mDto.getRole());
	}
	@Test
	public void TestsignUpMember() {
		//1.Given
		String id = "chanchan";
		String pw = "chch";
		String name = "찬찬";
		
		//2.When
		mDao.signUpMember(id, pw, name);
		//3.Then
	}
	@Test
	public void TestBuyCodingClass() {
		//1.Given
		String id = "chan";
		String point = "2000";
		
		//2.When
		mDao.buyCodingClass(id, point);
		
		//3.Then
	}
	@Test
	public void TestIdEdit() {
		//1.Given
		String id = "chan";
		String pw  = "ch";
		String name = "찬혜아님";
		String point = "200";
		
		//2.When
		mDao.idEditUpdate(id, pw, name, point);
		//3.Then
	}
	@Test
	public void TestDeleteid() {
		//1.Given
		String id = "chan";
		//2.When
		mDao.DeleteId(id);
		//3.Then
	}
	@Test
	public void TestScheduler() {
		//2.When
		mDao.scheduler();
		
	}
	
	
	
}
