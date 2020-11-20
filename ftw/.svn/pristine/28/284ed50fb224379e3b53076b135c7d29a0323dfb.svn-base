package com.ftw.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftw.accident.service.AccidentService;
import com.ftw.ptp.service.PtpService;
import com.ftw.traffic.service.TrafficService;
import com.ftw.weather.service.SeoulService;
import com.ftw.weekly.service.WeeklyService;

import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/main")
public class MainController {

	private final String MODULE = "main/";

	// 교통사고
	@Autowired
	@Qualifier("accidentServiceImpl")
	private AccidentService as;

	// 서울날씨
	@Autowired
	@Qualifier("seoulServiceImpl")
	private SeoulService seoul;

	// 건의사항
	@Autowired
	private PtpService ps;

	// 교통 정보
	@Autowired
	@Qualifier("trafficServiceImpl")
	private TrafficService ts;

	// 주간 날씨
	@Autowired
	@Qualifier("weeklyServiceImpl")
	private WeeklyService wls;

	@GetMapping("/index.do")
	public String index(Model model) {

		PageObject pageObject = new PageObject(1, 5);

		model.addAttribute("accident", as.list(pageObject));
		model.addAttribute("ptp", ps.list(pageObject));
		model.addAttribute("ts", ts.list(pageObject));
		model.addAttribute("wls", wls.list(pageObject));
		model.addAttribute("seoul", seoul.view());
		return MODULE + "index";
	}

}
