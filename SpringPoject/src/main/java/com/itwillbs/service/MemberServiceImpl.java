package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

//@Inject
//private MemberService memberService;
// => @Service �ڵ����� �ڽ�Ŭ���� ã���� ��

@Service
public class MemberServiceImpl implements MemberService{
	// ó���۾� 
	//�θ� �������̽� Ʋ ���
	
	//������� �θ�=�ڽ� ��ü����
	// MemberDAO �θ� = MemberDAOImpl �ڽ�  ��ü����
//	MemberDAO memberDAO=new MemberDAOImpl();
	
	// ������� ������ ���� => ��ü����
//	private MemberDAO memberDAO;
	
	//������� ���� ���� ������, set�޼��� ���ؼ� ����
	//set�޼���
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	// ������� ������ ���� => ��ü����
	@Inject
	private MemberDAO memberDAO;
	

	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		// MemberDAO �θ� = MemberDAOImpl �ڽ�  ��ü���� 
//		MemberDAO memberDAO=new MemberDAOImpl();
		
		// �޼��� ȣ��
		memberDAO.insertMember(memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl userCheck()");
		// MemberDAO �θ� = MemberDAOImpl �ڽ�  ��ü����
//		MemberDAO memberDAO=new MemberDAOImpl();
		
		// �������� MemberDTO  userCheck(MemberDTO memberDTO ) �޼��� ���� 
		// MemberDTO memberDTO2 = userCheck(memberDTO) �޼��� ȣ��
//		MemberDTO memberDTO2 =memberDAO.userCheck(memberDTO);
		
		return memberDAO.userCheck(memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberServiceImpl getMember()");
		
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl updateMember()");
	
	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl deleteMember()");
		
		memberDAO.deleteMember(memberDTO);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		
		return memberDAO.getMemberList();
	}

	

	
	
}
