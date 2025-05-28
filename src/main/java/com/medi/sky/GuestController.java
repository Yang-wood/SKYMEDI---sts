package com.medi.sky;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medi.sky.domain.GuestDTO;
import com.medi.sky.service.IGuestService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/guest")
public class GuestController {
	@Autowired
	private IGuestService service;
	
	
	@GetMapping("/login")
	public void checkGuest() {
		log.info("Guest Login........");
	};
	
	@PostMapping("/login")
	public String checkGuest(GuestDTO gDto, HttpSession session) {
		GuestDTO guest = service.findGuest(gDto);
		
		if (guest == null) {
			int rs = service.register(gDto);
			if (rs > 0) {
				log.info("guest 등록 성공");
			} else {
				log.info("guest 등록 실패");
			}
			guest = service.findGuest(gDto);
		}
		
		session.setAttribute("guestInfo", guest);
		
		return "redirect:/consult/writer";
	}
}
