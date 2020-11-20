package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APITest {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		WeeklyTVO vo = new WeeklyTVO();

		// baseDate의 설정. 실행일로 한다. 최종 형태는 yyyyMMdd0600
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String baseDate = sdf.format(d) + "0600";
		System.out.println("baseDate = " + baseDate);

		// API에 집어넣을 url build
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=WpEhwHusoPShSVDD61kVHsDAXHqnmdrPAWazW2cmbCGoB%2BX5g99Un3OA8vGqmpn%2Fyv4JwIRVWzc0pvWDOsbm7w%3D%3D"); /*
																														*/
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
				+ URLEncoder.encode("JSON", "UTF-8")); /* 요청자료형식(XML/JSON)Default: XML */
		urlBuilder.append("&" + URLEncoder.encode("regId", "UTF-8") + "="
				+ URLEncoder.encode("11B10101", "UTF-8")); /* 하단 참고자료 참조 */
		urlBuilder.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "="
				+ URLEncoder.encode(baseDate, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력-최근 24시간 자료만 제공*/
		URL url = new URL(urlBuilder.toString());
		System.out.println(url);
		
		// 앞에선 기온을 받아오고 뒤에선 새로운 마음으로 강수확률, 기상예보를 받아온다.
		StringBuilder urlBuilder1 = new StringBuilder(
				"http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /* URL */
		urlBuilder1.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=WpEhwHusoPShSVDD61kVHsDAXHqnmdrPAWazW2cmbCGoB%2BX5g99Un3OA8vGqmpn%2Fyv4JwIRVWzc0pvWDOsbm7w%3D%3D"); /*
																														*/
		urlBuilder1
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder1.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder1.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
				+ URLEncoder.encode("JSON", "UTF-8")); /* 요청자료형식(XML/JSON)Default: XML */
		urlBuilder1.append("&" + URLEncoder.encode("regId", "UTF-8") + "="
				+ URLEncoder.encode("11B00000", "UTF-8")); /* 하단 참고자료 참조 */
		urlBuilder1.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "="
				+ URLEncoder.encode(baseDate, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력-최근 24시간 자료만 제공*/
		URL url1 = new URL(urlBuilder1.toString());
		System.out.println(url1);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		String result = sb.toString();
		JSONParser parser = new JSONParser();
		// JSONParser 생성

		JSONObject object = (JSONObject) parser.parse(result);
		// 이제 데이터를 한 단계식 분해해 보겠습니다.
		// 먼저 response 객체를 받아온다.
		JSONObject parse_response = (JSONObject) object.get("response");
		// parse_response객체 안에는 response 안에 데이터 들이 들어있다.
		// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
		JSONObject parse_body = (JSONObject) parse_response.get("body");
		// body 로 부터 items 받아옵니다.
		JSONObject parse_items = (JSONObject) parse_body.get("items");
		// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
		JSONArray parse_item = (JSONArray) parse_items.get("item");
		JSONObject weeklyT;
		
		// url1에 대한 내용띠
		HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
		conn1.setRequestMethod("GET");
		conn1.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd1;
		if (conn1.getResponseCode() >= 200 && conn1.getResponseCode() <= 300) {
			rd1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
		} else {
			rd1 = new BufferedReader(new InputStreamReader(conn1.getErrorStream()));
		}
		StringBuilder sb1 = new StringBuilder();
		String line1;
		while ((line1 = rd1.readLine()) != null) {
			sb1.append(line1);
		}
		rd1.close();
		conn1.disconnect();
		System.out.println(sb1.toString());
		
		String result1 = sb1.toString();
		JSONParser parser1 = new JSONParser();
		// JSONParser 생성
		
		JSONObject object1 = (JSONObject) parser1.parse(result1);
		// 이제 데이터를 한 단계식 분해해 보겠습니다.
		// 먼저 response 객체를 받아온다.
		JSONObject parse_response1 = (JSONObject) object1.get("response");
		// parse_response객체 안에는 response 안에 데이터 들이 들어있다.
		// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
		JSONObject parse_body1 = (JSONObject) parse_response1.get("body");
		// body 로 부터 items 받아옵니다.
		JSONObject parse_items1 = (JSONObject) parse_body1.get("items");
		// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
		JSONArray parse_item1 = (JSONArray) parse_items1.get("item");
		JSONObject weeklyT1;

		weeklyT = (JSONObject) parse_item.get(0);
		Long monMi = (Long) weeklyT.get("taMin3");
		Long monMa = (Long) weeklyT.get("taMax3");
		Long tueMi = (Long) weeklyT.get("taMin4");
		Long tueMa = (Long) weeklyT.get("taMax4");
		Long wedMi = (Long) weeklyT.get("taMin5");
		Long wedMa = (Long) weeklyT.get("taMax5");
		Long thuMi = (Long) weeklyT.get("taMin6");
		Long thuMa = (Long) weeklyT.get("taMax6");
		Long friMi = (Long) weeklyT.get("taMin7");
		Long friMa = (Long) weeklyT.get("taMax7");
		Long satMi = (Long) weeklyT.get("taMin8");
		Long satMa = (Long) weeklyT.get("taMax8");
		Long sunMi = (Long) weeklyT.get("taMin9");
		Long sunMa = (Long) weeklyT.get("taMax9");

		int monMin = monMi.intValue();
		int monMax = monMa.intValue();
		int tueMin = tueMi.intValue();
		int tueMax = tueMa.intValue();
		int wedMin = wedMi.intValue();
		int wedMax = wedMa.intValue();
		int thuMin = thuMi.intValue();
		int thuMax = thuMa.intValue();
		int friMin = friMi.intValue();
		int friMax = friMa.intValue();
		int satMin = satMi.intValue();
		int satMax = satMa.intValue();
		int sunMin = sunMi.intValue();
		int sunMax = sunMa.intValue();

		System.out.println("월요일 최저 : " + monMin);
		System.out.println("월요일 최고 : " + monMax);
		System.out.println("화요일 최저 : " + tueMin);
		System.out.println("화요일 최고 : " + tueMax);
		System.out.println("수요일 최저 : " + wedMin);
		System.out.println("수요일 최고 : " + wedMax);
		System.out.println("목요일 최저 : " + thuMin);
		System.out.println("목요일 최고 : " + thuMax);
		System.out.println("금요일 최저 : " + friMin);
		System.out.println("금요일 최고 : " + friMax);
		System.out.println("토요일 최저 : " + satMin);
		System.out.println("토요일 최고 : " + satMax);
		System.out.println("일요일 최저 : " + sunMin);
		System.out.println("일요일 최고 : " + sunMax);

		weeklyT1 = (JSONObject) parse_item1.get(0);
		Long mona = (Long) weeklyT1.get("rnSt3Am");
		Long monp = (Long) weeklyT1.get("rnSt3Pm");
		Long tuea = (Long) weeklyT1.get("rnSt4Am");
		Long tuep = (Long) weeklyT1.get("rnSt4Pm");
		Long weda = (Long) weeklyT1.get("rnSt5Am");
		Long wedp = (Long) weeklyT1.get("rnSt5Pm");
		Long thua = (Long) weeklyT1.get("rnSt6Am");
		Long thup = (Long) weeklyT1.get("rnSt6Pm");
		Long fria = (Long) weeklyT1.get("rnSt7Am");
		Long frip = (Long) weeklyT1.get("rnSt7Pm");
		Long sata = (Long) weeklyT1.get("rnSt8");
		Long satp = (Long) weeklyT1.get("rnSt8");
		Long suna = (Long) weeklyT1.get("rnSt9");
		Long sunp = (Long) weeklyT1.get("rnSt9");
		String monaw = (String) weeklyT1.get("wf3Am");
		String monpw = (String) weeklyT1.get("wf3Pm");
		String tueaw = (String) weeklyT1.get("wf4Am");
		String tuepw = (String) weeklyT1.get("wf4Pm");
		String wedaw = (String) weeklyT1.get("wf5Am");
		String wedpw = (String) weeklyT1.get("wf5Pm");
		String thuaw = (String) weeklyT1.get("wf6Am");
		String thupw = (String) weeklyT1.get("wf6Pm");
		String friaw = (String) weeklyT1.get("wf7Am");
		String fripw = (String) weeklyT1.get("wf7Pm");
		String sataw = (String) weeklyT1.get("wf8");
		String satpw = (String) weeklyT1.get("wf8");
		String sunaw = (String) weeklyT1.get("wf9");
		String sunpw = (String) weeklyT1.get("wf9");
		
		int monar = mona.intValue();
		int monpr = monp.intValue();
		int tuear = tuea.intValue();
		int tuepr = tuep.intValue();
		int wedar = weda.intValue();
		int wedpr = wedp.intValue();
		int thuar = thua.intValue();
		int thupr = thup.intValue();
		int friar = fria.intValue();
		int fripr = frip.intValue();
		int satar = sata.intValue();
		int satpr = satp.intValue();
		int sunar = suna.intValue();
		int sunpr = sunp.intValue();
		
		//baseDate vo셋팅
		vo.setBaseDate(baseDate);
		//최저최고기온 vo셋
		vo.setMonMin(monMin);
		vo.setMonMax(monMax);
		vo.setTueMin(tueMin);
		vo.setTueMax(tueMax);
		vo.setWedMin(wedMin);
		vo.setWedMax(wedMax);
		vo.setThuMin(thuMin);
		vo.setThuMax(thuMax);
		vo.setFriMin(friMin);
		vo.setFriMax(friMax);
		vo.setSatMin(satMin);
		vo.setSatMax(satMax);
		vo.setSunMin(sunMin);
		vo.setSunMax(sunMax);
		//강수확률,날씨 셋
		vo.setMonar(monar);
		vo.setMonpr(monpr);
		vo.setTuear(tuear);
		vo.setTuepr(tuepr);
		vo.setWedar(wedar);
		vo.setWedpr(wedpr);
		vo.setThuar(thuar);
		vo.setThupr(thupr);
		vo.setFriar(friar);
		vo.setFripr(fripr);
		vo.setSatar(satar);
		vo.setSatpr(satpr);
		vo.setSunar(sunar);
		vo.setSunpr(sunpr);
		vo.setMonaw(monaw);
		vo.setMonpw(monpw);
		vo.setTueaw(tueaw);
		vo.setTuepw(tuepw);
		vo.setWedaw(wedaw);
		vo.setWedpw(wedpw);
		vo.setThuaw(thuaw);
		vo.setThupw(thupw);
		vo.setFriaw(friaw);
		vo.setFripw(fripw);
		vo.setSataw(sataw);
		vo.setSatpw(satpw);
		vo.setSunaw(sunaw);
		vo.setSunpw(sunpw);

		System.out.println("월요일 오전 강수확률: " + monar);
		System.out.println("월요일 오후 강수확률: " + monpr);
		System.out.println("화요일 오전 강수확률: " + tuear);
		System.out.println("화요일 오후 강수확률: " + tuepr);
		System.out.println("수요일 오전 강수확률: " + wedar);
		System.out.println("수요일 오후 강수확률: " + wedpr);
		System.out.println("목요일 오전 강수확률: " + thuar);
		System.out.println("목요일 오후 강수확률: " + thupr);
		System.out.println("금요일 오전 강수확률: " + friar);
		System.out.println("금요일 오후 강수확률: " + fripr);
		System.out.println("토요일 오전 강수확률: " + satar);
		System.out.println("토요일 오후 강수확률: " + satpr);
		System.out.println("일요일 오전 강수확률: " + sunar);
		System.out.println("일요일 오후 강수확률: " + sunpr);
		System.out.println("월요일 오전 날씨 : " + monaw);
		System.out.println("월요일 오후 날씨 : " + monpw);
		System.out.println("화요일 오전 날씨 : " + tueaw);
		System.out.println("화요일 오후 날씨 : " + tuepw);
		System.out.println("수요일 오전 날씨 : " + wedaw);
		System.out.println("수요일 오후 날씨 : " + wedpw);
		System.out.println("목요일 오전 날씨 : " + thuaw);
		System.out.println("목요일 오후 날씨 : " + thupw);
		System.out.println("금요일 오전 날씨 : " + friaw);
		System.out.println("금요일 오후 날씨 : " + fripw);
		System.out.println("토요일 오전 날씨 : " + sataw);
		System.out.println("토요일 오후 날씨 : " + satpw);
		System.out.println("일요일 오전 날씨 : " + sunaw);
		System.out.println("일요일 오후 날씨 : " + sunpw);

	}
}