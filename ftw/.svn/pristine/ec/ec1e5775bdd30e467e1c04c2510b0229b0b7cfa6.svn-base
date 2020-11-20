package com.ftw.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberTests {

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	// 회원 등록
	@Test
	public void testInsertMember() {
		String sql = "insert into member(no, userid, userpw, nickname, email) "
				+ "values(member_seq.nextval, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "admin");
			pstmt.setString(2, pwencoder.encode("1234"));
			pstmt.setString(3, "관리자");
			pstmt.setString(4, "flowtrafficweather@gmail.com");

			pstmt.executeUpdate();

			log.info("sql:" + sql);
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}


	// 권한 등록
	@Test
	public void testInsertAuth() {

		String sql = "insert into member_auth " + "values(?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "admin");
			pstmt.setString(2, "ROLE_ADMIN");

			pstmt.executeUpdate();

			log.info("auth.sql:" + sql);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}


}