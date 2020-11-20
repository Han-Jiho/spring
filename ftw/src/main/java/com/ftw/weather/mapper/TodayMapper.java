package com.ftw.weather.mapper;

import java.util.List;

import com.ftw.weather.vo.TodayVO;

import net.webjjang.util.PageObject;

public interface TodayMapper {

	public List<TodayVO> list(PageObject pageObject);
	public Integer getRow(PageObject pageObject);
	 
}