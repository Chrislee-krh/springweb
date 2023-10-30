package org.zerock.member.mapper;

import org.zerock.member.command.MemberVO;

public interface MemberMapper {

	//회원가입
	public int join(MemberVO vo);
	//로그인
	public int login(MemberVO vo);
	//아이디 중복 체크(회원가입 시)
	public int idCheck(String id);
}
