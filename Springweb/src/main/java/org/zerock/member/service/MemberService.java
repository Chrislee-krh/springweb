package org.zerock.member.service;

import org.zerock.member.command.MemberVO;

public interface MemberService {
	
	public int idCheck(String id);
	public int join(MemberVO vo);
	public int login(MemberVO vo);

}
