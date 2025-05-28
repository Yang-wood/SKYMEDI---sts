package com.medi.sky;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medi.sky.domain.ConsultDTO;
import com.medi.sky.domain.GuestDTO;
import com.medi.sky.domain.MemberDTO;
import com.medi.sky.service.IConsultService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/consult")
public class ConsultController {
	
	@Autowired
	private IConsultService service;
	
	@GetMapping("/check")
	public String chkGet(HttpSession session) {
		log.info("check.........");
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if (login != null) {
			return "redirect:/consult/writer";
		}
		
		return "/consult/check";
	}
	
	@GetMapping("/writer")
	public void writerGet(@ModelAttribute("mDto") MemberDTO mDto, @ModelAttribute("gDto") GuestDTO gDto) {
		log.info("writer Get.........");
	}
	
	@PostMapping("/register")
	public String writerPost(@ModelAttribute ConsultDTO cDto, HttpSession session) {
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		GuestDTO gDto = (GuestDTO)session.getAttribute("guestInfo");
		
		log.info("Consult register....");
		log.info("Title : " + cDto.getTitle());
		log.info("Content : " + cDto.getContent());
		
		
		if (mDto != null) {
			cDto.setMno(mDto.getMno());
			cDto.setUsername(mDto.getUsername());
		} else if (gDto != null) {
			cDto.setGno(gDto.getGno());
			cDto.setG_email(gDto.getG_email());
		}
		try {
			service.register(cDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
}
