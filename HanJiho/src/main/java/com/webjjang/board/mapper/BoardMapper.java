package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.vo.BoardVO;

import net.webjjang.util.PageObject;

public interface BoardMapper {

	// 게시판 리스트
	public List<BoardVO> list(PageObject pageObject);
	public Integer getCount();
	
	// 게시판 글보기
	public BoardVO view (int no);
	public Integer increase(int no);
	
	// 게시판 글쓰기
	public Integer write(BoardVO vo);
	
	// 게시판 글수정
	public Integer update(BoardVO vo);
	
	// 게시판 글삭제
	public Integer delete(int no);
}
