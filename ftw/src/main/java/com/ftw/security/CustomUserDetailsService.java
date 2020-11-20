package com.ftw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ftw.member.mapper.MemberMapper;
import com.ftw.member.vo.MemberVO;

// import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
//@AllArgsConstructor : security bean에 등록한건 allarg 사용불가
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.warn("Load User By UserName: " + userName);

		// userName = userid
		MemberVO vo = memberMapper.read(userName);
		if (vo.getEnabled().equals("0")) {
			throw new UsernameNotFoundException("로그인 불가");
		}

		log.warn("queried by member mapper:" + vo);

		return vo == null ? null : new CustomUser(vo);
	}

}
