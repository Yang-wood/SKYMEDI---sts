package com.medi.sky.service;

import com.medi.sky.domain.MemberDTO;

public interface IMemberService {
	public int register(MemberDTO memberDto) throws Exception;
	public int existID(String username) throws Exception;
	public MemberDTO login(MemberDTO memberDTO) throws Exception;
}
