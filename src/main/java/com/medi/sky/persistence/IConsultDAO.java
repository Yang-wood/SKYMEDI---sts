package com.medi.sky.persistence;

import java.util.List;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;

public interface IConsultDAO {
	public int register(ConsultDTO cDto) throws Exception;
	public ConsultDTO read(ConsultDTO cDto) throws Exception;
	public int update(ConsultDTO cDto) throws Exception;
	public int delete(Integer cno) throws Exception;
	public List<ConsultDTO> listByMno(Integer mno) throws Exception;
	public List<ConsultDTO> listByGno(Integer gno) throws Exception;
}
