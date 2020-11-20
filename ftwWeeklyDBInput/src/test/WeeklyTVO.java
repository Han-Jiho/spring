package test;

import java.util.Date;

import lombok.Data;

@Data
public class WeeklyTVO {
	
	private int monMin, monMax, tueMin, tueMax, wedMin, wedMax, thuMin, thuMax, friMin, friMax, satMin, satMax, sunMin, sunMax;
	private int monar, monpr, tuear, tuepr, wedar, wedpr, thuar, thupr, friar, fripr, satar, satpr, sunar, sunpr;
	private String monaw, monpw, tueaw, tuepw, wedaw, wedpw, thuaw, thupw, friaw, fripw, sataw, satpw, sunaw, sunpw;
	private String baseDate;
	private Date writeDate;
}
