package com.medi.sky.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.sky.domain.GuestDTO;
import com.medi.sky.persistence.IGuestDAO;

@Repository
public class GuestDAOImpl implements IGuestDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "com.medi.sky.guestMapper.";
	
	@Override
	public int insert(GuestDTO gDto) throws Exception {
		return sqlsession.insert(namespace + "insert", gDto);
	}

	@Override
	public GuestDTO findGuest(GuestDTO gDto) throws Exception {
		return sqlsession.selectOne(namespace + "findGuest", gDto);
	}

}
