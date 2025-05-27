package com.medi.sky.persistence;

import com.medi.sky.domain.MemberDTO;

public interface IMemberDAO {
	public int insert(MemberDTO mDto);
	public int selectId(String username);
	public MemberDTO login(MemberDTO mDto);
}
