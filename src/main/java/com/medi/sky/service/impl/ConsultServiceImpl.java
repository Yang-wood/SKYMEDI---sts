package com.medi.sky.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ConsultDTO read(int cno) throws Exception {
		return dao.read(cno);
	}
	
	@Override
	public int modify(ConsultDTO cDto) throws Exception {
		return dao.update(cDto);
	}

	@Override
	public int remove(int cno) throws Exception {
		return dao.delete(cno);
	}

	@Override
	public List<ConsultDTO> listByMnoWithPaging(int mno, Criteria cri) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("mno", mno);
		map.put("cri", cri);
		return dao.listByMnoWithPaging(map);
	}
	
	@Override
	public int getTotalCntMno(int mno) throws Exception {
		return dao.getTotalCntMno(mno);
	}

	@Override
	public List<ConsultDTO> listByGnoWithPaging(int gno, Criteria cri) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("gno", gno);
		map.put("cri", cri);
		return dao.listByGnoWithPaging(map);
	}
	
	@Override
	public int getTotalCntGno(int gno) throws Exception {
		return dao.getTotalCntGno(gno);
	}

	
}
