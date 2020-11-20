package com.ftw.weather.mapper;

import java.util.List;
import com.ftw.weather.vo.WeatherVO;
import net.webjjang.util.PageObject;

public interface WeatherMapper {
	//1. list - 전체 데이터 구하기(페이지 처리)
	public List<WeatherVO> list(PageObject pageObject);
	public Integer getRow(PageObject pageObject);
	//2. view - 조회수 1증가
	public WeatherVO view(int no);
	public void increase(int no);
	//3. write
	public void write(WeatherVO vo);
	//4. update
	public void update(WeatherVO vo);
	//5. delete - no, pw
	public void delete(WeatherVO vo);
	 
}