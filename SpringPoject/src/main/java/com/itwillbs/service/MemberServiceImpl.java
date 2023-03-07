package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	// ó���۾�
	//�θ� �������̽� Ʋ ���
//	MemberDAO memberDAO = new MemberDAOImpl();
	
	//������� ������ ����
	private MemberDAO memberDAO;
	
	//������� ���� ���� ������, set�޼��� ���ؼ� ����
	//set�޼���
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO �θ� = MemberDAOImpl �ڽ� ��ü����
//		MemberDAO memberDAO = new MemberDAOImpl();
		//�޼���ȣ��
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
