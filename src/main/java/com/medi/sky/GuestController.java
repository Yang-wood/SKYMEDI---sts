package com.medi.sky;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String loginPost(GuestDTO gDto, HttpSession session) {
		
		log.info("Guest register........");
		try {
			GuestDTO guest = service.findGuest(gDto);
			log.info("findGuest result: " + guest);
			if (guest == null) {
				int rs = service.register(gDto);
				if (rs > 0) {
					log.info("guest 등록 성공");
					guest = service.findGuest(gDto);
				} else {
					log.error("guest 등록 실패");
				}
			}
			session.setAttribute("guestInfo", guest);
			log.info("guestInfo : " + session.getAttribute("guestInfo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/consult/writer";
	}
	
	@PostMapping ("/findPost")
	@ResponseBody
	public Map<String, Object> findPost(@RequestBody GuestDTO gDto, HttpSession session) {
		log.info("find Guest..........");
		
		Map<String, Object> rs = new HashMap<>();
		
		try {
			GuestDTO guestInfo = service.findGuest(gDto);
			log.info("guestInfo =====>" + guestInfo);
			if (guestInfo != null ) {
				session.setAttribute("guestInfo", guestInfo);
				rs.put("success", true);
				rs.put("message", "비회원으로 로그인하였습니다.");
				rs.put("redirectUrl", "/consult/list");
			} else {
				rs.put("success", false);
				rs.put("message", "이메일 또는 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			rs.put("success", false);
	        rs.put("message", "서버 오류 발생: " + e.getMessage());
	        e.printStackTrace();
		}
		return rs;
	}
}
