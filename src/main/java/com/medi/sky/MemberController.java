package com.medi.sky;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medi.sky.domain.MemberDTO;
import com.medi.sky.service.IMemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private IMemberService service;
	
	@GetMapping("/login")
	public void loginGet() throws Exception {
		log.info("login Get..........");
	}
	
	@GetMapping("/register")
	public void registerGet(MemberDTO mDto) throws Exception {
		log.info("register get..........");
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO mDto) throws Exception {
		log.info("register post........");
		log.info("register : " + mDto);
		
		log.info(mDto.toString());
		service.register(mDto);
		
		return "redirect:/sky/";
	}
	
	@GetMapping("/existID")
	@ResponseBody
	public int existID(@RequestParam("username") String username) throws Exception {
		
		return service.existID(username);
	}
	
}
