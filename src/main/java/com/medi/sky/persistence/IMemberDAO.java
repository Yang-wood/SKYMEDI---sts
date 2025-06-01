package com.medi.sky.persistence;

import com.medi.sky.domain.MemberDTO;

public interface IMemberDAO {
	public int insert(MemberDTO mDto) throws Exception;
	public int delete(int mno) throws Exception;
	public int update(MemberDTO mDto) throws Exception;
	public int selectId(String username) throws Exception;
	public MemberDTO login(MemberDTO mDto) throws Exception;
}
