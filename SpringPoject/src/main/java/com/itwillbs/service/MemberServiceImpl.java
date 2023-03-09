package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

//@Inject
//private MemberService memberService;
// => @Service 자동으로 자식클래스 찾도록 함

@Service
public class MemberServiceImpl implements MemberService{
	// 처리작업 
	//부모 인터페이스 틀 상속
	
	//멤버변수 부모=자식 객체생성
	// MemberDAO 부모 = MemberDAOImpl 자식  객체생성
//	MemberDAO memberDAO=new MemberDAOImpl();
	
	// 멤버변수 데이터 은닉 => 객체생성
//	private MemberDAO memberDAO;
	
	//멤버변수 값을 전달 생성자, set메서드 통해서 전달
	//set메서드
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	// 멤버변수 데이터 은닉 => 객체생성
	@Inject
	private MemberDAO memberDAO;
	

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO 부모 = MemberDAOImpl 자식  객체생성 
//		MemberDAO memberDAO=new MemberDAOImpl();
		
		// 메서드 호출
		memberDAO.insertMember(memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl userCheck()");
		// MemberDAO 부모 = MemberDAOImpl 자식  객체생성
//		MemberDAO memberDAO=new MemberDAOImpl();
		
		// 리턴할형 MemberDTO  userCheck(MemberDTO memberDTO ) 메서드 정의 
		// MemberDTO memberDTO2 = userCheck(memberDTO) 메서드 호출
//		MemberDTO memberDTO2 =memberDAO.userCheck(memberDTO);
		
		return memberDAO.userCheck(memberDTO);
	}
	
	
}
