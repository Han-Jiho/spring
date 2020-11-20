package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WeeklyTDAO {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	// jdbc 드라이버 주소
	static final String DB_URL = "jdbc:oracle:thin:@106.243.249.73:9321:orcl";
	// DB 접속 주소
	// localhost는 접속하려는 데이터베이스 주소를 입력하시면 됩니다. localhost를 사용하면 됩니다.
	// 3306은 데이터베이스에 접속할때 사용하는 포터번호입니다. 설치할때 설정한 포트번호를 사용합니다.
	// yourWeather에는 접속하려는 database의 name을 입력해줍니다.

	static final String USERNAME = "team3"; // DB ID
	static final String PASSWORD = "team3"; // DB Password

	private Connection conn = null;
	private Statement stmt = null;
//	private ResultSet rs = null;

	// vo객체를 입력받으면 객체안의 속성에 초기화된 데이터들을 데이터베이스에 인설트하는 메소드입니다.

	public void insertWeeklyT(WeeklyTVO vo) {

		String query = "INSERT INTO WEEKLYT (BASEDATE, MONMIN, MONMAX, TUEMIN, TUEMAX, WEDMIN, WEDMAX, THUMIN, THUMAX, FRIMIN, FRIMAX, SATMIN, SATMAX, SUNMIN, SUNMAX, "
				+ "MONAR, MONPR, TUEAR, TUEPR, WEDAR, WEDPR, THUAR, THUPR, FRIAR, FRIPR, SATAR, SATPR, SUNAR, SUNPR, "
				+ "MONAW, MONPW, TUEAW, TUEPW, WEDAW, WEDPW, THUAW, THUPW, FRIAW, FRIPW, SATAW, SATPW, SUNAW, SUNPW)" 
				+ " VALUES(" + "'" + vo.getBaseDate() 
				+ "','" + vo.getMonMin() + "','" + vo.getMonMax() 
				+ "','" + vo.getTueMin() + "','" + vo.getTueMax()
				+ "','" + vo.getWedMin() + "','" + vo.getWedMax() 
				+ "','" + vo.getThuMin() + "','" + vo.getThuMax() 
				+ "','" + vo.getFriMin() + "','" + vo.getFriMax() 
				+ "','" + vo.getSatMin() + "','" + vo.getSatMax() 
				+ "','" + vo.getSunMin() + "','" + vo.getSunMax()
				+ "','" + vo.getMonar() + "','" + vo.getMonpr() 
				+ "','" + vo.getTuear() + "','" + vo.getTuepr()
				+ "','" + vo.getWedar() + "','" + vo.getWedpr() 
				+ "','" + vo.getThuar() + "','" + vo.getThupr() 
				+ "','" + vo.getFriar() + "','" + vo.getFripr() 
				+ "','" + vo.getSatar() + "','" + vo.getSatpr() 
				+ "','" + vo.getSunar() + "','" + vo.getSunpr()
				+ "','" + vo.getMonaw() + "','" + vo.getMonpw() 
				+ "','" + vo.getTueaw() + "','" + vo.getTuepw()
				+ "','" + vo.getWedaw() + "','" + vo.getWedpw() 
				+ "','" + vo.getThuaw() + "','" + vo.getThupw() 
				+ "','" + vo.getFriaw() + "','" + vo.getFripw() 
				+ "','" + vo.getSataw() + "','" + vo.getSatpw() 
				+ "','" + vo.getSunaw() + "','" + vo.getSunpw()
				+ "')";

		System.out.println("Database 접속중... ");

		try {
			// 데이터베이스에 접속합니다.
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			// 데이터베이스 접속 결과를 출력합니다.
			if (conn != null) {
				System.out.println("앙 성공띠!");
			} else {
				System.out.println("아앙 실패띠...");
			}

			System.out.println("쿼리를 봅니다 ..."); // 실행될 쿼리문을 출력합니다.
			System.out.println("쿼리:" +query); // 실행될 쿼리문을 출력합니다.

			stmt = conn.createStatement(); // 쿼리문을 전송할 Statement 객체를 만듭니다. 
			stmt.executeUpdate(query);// 쿼리문을 실행시킵니다.
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exection");
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
		}
	}
}