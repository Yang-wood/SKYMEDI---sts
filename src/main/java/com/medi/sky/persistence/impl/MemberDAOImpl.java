package com.medi.sky.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.sky.domain.MemberDTO;
import com.medi.sky.persistence.IMemberDAO;

@Repository
public class MemberDAOImpl implements IMemberDAO{
	
	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "com.medi.sky.memberMapper.";

	@Override
	public int insert(MemberDTO mDto) throws Exception {
		return sqlsession.insert(namespace + "insert", mDto);
	}

	@Override
	public int selectId(String username) throws Exception {
		return sqlsession.selectOne(namespace + "selectId", username);
	}

	@Override
	public MemberDTO login(MemberDTO mDto) throws Exception {
		return sqlsession.selectOne(namespace + "login", mDto);
	}
	
}
