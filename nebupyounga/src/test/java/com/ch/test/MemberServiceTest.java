package com.ch.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ch.dto.MemberDto;
import com.ch.service.memberService;

@RunWith(SpringJUnit4ClassRunner.class) // ->"이테으트는 스프링과 함계 실행하겠다"
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	@Autowired
	memberService mSvc;
	
	@Test
	public void TestloginCheck() {
		//1.Given
		String id = "chan";
		String pw = "ch";
		//2.When
		MemberDto mDto = mSvc.loginCheck(id, pw);
		//3.Then
		System.out.println(mDto.getId()+","+mDto.getPw()+","+mDto.getRole());
	}
	@Test
	public void TestBuyCodingClass() {
		//1.Given
		String id = "chan";
		String point = "1500";
		//2.When
		mSvc.butCodingClass(id, point);
		//3.Then
	}
	@Test
	public void TestidEdit() {
		//1.Given
		String id = "chan";
		String pw = "cc";
		String name = "찬혜맞음";
		String point = "150";
		//2.When
		mSvc.idEdit(id, pw, name, point);
		//3.Then
		
	}
	@Test
	public void TestDeleteId() {
		//1.Given
		String id ="ㅂㅂㅂㅊㅊㅊ";
		//2.When
		mSvc.deleteId(id);
		//3.Then
		
		
		
	}
	
	
}
