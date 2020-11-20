package com.ftw.weather.vo;

import lombok.Data;

//자동으로 setter/getter, 생성자, toString()가 생성이 되어진다.
@Data
public class TodayVO {

	private int humid;
	private String local, weather, temp;
	
}
