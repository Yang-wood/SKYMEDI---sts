package com.medi.sky.service;

import com.medi.sky.domain.MemberDTO;

public interface IMemberService {
	public void register(MemberDTO memberDto);
	public int existID(String username);
}
