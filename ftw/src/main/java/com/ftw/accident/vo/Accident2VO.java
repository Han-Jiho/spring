package com.ftw.accident.vo;

import lombok.Data;

// 자동으로 setter/getter, 생성자, toString()가 생성이 되어진다.
@Data
public class Accident2VO {

	private int acType, day, hour;
	private int cntByHour;
	
}
