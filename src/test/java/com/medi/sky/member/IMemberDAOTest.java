package com.medi.sky.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.sky.domain.MemberDTO;
import com.medi.sky.persistence.IMemberDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class IMemberDAOTest {
	@Autowired
	private IMemberDAO idao;
	
//	@Test
//	public void testInsert() throws Exception {
//		MemberDTO mDto = new MemberDTO();
//		
//		mDto.setUsername("test1"); mDto.setPassword("test1");
//		mDto.setEmail("test1@naver.com"); mDto.setName("test1");
//		
//		idao.insert(mDto);
//		log.info(mDto.toString());
//	}
	
//	@Test
//	public void testDelete() throws Exception {
//		int rs =  idao.delete(41);
//		if (rs > 0) {
//			log.info("삭제 성공");
//		} else {
//			log.info("삭제 실");
//		}
//	}
	
//	@Test
//	public void testDelete() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		
//		memberDTO.setMno(42);
//		memberDTO.setName("test");
//		idao.update(memberDTO);
//	}
	
//	@Test
//	public void testSelId() throws Exception {
//		 int rs = idao.selectId("test24");
//		 if (rs > 0) {
//			log.info("있는 아이디");
//		} else {
//			log.info("없는 아이디");
//		}
//	}
	
//	@Test
//	public void testLogin() throws Exception {
//		MemberDTO mDto = new MemberDTO();
//		mDto.setUsername("test1");
//		mDto.setPassword("test12");
//		if (idao.login(mDto) != null) {
//			log.info("로그인 성공");
//		} else {
//			log.info("로그인 실패");
//		}
//	}
	

}
