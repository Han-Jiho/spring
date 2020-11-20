package com.ftw.ptp.mapper;

import java.util.List;

import com.ftw.ptp.vo.PtpVO;

import net.webjjang.util.PageObject;

public interface PtpMapper {

	// 리스트+데이터총갯수
	public List<PtpVO> list(PageObject pageObject);
	public Integer getCount(PageObject pageObject);
	// 글보기+조회수증가
	public PtpVO view(int no);
	public Integer increse(int no);
	// 글쓰기
	public Integer write(PtpVO vo);
	// 글수정
	public Integer update(PtpVO vo);
	// 글삭제
	public Integer delete(PtpVO vo);
	
}
