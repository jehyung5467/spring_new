package com.itwillbs.service;

import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// 처리작업
	//부모 인터페이스 틀 상속
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO 부모 = MemberDAOImpl 자식 객체생성
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		//메서드호출
		memberDAO.insertMember(memberDTO);
	}
	
}
