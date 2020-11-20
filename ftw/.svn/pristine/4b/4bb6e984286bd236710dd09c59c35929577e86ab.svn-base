package com.ftw.mail.service;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ftw.mail.handler.MailHandler;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EMailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void mailSend(HttpSession session, String email) {
		try {
			MailHandler mailHandler = new MailHandler(javaMailSender);
			Random random = new Random(System.currentTimeMillis());
			long start = System.currentTimeMillis();
			
			int result = 100000 + random.nextInt(900000);
			
			// 받는 사람
			mailHandler.setTo(email);
			
			// 보내는 사람
			mailHandler.setFrom("flowtrafficweather@gmail.com");
			
			// 제목
			mailHandler.setSubject("FlowTrafficWeather 가입 인증번호 발송");
			
			// HTML 레이아웃
			String htmlContent = "<p>인증번호 : " + result + "</p>";
			mailHandler.setText(htmlContent, true);
			
			// 메일 보내기
			mailHandler.send();
			
			long end = System.currentTimeMillis();
			
			session.setAttribute("" + email, result);
			log.info("실행 시간:" + (end - start)/1000.0);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean email_conf(HttpSession session, String email, int inputCode) {
		try {
			int generationCode = (int) session.getAttribute(email);
			
			if(generationCode == inputCode) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
