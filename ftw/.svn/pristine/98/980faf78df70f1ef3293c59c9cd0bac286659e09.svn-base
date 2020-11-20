package com.ftw.weather.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ftw.weather.mapper.SeoulMapper;
import com.ftw.weather.vo.SeoulVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//자동 생성 - @Controller, @Service, @Repository, @Component,
//@RestController, @~Advice
//** servlet-context.xml에 component-scan으로 설정된 패키지 아래의 클래스만 찾아서
//생성해 준다.
@Service
@Log4j
@Qualifier("seoulServiceImpl")
@AllArgsConstructor // 생성자를 이용한 모든 속성을 자동 DI시킨다.
public class SeoulServiceImpl implements SeoulService{

	// @AllArgsConstructor를 이용해서 자동 DI 된다.
	private SeoulMapper mapper;

	@Override
	public SeoulVO view() {
		// TODO Auto-generated method stub
		// inc가 1일 때만 조회수 증가 -> 데이터 가져오기
		return mapper.view();
	}
	


}