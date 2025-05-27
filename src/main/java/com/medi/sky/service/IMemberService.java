package com.medi.sky.service;

import com.medi.sky.domain.MemberDTO;

public interface IMemberService {
	public int register(MemberDTO memberDto);
	public int existID(String username);
	public MemberDTO login(MemberDTO memberDTO);
}
