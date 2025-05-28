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
	public int register(ConsultDTO cDto) {
		log.info("register.........");
		return dao.register(cDto);
	}

	@Override
	public List<ConsultDTO> listAll(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
