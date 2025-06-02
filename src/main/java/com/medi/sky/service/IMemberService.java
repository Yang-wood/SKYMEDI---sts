package com.medi.sky.service;

import com.medi.sky.domain.MemberDTO;

public interface IMemberService {
	public int insertUser(MemberDTO mDto) throws Exception;
	public int insertGuest(MemberDTO mDto) throws Exception;
	public int existId(String username) throws Exception;
	public MemberDTO loginUser(MemberDTO mDto) throws Exception;
	public MemberDTO loginGuest(MemberDTO mDto) throws Exception;
	public MemberDTO searchID(MemberDTO mDto) throws Exception;
	public MemberDTO searchPW(MemberDTO mDto) throws Exception;
	public int existEmail(String email) throws Exception;
}
