package com.medi.sky.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;
import com.medi.sky.persistence.IConsultDAO;

@Repository
public class ConsultDAOImpl implements IConsultDAO {
	@Autowired
	private SqlSession session;
	
	private static final String namespace = "com.medi.sky.consultMapper.";
	
	@Override
	public int register(ConsultDTO cDto) throws Exception {
		return session.insert(namespace + "register", cDto);
	}

	@Override
	public ConsultDTO read(ConsultDTO cDto) throws Exception {
		return session.selectOne(namespace + "read", cDto);
	}

	@Override
	public int update(ConsultDTO cDto) throws Exception {
		return session.update(namespace + "update", cDto);
	}

	@Override
	public int delete(Integer cno) throws Exception {
		return session.delete(namespace + "delete", cno);
	}

	@Override
	public List<ConsultDTO> listByMno(Integer mno) throws Exception {
		return session.selectList(namespace + "listByMno", mno);
	}

	@Override
	public List<ConsultDTO> listByGno(Integer gno) throws Exception {
		return session.selectList(namespace + "listByGno", gno);
	}

}
