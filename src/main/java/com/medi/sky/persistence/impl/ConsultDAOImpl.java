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
	public List<ConsultDTO> listAll(Criteria cri) throws Exception {
		return session.selectList(namespace + "listAll", cri);
	}

}
