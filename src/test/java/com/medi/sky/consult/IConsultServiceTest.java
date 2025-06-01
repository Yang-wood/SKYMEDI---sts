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
import com.medi.sky.service.IConsultService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class IConsultServiceTest {
	@Autowired
	private IConsultService service;
	
//	@Test
//	public void testList() throws Exception {
//		int mno = 48;
//		Criteria cri = new Criteria();
//		cri.setPageNum(2);
//		cri.setAmount(10);
//		
//		log.info("startRow: " + cri.getStartRow());
//        log.info("endRow: " + cri.getEndRow());
//        
//        List<ConsultDTO> list = service.listByMnoWithPaging(mno, cri);
//
//        for (ConsultDTO dto : list) {
//            log.info(dto);
//        }
//	}

	@Test
	public void testList() throws Exception {
		int gno = 21;
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);
		
		log.info("startRow: " + cri.getStartRow());
		log.info("endRow: " + cri.getEndRow());
		
		List<ConsultDTO> list = service.listByGnoWithPaging(gno, cri);
		
		for (ConsultDTO dto : list) {
			log.info(dto);
		}
	}
}
