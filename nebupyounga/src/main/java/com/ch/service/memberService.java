package com.ch.service;

import java.util.List;

import com.ch.dto.MemberDto;

public interface memberService {
	MemberDto loginCheck(String id,String pw);
	void signUpMember(String id,String pw,String name);
	void butCodingClass(String id,String point);
	List<MemberDto> selectAllMember();
	void idEdit(String id,String pw,String name,String point);
	void deleteId(String id);
}
	
