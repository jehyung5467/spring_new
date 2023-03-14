package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	// 추상메서드 틀 정의
	public void insertMember(MemberDTO memberDTO);
	public MemberDTO userCheck(MemberDTO memberDTO);
	public MemberDTO getMember(String id);
	public void updateMember(MemberDTO memberDTO);
	public void deleteMember(MemberDTO memberDTo);
	public List<MemberDTO> getMemberList();
}
