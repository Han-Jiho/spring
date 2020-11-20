package com.ftw.check.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftw.mail.service.EMailService;
import com.ftw.member.service.MemberService;
import com.ftw.member.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class CheckController {

	@Qualifier("ms")
	@Autowired
	private MemberService memberService;

	@Autowired
	private EMailService emailService;
	
	// 아이디 중복체크
	@GetMapping("/check/id_check.do")
	public int id_check(String userid) {
		log.info("check.userid:" + userid);
		if (memberService.view(userid) != null) {
			log.info("id_check.userid 있음");
			return 0;
		} else {
			log.info("id_check.userid 없음");
			return 1;
		}
	}

	// 이메일 중복체크
	@GetMapping("/check/email_check.do")
	public int email_check(String email) {
		log.info("check.email:" + email);
		if (memberService.dup_email(email) == 1) {
			log.info("email_check.email 있음");
			return 0;
		} else {
			log.info("email_check.email 없음");
			return 1;
		}
	}

	// 이메일 보내기
	@GetMapping("/check/email_send.do")
	public int email_send(String email, HttpServletRequest request) {
		log.info("check.email" + email);
		HttpSession session = request.getSession();
		emailService.mailSend(session, email);
		return 1;
	}

	// 이메일 인증번호 확인
	@GetMapping("/check/email_conf.do")
	public int email_conf(HttpServletRequest request, String email, String inputCode) {

		log.info("email_conf.inputCode:" + inputCode);
		HttpSession session = request.getSession();
		boolean result = emailService.email_conf(session, email, Integer.parseInt(inputCode));

		if (result == true)
			return 1;
		else
			return 0;

	}
	
	// 아이디 찾기
	@GetMapping("/check/findUserid.do")
	public String findUserid(String email) {
		
		String userid = memberService.findUserid(email);
		log.info("findUserid.userid" + userid);
		userid = userid.substring(0, userid.length() - 2);
		userid += "**";
		return userid;
	}
	
	// 비밀번호 확인
	@GetMapping("/check/findUserpw.do")
	public boolean findUserpw(String userid, String email) {
		log.info("check.userid:" + userid);
		log.info("check.email:" + email);
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setEmail(email);
		
		return memberService.findUserpw(vo);

	}

}
