package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO userChcek(MemberDTO memberDTO);
}
