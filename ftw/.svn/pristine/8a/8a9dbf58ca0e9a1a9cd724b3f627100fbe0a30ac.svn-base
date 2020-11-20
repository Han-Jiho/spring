package com.ftw.member.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftw.member.mapper.MemberMapper;
import com.ftw.member.vo.CntVO;
import com.ftw.member.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.webjjang.util.PageObject;

@Service
@Log4j
@Qualifier("ms")
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper mapper;
	PasswordEncoder pwencoder;

	//아이디 찾기
	@Override
	public String findUserid(String email) {
		// TODO Auto-generated method stub
		return mapper.findUserid(email);
	}

	// 비밀번호 찾기
	@Override
	public boolean findUserpw(MemberVO vo) {
		// TODO Auto-generated method stub
		String userpw = mapper.findUserpw(vo);
		log.info(userpw);
		if (userpw != null) {
			return true;
		} else {
			return false;
		}
	}

	// 회원 리스트
	@Override
	public List<MemberVO> list(PageObject pageObject) {
		// TODO Auto-generated method stub
		log.info("Service.list()");
		pageObject.setTotalRow(mapper.getRow(pageObject));
		return mapper.list(pageObject);
	}

	// 회원 정보 & 내 정보
	@Override
	public MemberVO view(String userid) {
		// TODO Auto-generated method stub
		log.info("Service.view()");
		return mapper.view(userid);
	}

	// 회원 가입
	@Override
	public void join(MemberVO vo) {
		// TODO Auto-generated method stub
		log.info("Service.join().vo:" + vo);
		mapper.join(vo);
		mapper.auth(vo.getUserid());
	}

	// 내 정보 수정
	@Override
	public boolean update(MemberVO vo) {
		// TODO Auto-generated method stub
		log.info("Service.update()");
		return mapper.update(vo);
	}

	// 비밀번호 확인
	@Override
	public String check(String userid) {
		// TODO Auto-generated method stub
		log.info("Service.check().userid:" + userid);
		return mapper.check(userid);
	}

	// 비밀번호 변경
	@Override
	public boolean change(MemberVO vo) {
		// TODO Auto-generated method stub
		log.info("Service.change()");
		return mapper.change(vo);
	}

	// 회원 정지
	@Override
	public void stop(String userid) {
		// TODO Auto-generated method stub
		log.info("Service.stop()");
		mapper.stop(userid);
	}

	// 회원 정지 해제
	@Override
	public void clear(String userid) {
		// TODO Auto-generated method stub
		log.info("Service.stop()");
		mapper.clear(userid);
	}

	// 회원 탈퇴
	@Override
	public void exit(String userid, HttpSession session) {
		// TODO Auto-generated method stub
		log.info("Service.exit()");
		mapper.delete(userid);
		mapper.exit(userid);
		session.invalidate();
	}

	// 이메일 중복
	@Override
	public int dup_email(String email) {
		// TODO Auto-generated method stub
		log.info("Service.dup_email()");
		MemberVO result = mapper.dup_email(email);
		if (result != null)
			return 1;
		else
			return 0;
	}

	// 회원 통계
	@Override
	public List<String> cnt() {
		List<String> cnt = new ArrayList<String>();
		List<CntVO> local = mapper.cnt();
		log.info("local1:" + local);

		for (CntVO vo : local) {
			if (vo == null) {
				vo = new CntVO();
			} else {
				cnt.add(vo.getLocal1());
				cnt.add(vo.getLocal2());
				cnt.add(vo.getLocal3());
			}
			System.out.println("for.cnt:" + cnt);
		}
		System.out.println("cnt.local" + cnt);

		log.info("cnt().cnt:" + cnt);
		return cnt;
	}

}