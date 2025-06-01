package com.medi.sky.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;

public interface IConsultService {
	public void register(ConsultDTO cDto) throws Exception;
	public int modify(ConsultDTO cDto) throws Exception;
	public int remove(int cno) throws Exception;
	public ConsultDTO read(int cno) throws Exception;
	public List<ConsultDTO> listByMnoWithPaging(int mno , Criteria cri) throws Exception;
	public int getTotalCntMno(int mno) throws Exception;
	public List<ConsultDTO> listByGnoWithPaging(int gno , Criteria cri) throws Exception;
	public int getTotalCntGno(int gno) throws Exception;
}
