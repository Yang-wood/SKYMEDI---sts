package com.medi.sky;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.medi.sky.domain.GuestDTO;
import com.medi.sky.domain.MemberDTO;
import com.medi.sky.service.IMemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private IMemberService service;
	
	@PostMapping("/loginUser")
	@ResponseBody
	public Map<String, Object> loginUser(@RequestBody MemberDTO mDto, 
			HttpSession session) throws Exception {
		log.info("Member Login...........");
		Map<String, Object> rs = new HashMap<>();
		
		
		try {
			MemberDTO memInfo = service.loginUser(mDto);
			log.info("memInfo ====> " + memInfo);
			
			if (memInfo == null) {
				rs.put("success", false);
				rs.put("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			} else {
				session.setAttribute("login", memInfo);
				rs.put("success", true);
			}
			
		} catch (Exception e) {
			rs.put("success", false);
	        rs.put("message", "서버 오류 발생: " + e.getMessage());
	        e.printStackTrace();
		}
		return rs;
	}
	
	@PostMapping("/loginGuest")
	@ResponseBody
	public Map<String, Object> loginGuest(@RequestBody MemberDTO mDto, 
			HttpSession session) throws Exception {
		log.info("Member Login...........");
		Map<String, Object> rs = new HashMap<>();
		
		
		try {
			MemberDTO guestInfo = service.loginGuest(mDto);
			log.info("memInfo ====> " + guestInfo);
			
			if (guestInfo == null) {
				rs.put("success", false);
				rs.put("message", "이메일 또는 비밀번호가 일치하지 않습니다.");
			} else {
				session.setAttribute("guestInfo", guestInfo);
				rs.put("success", true);
				rs.put("message", "비회원으로 로그인하였습니다.");
				rs.put("redirectUrl", "/consult/list");
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
			Object mem = session.getAttribute("login");
			Object guest = session.getAttribute("guestInfo");
			
			
			if (mem != null) {
				rttr.addFlashAttribute("logoutMsg", "로그아웃되었습니다.");
				//세션 정보 제거
				session.removeAttribute("login");
				//세션 객체 제거
				session.invalidate();
			}
			if (guest != null) {
				rttr.addFlashAttribute("logoutMsg", "로그아웃되었습니다.");
				//세션 정보 제거
				session.removeAttribute("guestInfo");
				//세션 객체 제거
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@PostMapping("/insertUser")
	@ResponseBody
	public Map<String, Object> insertUser(@RequestBody MemberDTO mDto, HttpSession session) {
		log.info("insertUser post........");
		log.info("insertUser : " + mDto);
		
		Map<String, Object> rs = new HashMap<>();
		try {
			int regInfo = service.insertUser(mDto);
			if (regInfo > 0) {
				rs.put("success", true);
				rs.put("message", "회원가입이 완료되었습니다.");
			} else {
				rs.put("success", false);
				rs.put("message", "회원가입에 실패했습니다.");
			}
		
		} catch (Exception e) {
			rs.put("success", false);
	        e.printStackTrace();
		}
		return rs;
	}
	
	@PostMapping("/insertGuest")
	@ResponseBody
	public Map<String, Object> insertGuest(@RequestBody MemberDTO mDto, HttpSession session) {
		log.info("insertGuest post........");
		log.info("insertGuest : " + mDto);
		
		Map<String, Object> rs = new HashMap<>();
		
		try {
			int guest = service.insertGuest(mDto);
			log.info("findGuest result: " + guest);
			if (guest > 0) {
				rs.put("success", true);
				rs.put("message", "비회원으로 가입하였습니다.");
				rs.put("redirectUrl", "/consult/writer");
				session.setAttribute("guestInfo", guest);
			} else {
				rs.put("success", false);
				rs.put("message", "비회원 가입이 실패했습니다.");
			}
			session.setAttribute("guestInfo", guest);
			log.info("guestInfo : " + session.getAttribute("guestInfo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@GetMapping("/existID")
	@ResponseBody
	public int existID(@RequestParam("username") String username) throws Exception {
		
		return service.existId(username);
	}
	
	@GetMapping("/existEmail")
	@ResponseBody
	public int existEmail(@RequestParam("email") String email) throws Exception {
		
		return service.existEmail(email);
	}
	
}
