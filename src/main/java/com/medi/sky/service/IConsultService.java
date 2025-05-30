package com.medi.sky.service;

import java.util.List;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;

public interface IConsultService {
	public void register(ConsultDTO cDto) throws Exception;
	public List<ConsultDTO> listByMno(Integer mno) throws Exception;
	public List<ConsultDTO> listByGno(Integer gno) throws Exception;
}
