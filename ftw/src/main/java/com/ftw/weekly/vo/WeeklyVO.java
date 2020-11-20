package com.ftw.weekly.vo;

import java.util.Date;

import lombok.Data;

// 자동으로 setter/getter, 생성자, toString()가 생성이 되어진다.
@Data
public class WeeklyVO {

	private int monMin, monMax, tueMin, tueMax, wedMin, wedMax, thuMin, thuMax, friMin, friMax, satMin, satMax, sunMin, sunMax;
	private int monar, monpr, tuear, tuepr, wedar, wedpr, thuar, thupr, friar, fripr, satar, satpr, sunar, sunpr;
	private String monaw, monpw, tueaw, tuepw, wedaw, wedpw, thuaw, thupw, friaw, fripw, sataw, satpw, sunaw, sunpw;
	private int hit;
	private String baseDate;
	private Date writeDate;
	
}
