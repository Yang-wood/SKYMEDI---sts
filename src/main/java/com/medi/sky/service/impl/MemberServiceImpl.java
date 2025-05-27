package com.medi.sky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medi.sky.domain.MemberDTO;
import com.medi.sky.mapper.MemberMapper;
import com.medi.sky.persistence.IMemberDAO;
import com.medi.sky.service.IMemberService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	private IMemberDAO dao;
	
	@Override
	@Transactional
	public int register(MemberDTO memberDto) {
		return dao.insert(memberDto);
	}

	@Override
	public int existID(String username) {
		return dao.selectId(username);
	}

	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		return dao.login(memberDTO);
	}

	
}
