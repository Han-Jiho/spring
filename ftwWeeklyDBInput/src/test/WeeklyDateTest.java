package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeeklyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String baseDate = sdf.format(d)+"0600";
		System.out.println("baseDate = " + baseDate);
	}

}
