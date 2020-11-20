package com.ftw.accident.mapper;

import java.util.List;
import com.ftw.accident.vo.AccidentVO;
import net.webjjang.util.PageObject;

public interface AccidentMapper {

	//1. list - 전체 데이터 구하기(페이지 처리)
	public List<AccidentVO> list(PageObject pageObject);
	public Integer getRow(PageObject pageObject);
	//2. view - 조회수 1증가
	public AccidentVO view(int no);
	public void increase(int no);
	//3. write
	public void write(AccidentVO vo);
	//4. update
	public void update(AccidentVO vo);
	//5. delete - no, pw
	public void delete(AccidentVO vo);
	
}
