package com.ftw.accident.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ftw.accident.mapper.Accident2Mapper;
import com.ftw.accident.vo.Accident2VO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Qualifier("accident2ServiceImpl")
@AllArgsConstructor // 생성자를 이용한 모든 속성을 자동 DI시킨다.
public class Accident2ServiceImpl implements Accident2Service {

  // @AllArgsConstructor를 이용해서 자동 DI 된다.
  private Accident2Mapper mapper;

  @Override
  public List<Accident2VO> list1() {
    log.info("--- 게시판 리스트 service ----");
    
    return mapper.list1();
  }
  @Override
  public List<Accident2VO> list2() {
    log.info("--- 게시판 리스트 service ----");
    return mapper.list2();
  }
  @Override
  public List<Accident2VO> list3() {
    log.info("--- 게시판 리스트 service ----");
    return mapper.list3();
  }



}
