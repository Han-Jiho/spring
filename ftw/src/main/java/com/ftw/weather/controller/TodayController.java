package com.ftw.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ftw.weather.service.TodayService;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/today")
public class TodayController {

//  @GetMapping("list.do")
//  public String list() {
//    return "accident/list";
//  };
  
  private final String MODULE = "today"; 
  
  // @AllArgsConstructor 생성자를 이용한 자동 DI 적용
  // @@Autowired setter를 이용한 자동 DI 적용
  @Autowired
  @Qualifier("todayServiceImpl")
  private TodayService service;
  
  
  
  // 1. 리스트 - get
  @GetMapping("/list.do")
  // PageObject에서 데이터가 넘어오지 않으면 기본페이지 1, 페이지당 데이터의 갯수는 10으로 한다.
  public String list(Model model, PageObject pageObject) {
      // model에 데이터를 담으면 request에 데이터가 담기게 된다.
      // jsp에서 꺼내 쓸때는 ${list} == ${requestScope.list}
      model.addAttribute("list", service.list(pageObject));
      // 하단 부분의 페이지네이션 처리를 위해서 pageObject가 꼭 필요함다.
      // 2페이지 이상이되면 페이지네이션을 표시한다.
      model.addAttribute("pageObject", pageObject);
      return MODULE + "/list";
  }

  
}
