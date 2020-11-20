package com.ftw.accident.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ftw.accident.service.Accident2Service;
import com.ftw.accident.service.AccidentService;
import com.ftw.accident.vo.Accident2VO;
import com.ftw.accident.vo.AccidentVO;
import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/accident")
public class AccidentController {

//  @GetMapping("list.do")
//  public String list() {
//    return "accident/list";
//  };
  
  private final String MODULE = "accident"; 
  
  // @AllArgsConstructor 생성자를 이용한 자동 DI 적용
  // @@Autowired setter를 이용한 자동 DI 적용
  @Autowired
  @Qualifier("accidentServiceImpl")
  private AccidentService service;

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
  
  // 2. 보기 - get
  @GetMapping("/view.do")
  public String view(Model model, int no, int inc) {
      model.addAttribute("vo", service.view(no, inc));
      return MODULE + "/view";
  }
  
  // 3-1. 글쓰기폼 -get 
  @GetMapping("/write.do")
  public String writeForm() {
      return MODULE + "/write";
  }
  // 3-2. 글쓰기처리 - post
  @PostMapping("/write.do")
  public String write(AccidentVO vo) {
      service.write(vo);
      return "redirect:list.do";
  }
  // 4-1. 글수정폼 - get
  @GetMapping("/update.do")
  public String updateForm(Model model, int no) {
      // 데이터를 가져오기 위해 view() 호출 : inc = 0
      model.addAttribute("vo", service.view(no, 0));
      return MODULE + "/update";
  }
  // 4-2. 글수정처리 - post
  @PostMapping("/update.do")
  public String update(AccidentVO vo) {
      service.update(vo);
      return "redirect:view.do?no=" + vo.getNo()
      + "&inc=0";
  }
  // 5. 삭제 - get
  @PostMapping("/delete.do")
  public String delete(AccidentVO vo) {
      service.delete(vo);
      return "redirect:list.do";
  }
  
  ///////////////// 분석 
  @Autowired
  @Qualifier("accident2ServiceImpl")
  private Accident2Service service2;

  // 1. 리스트 - get
  @GetMapping("/analysis.do")
  // PageObject에서 데이터가 넘어오지 않으면 기본페이지 1, 페이지당 데이터의 갯수는 10으로 한다.
  public String list(Model model) {
      // model에 데이터를 담으면 request에 데이터가 담기게 된다.
      // jsp에서 꺼내 쓸때는 ${list} == ${requestScope.list}
    List<Accident2VO> list1 = service2.list1();
    List<Accident2VO> list2 = service2.list2();
    List<Accident2VO> list3 = service2.list3();
 //     model.addAttribute("list", service2.list());
      
      String data1 = "[";
      for(Accident2VO vo : list1) {
          data1 += vo.getCntByHour() + ",";
      }
      // 마지막의 콤마를 제거
      data1 = data1.substring(0,data1.length()-1);
      data1 += "]";
      System.out.println("Visual.view().data:"+data1);
      
      model.addAttribute("data1", data1);
      
      String data2 = "[";
      for(Accident2VO vo : list2) {
        data2 += vo.getCntByHour() + ",";
      }
      // 마지막의 콤마를 제거
      data2 = data2.substring(0,data2.length()-1);
      data2 += "]";
      System.out.println("Visual.view().data:"+data2);
      
      model.addAttribute("data2", data2);
      
      String data3 = "[";
      for(Accident2VO vo : list3) {
        data3 += vo.getCntByHour() + ",";
      }
      // 마지막의 콤마를 제거
      data3 = data3.substring(0,data3.length()-1);
      data3 += "]";
      System.out.println("Visual.view().data:"+data3);
      
      model.addAttribute("data1", data1);
      model.addAttribute("data2", data2);
      model.addAttribute("data3", data3);
      return MODULE + "/analysis";
  }
}
