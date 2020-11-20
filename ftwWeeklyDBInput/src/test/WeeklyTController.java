package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;

public class WeeklyTController {
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		// baseDate의 설정해서 WeeklyTJson에 집어넣는다. 이는 실행일로 한다. 최종 형태는 yyyyMMdd0600
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String baseDate = sdf.format(d)+"0600";
		
		
		WeeklyTJSON Json = new WeeklyTJSON();
		WeeklyTVO vo = Json.getWeeklyTVO(baseDate);
		
		WeeklyTDAO dao = new WeeklyTDAO();
		dao.insertWeeklyT(vo);
	}
}
