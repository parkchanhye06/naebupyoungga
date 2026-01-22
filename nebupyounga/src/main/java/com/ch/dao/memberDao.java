package com.ch.dao;

import java.util.List;

import com.ch.dto.MemberDto;

public interface memberDao {
	MemberDto loginCheck(String id,String pw);	//로그인확인
	void signUpMember(String id,String pw,String name); //회원가입
	void buyCodingClass(String id,String point);//(코딩 클레스 구매)point 업데이트
	List<MemberDto> selectAllMember();
	void idEditUpdate(String id,String pw,String name,String point);
	void DeleteId(String id);
	int scheduler();
}
