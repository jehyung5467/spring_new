package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// 처리작업
	//부모 인터페이스 틀 상속
//	MemberDAO memberDAO = new MemberDAOImpl();
	
	//멤버변수 데이터 은닉
	private MemberDAO memberDAO;
	
	//멤버변수 값을 전달 생성자, set메서드 통해서 전달
	//set메서드
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO 부모 = MemberDAOImpl 자식 객체생성
//		MemberDAO memberDAO = new MemberDAOImpl();
		//메서드호출
		memberDAO.insertMember(memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl userCheck()");
//		MemberDAO memberDAO = new MemberDAOImpl();
		memberDAO.userChcek(memberDTO);
		
		return null;
	}
	
}
