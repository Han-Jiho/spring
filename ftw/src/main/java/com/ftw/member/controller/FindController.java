package com.ftw.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftw.member.service.MemberService;
import com.ftw.member.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/find")
@Log4j
public class FindController {

	private final String MODULE = "find/";
	
	@Autowired
	@Qualifier("ms")
	private MemberService service;
	@Autowired
	private PasswordEncoder pwencoder;

	// 아이디/비밀번호 찾기
	@GetMapping("/find.do")
	public String findForm() {

		return MODULE + "find";
	}
	
	// 비밀번호 변경
	@GetMapping("/change.do")
	public String changeForm() {
		
		return MODULE + "change";
	}
	@PostMapping("/change.do")
	public String change(MemberVO vo, Model model) {
		
		log.info("change.vo:" + vo);
		
		// 비밀번호 암호화
		String rawPw = vo.getUserpw();
		log.info("join.rawPW:" + rawPw);
		vo.setUserpw(pwencoder.encode(rawPw));
		
		boolean result = service.change(vo);
		if(result == true) {
			return "redirect:success.do";
		}
		else {
			model.addAttribute("error", "비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
			return "redirect:change.do?userid=" + vo.getUserid();
		}
	}
	
	// 비밀번호 변경 확인
	@GetMapping("success.do")
	public String seccess() {
		
		return MODULE + "success";
	}

}
