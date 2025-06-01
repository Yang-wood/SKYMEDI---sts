package com.medi.sky;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	@GetMapping("/login")
//	public String loginGet(@ModelAttribute("mDto") MemberDTO mDto, HttpSession session) throws Exception {
//		log.info("login Get..........");
//		session.removeAttribute("dest");
//		if (referer != null && !referer.contains("/login")) {
//	        session.setAttribute("dest", referer);
//	    }
//		Object loginState = session.getAttribute("login");
//		log.info(loginState);
//		if (loginState != null) {
//			return "redirect:/";
//		}
//		return "member/login";
//	}
	
	@PostMapping("/loginPost")
	@ResponseBody
	public Map<String, Object> loginPost(@RequestBody MemberDTO mDto, 
			HttpSession session) throws Exception {
		log.info("Member Login...........");
		Map<String, Object> rs = new HashMap<>();
		
		
		try {
			MemberDTO memInfo = service.login(mDto);
			log.info("memInfo ====> " + memInfo);
			
			if (memInfo == null) {
				rs.put("success", false);
				rs.put("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			} else {
				session.setAttribute("login", memInfo);
				rs.put("success", true);
//				String dest = (String)session.getAttribute("dest");
//				log.info("dest : " + dest);
//				session.removeAttribute("dest");
//				
//				if (dest == null || dest.equals("null") || dest.contains("/login") ) {
//					dest = "/";
//				}
//				rs.put("redirectUrl", dest);
			}
			
		} catch (Exception e) {
			rs.put("success", false);
	        rs.put("message", "서버 오류 발생: " + e.getMessage());
	        e.printStackTrace();
		}
		return rs;
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
	
//	@GetMapping("/register")
//	public String registerGet(@ModelAttribute("mDto") MemberDTO mDto, HttpServletRequest request, HttpSession session) {
//		log.info("register get..........");
//		session.removeAttribute("dest");
//		// 회원가입 페이지 진입 시 현재 URL 저장 (로그인 필요 페이지에서 왔을 경우)
//	    String referer = request.getHeader("Referer");
//	    if (referer != null && !referer.contains("/register")) {
//	        session.setAttribute("dest", referer);
//	    }
//	    return "/member/register";
//	}
	
	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> register(@RequestBody MemberDTO mDto, HttpSession session) {
		log.info("register post........");
		log.info("register : " + mDto);
		
		Map<String, Object> rs = new HashMap<>();
		try {
			int regInfo = service.register(mDto);
			if (regInfo > 0) {
				rs.put("success", true);
				rs.put("message", "회원가입이 완료되었습니다.");
			} else {
				rs.put("success", false);
				rs.put("message", "회원가입에 실패했습니다.");
			}
//			
		} catch (Exception e) {
			rs.put("success", false);
	        e.printStackTrace();
		}
		return rs;
	}
	
	@GetMapping("/existID")
	@ResponseBody
	public int existID(@RequestParam("username") String username) throws Exception {
		
		return service.existID(username);
	}
	
}
