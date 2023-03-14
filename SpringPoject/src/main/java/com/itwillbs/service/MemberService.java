package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	// Ŭ���� ����� ���� �θ� �������̽� Ʋ
	// �߻�޼��� Ʋ ����
	public void insertMember(MemberDTO memberDTO);
	
	public MemberDTO userCheck(MemberDTO memberDTO);
	
	public MemberDTO getMember(String id);
	
	public void updateMember(MemberDTO memberDTO);

	public void deleteMember(MemberDTO memberDTO);

	public List<MemberDTO> getMemberList();
}
