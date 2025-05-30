package com.medi.sky;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String loginGet(@ModelAttribute("mDto") MemberDTO mDto, HttpSession session) throws Exception {
		log.info("login Get..........");
		Object loginState = session.getAttribute("login");
		log.info(loginState);
		if (loginState != null) {
			return "redirect:/";
		}
		return "member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(MemberDTO mDto, HttpSession session, 
			Model model, RedirectAttributes rttr) throws Exception {
		try {
			MemberDTO memInfo = service.login(mDto);
			log.info("memInfo ====> " + memInfo);
			
			if (memInfo == null) {
				rttr.addFlashAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return "redirect:/member/login";
			}
			
			model.addAttribute("memInfo", memInfo);
			Object dest = session.getAttribute("dest");
			log.info("dest : " + dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/member/loginSuccess";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		log.info("logout..............");
		
		try {
			//로그인 정보 삽입
			Object obj = session.getAttribute("login");
			
			if (obj != null) {
				rttr.addFlashAttribute("logoutMsg", "로그아웃되었습니다.");
				//세션 정보 제거
				session.removeAttribute("login");
				//세션 객체 제거
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerGet(@ModelAttribute("mDto") MemberDTO mDto, HttpServletRequest request, HttpSession session) {
		log.info("register get..........");
		session.removeAttribute("dest");
		// 회원가입 페이지 진입 시 현재 URL 저장 (로그인 필요 페이지에서 왔을 경우)
	    String referer = request.getHeader("Referer");
	    if (referer != null && !referer.contains("/register")) {
	        session.setAttribute("dest", referer);
	    }
	    return "/member/register";
		
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO mDto, HttpSession session, 
			Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			log.info("register post........");
			log.info("register : " + mDto);
			
			log.info(mDto.toString());
			int regInfo = service.register(mDto);
			if (regInfo == 0) {
				return "redirect:/member/register";
			}
			session.setAttribute("login", mDto);
			
			String dest = (String)session.getAttribute("dest");
			log.info("Original dest : " + dest);
			session.removeAttribute("dest");
			
			if (dest == null || dest.isEmpty()) {
				dest = request.getHeader("Referer");
			}
			
			if (dest == null || dest.contains("/register") || dest.contains("/login")) {
				dest = "/";
			}
			try {
				URI uri = new URI(dest);
				if (!uri.getHost().equals(request.getServerName())) {
					dest = "/";
				}
			} catch (Exception e) {
				dest = "/";
			}
			return "redirect:" + dest;
		} catch (Exception e) {
			log.error("Registration failed", e);
			return "redirect:/member/register";
		}
	}
	
	@GetMapping("/existID")
	@ResponseBody
	public int existID(@RequestParam("username") String username) throws Exception {
		
		return service.existID(username);
	}
	
}
