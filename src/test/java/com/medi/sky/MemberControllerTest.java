package com.medi.sky;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.medi.sky.domain.MemberDTO;
import com.medi.sky.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration

public class MemberControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Autowired
	private MemberMapper mapper;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//Mock 방식으로 회원 입력
//	@Test
//	public void testRegister() throws Exception {
//		try {
//			String rs =  mockMvc.perform(MockMvcRequestBuilders.post("/member/register")
//					.param("username", "test11")
//					.param("password", "test11")
//					.param("name", "test11")
//					.param("email", "test11@test.com"))
//					.andReturn().getResponse().getRedirectedUrl();
//			
//			if (rs != null) {
//				log.info("등록 성공");
//			} else {
//				log.info("등록 실패");
//			}
//		} catch (Exception e) {
//			log.error("에러", e);
//		}
//	}
	
	//테스트 회원 정보 반복 입력
//	@Test
//	public void testRepeatReg() throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		MemberDTO mDto = new MemberDTO();
//		
//		IntStream.rangeClosed(2, 10).forEach(i -> {
//			
//			try {
//				mDto.setUsername("test" + i);
//				mDto.setPassword("test" + i);
//				mDto.setName("test" + i);
//				String day = (i < 10) ? "0" + i : String.valueOf(i);
//				Date date = sdf.parse("2000-01-" + day);
//				mDto.setBirth_date(date);
//				mDto.setPhone("0101234567" + i);
//				mDto.setEmail("test" + i + "@test.com");
//				int rs = mapper.insertMember(mDto);
//				if (rs > 0) {
//					log.info("등록 성공");
//				} else {
//					log.info("등록 실패");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//	}
	
	// 아이디 중복 테스트
	@Test
	public void testExistID() throws Exception {
		String name = "test10";
		
		String rs = mockMvc.perform(MockMvcRequestBuilders.get("/member/existID")
				.param("username", name))
		.andReturn().getResponse().getContentAsString();
		
		if (rs.equals("1")) {
			log.info("아이디 있음");
		} else {
			log.info("아이디 없음");
		}
	}

}
