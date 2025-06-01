package com.medi.sky.consult;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.GuestDTO;
import com.medi.sky.domain.MemberDTO;
import com.medi.sky.member.MemberControllerTest;
import com.medi.sky.service.IConsultService;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class ConsultControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	@Autowired
	private IConsultService service;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testRegister() throws Exception {
//		String rs =  mvc.perform(MockMvcRequestBuilders.post("/consult/register")
//				.param("mno", "1").param("username", "user01")
//				.param("title", "제목 테스트").param("content", "내용 테스트"))
//				.andReturn().getModelAndView().getViewName();
//		
//		if (rs != null) {
//			log.info("등록 성공");
//		} else {
//			log.info("등록 실패");
//		}
//	}
	
	// 반복 등록 테스트
//	@Test
//	public void testRepeatReg() throws Exception {
//		
//		IntStream.rangeClosed(101, 10000).forEach(i -> {
//			ConsultDTO cDto = new ConsultDTO();
//			
//			try {
//				cDto.setMno(48);
//				cDto.setUsername("test1");
//				cDto.setTitle("페이징 테스트" + i);
//				cDto.setContent("페이징 내용 연습" + i);
//				service.register(cDto);
//				log.info("등록 성공" + i);
//			} catch (Exception e) {
//				e.printStackTrace();
//				fail("등록 중 예외 발생" + e.getMessage());
//			}
//		});
//	}
	
//	@Test
//	public void testList() throws Exception {
//		MemberDTO mDto = new MemberDTO();
//		mDto.setMno(48);
//		
//		MvcResult re = mvc.perform(MockMvcRequestBuilders.get("/consult/list")
//				.sessionAttr("login", mDto)
//				.param("pageNum", "2").param("amount", "10"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andReturn();
//		
//		String rs = re.getModelAndView().getViewName();
//		log.info(rs);
//	}
	
	@Test
	public void testList() throws Exception {
		GuestDTO gDto = new GuestDTO();
		gDto.setGno(21);
		
		MvcResult re = mvc.perform(MockMvcRequestBuilders.get("/consult/list")
				.sessionAttr("guestInfo", gDto)
				.param("pageNum", "1").param("amount", "10"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String rs = re.getModelAndView().getViewName();
		log.info(rs);
	}
	
//	@Test
//	public void testRead() throws Exception {
//		MemberDTO mDto = new MemberDTO();
//		mDto.setMno(1);
//		
//		mvc.perform(MockMvcRequestBuilders.get("/consult/read")
//				.sessionAttr("login", mDto)
//				.param("cno", "25").param("pageNum", "1").param("amount", "10"))
//				.andDo(MockMvcResultHandlers.print());
		
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.model().attributeExists("consult"))
//				.andDo(MockMvcResultHandlers.print());
//	}
}
