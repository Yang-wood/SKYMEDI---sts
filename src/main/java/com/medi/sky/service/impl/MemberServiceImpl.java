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
	private IMemberDAO mDao;
	
	@Override
	public int insertUser(MemberDTO mDto) throws Exception {
		return mDao.insertUser(mDto);
	}

	@Override
	public int insertGuest(MemberDTO mDto) throws Exception {
		return mDao.insertGuest(mDto);
	}

	@Override
	public int existId(String username) throws Exception {
		return mDao.selectId(username);
	}

	@Override
	public MemberDTO loginUser(MemberDTO mDto) throws Exception {
		return mDao.loginUser(mDto);
	}

	@Override
	public MemberDTO loginGuest(MemberDTO mDto) throws Exception {
		return mDao.loginGuest(mDto);
	}

	@Override
	public MemberDTO searchID(MemberDTO mDto) throws Exception {
		return mDao.searchID(mDto);
	}

	@Override
	public MemberDTO searchPW(MemberDTO mDto) throws Exception {
		return mDao.searchPW(mDto);
	}

	@Override
	public int existEmail(String email) throws Exception {
		return mDao.selectEmail(email);
	}

	

	
}
