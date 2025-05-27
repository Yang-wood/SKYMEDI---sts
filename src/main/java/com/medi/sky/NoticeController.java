package com.medi.sky;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/center")
public class NoticeController {
	
	@GetMapping("/notice")
	public void testget() {
		log.info("공지");
	}
	
}
