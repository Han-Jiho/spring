package com.ftw.ptp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ftw.ptp.mapper.PtpMapper;
import com.ftw.ptp.vo.PtpVO;

import net.webjjang.util.PageObject;

@Service
public class PtpService {

	@Inject
	private PtpMapper mapper;

	// 리스트
	public List<PtpVO> list(PageObject pageObject){
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}
	
	// 글보기
	public PtpVO view(int no,int inc) {
		if(inc==1)
			mapper.increse(no);
		return mapper.view(no);
	}

	// 글쓰기
	public Integer write(PtpVO vo) {
		return mapper.write(vo);
	}

	// 글수정
	public Integer update(PtpVO vo) {
		return mapper.update(vo);
	}
	
	// 글삭제
	public Integer delete(PtpVO vo) {
		return mapper.delete(vo);
	}
}
