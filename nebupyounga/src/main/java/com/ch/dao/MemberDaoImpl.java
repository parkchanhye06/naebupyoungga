package com.ch.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.dto.MemberDto;
@Repository
public class MemberDaoImpl implements memberDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public MemberDto loginCheck(String id, String pw) {
		HashMap<String,String> Map1 = new HashMap<>();
		Map1.put("id", id);
		Map1.put("pw", pw);
		return sqlSession.selectOne("MemberMapper.login_check",Map1);
	}

	@Override
	public void signUpMember(String id, String pw, String name) {
		HashMap<String,String> Map1 = new HashMap<>();
		Map1.put("id",id);
		Map1.put("pw",pw);
		Map1.put("name",name);
		sqlSession.insert("MemberMapper.signUpMember",Map1);
		
	}

	@Override
	public void buyCodingClass(String id, String point) {
		HashMap<String,String> Map1 = new HashMap<>();
		Map1.put("id", id);
		Map1.put("point", point);
		sqlSession.update("MemberMapper.but_coding_class",Map1);
	}

	@Override
	public List<MemberDto> selectAllMember() {
		return sqlSession.selectList("MemberMapper.select_all_member");
	}

	@Override
	public void idEditUpdate(String id, String pw, String name, String point) {
		HashMap<String,String> Map1 = new HashMap<>();
		Map1.put("id", id);
		Map1.put("pw", pw);
		Map1.put("name", name);
		Map1.put("point", point);
		sqlSession.update("MemberMapper.idEdit",Map1);
	
	}

	@Override
	public void DeleteId(String id) {
		sqlSession.delete("MemberMapper.delete_id",id);
	}

	@Override
	public int scheduler() {
	return 	sqlSession.update("MemberMapper.scheduler");
	}
	

}
