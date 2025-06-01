package com.medi.sky.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;

public interface IConsultDAO {
	public int register(ConsultDTO cDto) throws Exception;
	public ConsultDTO read(int cno) throws Exception;
	public int update(ConsultDTO cDto) throws Exception;
	public int delete(int cno) throws Exception;
	public List<ConsultDTO> listByMnoWithPaging(Map<String, Object> params) throws Exception;
	public int getTotalCntMno(int mno) throws Exception;
	public List<ConsultDTO> listByGnoWithPaging(Map<String, Object> params) throws Exception;
	public int getTotalCntGno(int gno) throws Exception;
	
}
