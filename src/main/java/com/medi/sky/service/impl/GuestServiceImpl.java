package com.medi.sky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.sky.domain.GuestDTO;
import com.medi.sky.persistence.IGuestDAO;
import com.medi.sky.service.IGuestService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class GuestServiceImpl implements IGuestService {
	@Autowired
	private IGuestDAO dao;
	
	@Override
	public int register(GuestDTO gDto) {
		return dao.insert(gDto);
	}

	@Override
	public GuestDTO findGuest(GuestDTO gDto) {
		return dao.findGuest(gDto);
	}

}
