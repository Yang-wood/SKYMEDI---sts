package com.medi.sky.consult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.Criteria;
import com.medi.sky.persistence.IConsultDAO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class IConsultDAOTest {
	@Autowired
	private IConsultDAO cDao;
	
//	@Test
//	public void testRegister() {
//		ConsultDTO cDto = new ConsultDTO();
//		cDto.setTitle("asdgasfgasfg"); cDto.setContent("aerawerawegsfgdfsg");
//		cDto.setUsername("user01"); cDto.setMno(1);
//		try {
//			cDao.register(cDto);
//			log.info(cDto.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testRead() {
//		try {
//			log.info(cDao.read(4).toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testUpdate() throws Exception {
//		ConsultDTO cDto = new ConsultDTO();
//		cDto.setCno(27); cDto.setTitle("DAO 테스트"); cDto.setContent("DAO 테스트");
//		cDao.update(cDto);
//		log.info("수정 결과 : " + cDto);
//	}
	
//	@Test
//	public void testDelete() throws Exception {
//		int rs = cDao.delete(27);
//		if (rs > 0) {
//			log.info("삭제 성공");
//		} else {
//			log.info("삭제 실패");
//		}
//	}
	
//	@Test
//	public void testListMno() throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		Criteria cri = new Criteria();
//		cri.setPageNum(2);
//		cri.setAmount(10);
//		
//		int testMno = 48;
//		
//		map.put("mno", testMno);
//		map.put("cri", cri);
//		
//		List<ConsultDTO> list = cDao.listByMnoWithPaging(map);
//		
//		for (ConsultDTO consultDTO : list) {
//			log.info(consultDTO.toString());
//		}
//	}
	
	@Test
	public void testListGno() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);
		
		int testGno = 21;
		
		map.put("gno", testGno);
		map.put("cri", cri);
		
		List<ConsultDTO> list = cDao.listByGnoWithPaging(map);
		
		for (ConsultDTO consultDTO : list) {
			log.info(consultDTO.toString());
		}
	}
	
//	@Test
//	public void testTotalMno() throws Exception {
//		int rs =  cDao.getTotalCntMno(48);
//		log.info("글 수 : " + rs);
//	}

}
