package com.webjjang.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;

import net.webjjang.util.PageObject;

@Service
public class BoardService {

	
	
	@Inject
	private BoardMapper mapper;
	
	// 게시판 리스트
	public List<BoardVO> list(PageObject pageObject){
		pageObject.setTotalRow(mapper.getCount());
		return mapper.list(pageObject);
	}
	// 게시판 글보기
	public BoardVO view(int no, int inc){
		if(inc == 1)
			mapper.increase(no);
		return mapper.view(no);
	}
	// 게시판 쓰기
	public Integer write(BoardVO vo){
		return mapper.write(vo);
	}
	// 게시판 수정
	public Integer update(BoardVO vo){
		return mapper.update(vo);
	}
	// 게시판 삭제
	public Integer delete(int no){
		return mapper.delete(no);
	}
	
	
}


