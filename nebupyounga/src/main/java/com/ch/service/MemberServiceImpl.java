package com.ch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.dao.memberDao;
import com.ch.dto.MemberDto;


@Service
public class MemberServiceImpl implements memberService {
	@Autowired
	memberDao mDao;
	
	@Override
	public MemberDto loginCheck(String id, String pw) {
		return mDao.loginCheck(id, pw);
	}

	@Override
	public void signUpMember(String id, String pw, String name) {
		mDao.signUpMember(id, pw, name);
	}

	@Override
	public void butCodingClass(String id, String point) {
		mDao.buyCodingClass(id, point);
	}

	@Override
	public List<MemberDto> selectAllMember() {
		return mDao.selectAllMember();
		
	}

	@Override
	public void idEdit(String id, String pw, String name, String point) {
		mDao.idEditUpdate(id, pw, name, point);
	}

	@Override
	public void deleteId(String id) {
		mDao.DeleteId(id);
	}


}
