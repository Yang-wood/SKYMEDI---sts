package com.medi.sky.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;
import com.medi.sky.persistence.IConsultDAO;
import com.medi.sky.service.IConsultService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ConsultServiceImpl implements IConsultService{
	@Autowired
	private IConsultDAO dao;
	
	@Override
	public void register(ConsultDTO cDto) throws Exception {
		dao.register(cDto);
	}

	@Override
	public List<ConsultDTO> listByMno(Integer mno) throws Exception {
		return dao.listByMno(mno);
	}

	@Override
	public List<ConsultDTO> listByGno(Integer gno) throws Exception {
		return dao.listByGno(gno);
	}
	
}
