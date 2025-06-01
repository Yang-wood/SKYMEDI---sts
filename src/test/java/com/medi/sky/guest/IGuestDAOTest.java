package com.medi.sky.guest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medi.sky.domain.GuestDTO;
import com.medi.sky.persistence.IGuestDAO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class IGuestDAOTest {
	@Autowired
	private IGuestDAO gDao;
	
//	@Test
//	public void testInsert() throws Exception {
//		GuestDTO gDto = new GuestDTO();
//		gDto.setG_email("test11");
//		gDto.setG_password("1234");
//		
//		gDao.insert(gDto);
//	}
	
	@Test
	public void testFind() throws Exception {
		GuestDTO gDto = new GuestDTO();
		gDto.setG_email("test11");
		gDto.setG_password("1234");
		
		GuestDTO rs = gDao.findGuest(gDto);
		log.info(rs);
	}

}
