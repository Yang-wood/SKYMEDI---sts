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
	public int selectId(String username) throws Exception {
		return sqlsession.selectOne(namespace + "selectId", username);
	}

	@Override
	public int delete(int mno) throws Exception {
		return sqlsession.delete(namespace + "delete", mno);
	}

	@Override
	public int update(MemberDTO mDto) throws Exception {
		return sqlsession.update(namespace + "update", mDto);
	}

	@Override
	public int insertUser(MemberDTO mDto) throws Exception {
		return sqlsession.insert(namespace + "insertUser", mDto);
	}

	@Override
	public int insertGuest(MemberDTO mDto) throws Exception {
		return sqlsession.insert(namespace + "insertGuest", mDto);
	}

	@Override
	public MemberDTO loginUser(MemberDTO mDto) throws Exception {
		return sqlsession.selectOne(namespace + "loginUser", mDto);
	}

	@Override
	public MemberDTO loginGuest(MemberDTO mDto) throws Exception {
		return sqlsession.selectOne(namespace + "loginguest", mDto);
	}

	@Override
	public MemberDTO searchID(MemberDTO mDto) throws Exception {
		return sqlsession.selectOne(namespace + "searchID", mDto);
	}

	@Override
	public MemberDTO searchPW(MemberDTO mDto) throws Exception {
		return sqlsession.selectOne(namespace + "searchPW", mDto);
	}

	@Override
	public int selectEmail(String email) throws Exception {
		return sqlsession.selectOne(namespace + "selectEmail", email);
	}

	
	
}
