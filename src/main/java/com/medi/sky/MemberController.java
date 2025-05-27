package com.medi.sky;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void registerGet(MemberDTO mDto, HttpServletRequest request, HttpSession session) throws Exception {
		log.info("register get..........");
		
		String referer = request.getHeader("Referer");
		log.info("preHost :: " + referer);
		
		if (referer != null && !referer.contains("member/register")) {
			session.setAttribute("dest", referer);
			log.info("save Host : " + referer);
		}
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO mDto, HttpSession session, Model model) throws Exception {
		log.info("register post........");
		log.info("register : " + mDto);
		
		log.info(mDto.toString());
		int regInfo = service.register(mDto);
		if (regInfo == 0) {
			return "redirect:/member/register";
		}
		String dest = (String)session.getAttribute("dest");
		if (dest == null || dest.equals("null")) {
			dest = "/";
		}
		
		return "redirect:" + dest;
	}
	
	@GetMapping("/existID")
	@ResponseBody
	public int existID(@RequestParam("username") String username) throws Exception {
		
		return service.existID(username);
	}
	
}
