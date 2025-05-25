package com.medi.sky.mapper;

import com.medi.sky.domain.MemberDTO;

public interface MemberMapper {
	public int insertMember(MemberDTO memberDTO);
	public int existId(String username);
}
