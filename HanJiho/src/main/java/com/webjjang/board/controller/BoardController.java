package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping ("/board")
public class BoardController {
	
	private final String MODULENAME = "board";
	
	@Autowired
	private BoardService service;
	
	// 패스워드 암호화
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// 게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		
		return MODULENAME + "/list";
	}
	
	// 게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no, int inc) {
		model.addAttribute("vo", service.view(no, inc));
		
		return MODULENAME + "/view";
	}
	
	// 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		return MODULENAME + "/write";
	}
	
	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		
		String inputPassword = vo.getPassword();
		String password = passwordEncoder.encode(inputPassword);
		vo.setPassword(password);
				
		service.write(vo);
		return "redirect:list.do";
	}
	
	
	// 게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(int no, Model model) {
		model.addAttribute("vo", service.view(no, 0));
		return MODULENAME + "/update";
	}
	
	// 게시판 글수정 처리
	@PostMapping("/update.do")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:view.do?no=" + vo.getNo()
		+ "&inc=0";
	}
	
	// 게시판 글삭제 처리
	@GetMapping("/delete.do")
	public String delete(int no) {
		service.delete(no);
		return "redirect:list.do";
	}
	
}
