package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertMember(MemberDTO memberDTO) {
		// ����۾�
		System.out.println("MemberDAOImpl insertMember()");
	}

	@Override
	public MemberDTO userChcek(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl userCheck()");
		return null;
	}

}
