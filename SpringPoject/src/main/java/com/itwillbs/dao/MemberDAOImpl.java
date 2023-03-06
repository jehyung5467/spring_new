package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertMember(MemberDTO memberDTO) {
		// 디비작업
		System.out.println("MemberDAOImpl insertMember()");
		
	}

}
