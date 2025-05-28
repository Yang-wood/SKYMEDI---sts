package com.medi.sky.service;

import java.util.List;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;

public interface IConsultService {
	public int register(ConsultDTO cDto) throws Exception;
	public List<ConsultDTO> listAll(Criteria cri) throws Exception;
}
