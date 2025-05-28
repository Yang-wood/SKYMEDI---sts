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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public void loginGet(@ModelAttribute("mDto") MemberDTO mDto) throws Exception {
		log.info("login Get..........");
		
	}
	
	@PostMapping("/login")
	public String loginPost(MemberDTO mDto, HttpSession session, 
			Model model, RedirectAttributes rttr) throws Exception {
		MemberDTO memInfo = service.login(mDto);
		log.info("memInfo ====> " + memInfo);
		
		if (memInfo == null) {
			rttr.addFlashAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/member/login";
		}
		
		model.addAttribute("memInfo", memInfo);
		Object dest = session.getAttribute("dest");
		log.info("dest : " + dest);
		return "/member/loginSuccess";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		log.info("logout..............");
		
		//로그인 정보 삽입
		Object obj = session.getAttribute("login");
		
		if (obj != null) {
			rttr.addFlashAttribute("logoutMsg", "로그아웃되었습니다.");
			//세션 정보 제거
			session.removeAttribute("login");
			//세션 객체 제거
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public void registerGet(MemberDTO mDto, HttpServletRequest request, HttpSession session) throws Exception {
		log.info("register get..........");
		
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
		session.setAttribute("login", mDto);
		
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
