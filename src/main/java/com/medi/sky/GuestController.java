package com.medi.sky;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping("/loginPost")
	public String loginPost( GuestDTO gDto, HttpSession session) {
		
		log.info("Guest register........");
		try {
			GuestDTO guest = service.findGuest(gDto);
			if (guest == null) {
				int rs = service.register(gDto);
				if (rs > 0) {
					log.info("guest 등록 성공");
				} else {
					log.info("guest 등록 실패");
				}
				guest = service.findGuest(gDto);
				session.setAttribute("guestInfo", guest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/consult/writer";
	}
	
	@PostMapping ("/findPost")
	public String findPost(GuestDTO gDto, HttpSession session) {
		log.info("find Guest..........");
		try {
			GuestDTO guestInfo = service.findGuest(gDto);
			log.info("guestInfo =====>" + guestInfo);
			if (guestInfo == null ) {
				
			}
			session.setAttribute("guestInfo", guestInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/consult/list";
	}
}
