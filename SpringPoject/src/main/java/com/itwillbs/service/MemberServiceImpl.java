package com.itwillbs.service;

import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// ó���۾�
	//�θ� �������̽� Ʋ ���
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO �θ� = MemberDAOImpl �ڽ� ��ü����
		MemberDAOImpl memberDAO = new MemberDAOImpl();
		//�޼���ȣ��
		memberDAO.insertMember(memberDTO);
	}
	
}
