package com.medi.sky.persistence;

import com.medi.sky.domain.MemberDTO;

public interface IMemberDAO {
	public int insertUser(MemberDTO mDto) throws Exception;
	public int insertGuest(MemberDTO mDto) throws Exception;
	public int delete(int mno) throws Exception;
	public int update(MemberDTO mDto) throws Exception;
	public int selectId(String username) throws Exception;
	public MemberDTO loginUser(MemberDTO mDto) throws Exception;
	public MemberDTO loginGuest(MemberDTO mDto) throws Exception;
	public MemberDTO searchID(MemberDTO mDto) throws Exception;
	public MemberDTO searchPW(MemberDTO mDto) throws Exception;
	public int selectEmail(String email) throws Exception;
}
