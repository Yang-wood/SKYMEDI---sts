package com.medi.sky.persistence.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ConsultDTO read(int cno) throws Exception {
		return session.selectOne(namespace + "read", cno);
	}

	@Override
	public int update(ConsultDTO cDto) throws Exception {
		return session.update(namespace + "update", cDto);
	}

	@Override
	public int delete(int cno) throws Exception {
		return session.delete(namespace + "delete", cno);
	}

	@Override
	public List<ConsultDTO> listByMnoWithPaging(Map<String, Object> params) throws Exception {
		return session.selectList(namespace + "listByMnoWithPaging", params);
	}
	
	@Override
	public int getTotalCntMno(int mno) throws Exception {
		return session.selectOne(namespace + "getTotalCntMno", mno);
	}

	@Override
	public List<ConsultDTO> listByGnoWithPaging(Map<String, Object> params) throws Exception {
		return session.selectList(namespace + "listByGnoWithPaging", params);
	}
	
	@Override
	public int getTotalCntGno(int gno) throws Exception {
		return session.selectOne(namespace + "getTotalCntGno", gno);
	}

}
