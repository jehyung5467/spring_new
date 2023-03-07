package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	//����: ������ Ʋ���� ���� @Controller�� �ִ� �����ּ� ��� Ʋ���� ��

	
//	MemberService �θ� = new MemberServiceImpl �ڽ� ��ü����;
//	MemberService memberService = new MemberServiceImpl();
	
	// ������ 3���� �ڵ����� ��ü����
	// ������� �θ� �������� Ʋ ���� => ������ ����
	// ���������� root-context.xml ��ü����
	// MemberController ���Ͽ� ������� memberService ����
	
	// ������� ������ ����
	private MemberService memberService;
	
	// ������� ���� ���� ������, set�޼��� ���ؼ� ����
	// ������
//	public MemberController(MemberService memberService) {
//		this.memberService=memberService;
//	}
	

	//set�޼���
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	// ������ 4���� �ڵ����� ��ü����
	// ������� �θ� �������� Ʋ ���� => ������ ����
	// @Inject �θ� ��ӹ��� �ڽ�Ŭ������ �ڵ����� ã�ƿ�
//	@Inject
//	private MemberService memberService;
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
		public String insertForm() {
		//ó���۾�
		return "member/insertForm";
	
	}
	
	@RequestMapping(value="member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
//		System.out.println("MemberController insertPro()");
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
		//��Ű�� com.itwillbs.domain MemberDTO �� ����
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setId(request.getParameter("pass"));
//		memberDTO.setId(request.getParameter("name"));
		//���������� insertForm.jsp id,pass,name �±��̸� �ԷµȰ��� ������ ���޵Ǹ�
		// request�� ���� => MemberDTO ��ü���� => ������� id, pass, name �̸��� �����ϸ�
		// �ڵ����� setId(request.getParameter("id")) �޼��� ȣ��Ǽ� �ڵ����� �����ؼ� �� ����
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// MemberFrontController �ּҸ��� ȣ��
		// -> MemberInsertPro.java execute()ȣ�� 
		// -> MemberDAO insertMember()
		
		//�ڹ����� �޼��� ȣ�� ȸ������ ó�� => MemberService ó�� => MemberDAO ���
		// �ּҸ��� MemberController
		// -> ó�� ��Ű�� com.itwillbs.service
		//	 MemberService �������̽� MemberServiceImpl Ŭ���� insertMember()
		// -> ��� ��Ű�� com.itwillbs.dao
		//	 MemberDAO �������̽� MemberDAOImpl Ŭ���� insertMember()
		// �ż��� ȣ��
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";

	}
	
	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login() {
	
		return "member/loginForm";
	
	}
	
	@RequestMapping(value="member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO) {
		System.out.println("MemberController loginPro()");
		//��� �α��� ó�� => ó�� => ��� �ڹ� �޼��� ȣ��
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
//		MemberService memberservice = new MemberServiceImpl();
		// �������� MemberDTO userCheck(MemberDTO memberDTO)�޼�������
		MemberDTO memberDTO2= memberService.userCheck(memberDTO);
		// MemberDTO memberDTO2 = userCheck(MemberDTO) �޼���ȣ��

		return "redirect:/member/main";
	}
	
//	�ּҸ��� -> member/main.jsp
	
	@RequestMapping (value="/member/main", method= RequestMethod.GET)
	public String main() {
		
		return "member/main";
	}
	
	@RequestMapping (value="/member/logout", method= RequestMethod.GET)
	public String logout() {
		System.out.println("MemberController logout()");
		//���� �ʱ�ȭ
		
		return "redirect:/member/main";
		
	}
	
	// �ּҸ��� info,update,delete,list
	
	@RequestMapping (value="/member/info", method= RequestMethod.GET)
	public String info() {
		
		return "member/info";
		
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public String update() {
		
		return "member/updateForm";
	}
	
	@RequestMapping(value="member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		return "redirect:/member/main";
	}
	
	
	
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String delete() {
		
		return "member/deleteForm";
	}
	
	@RequestMapping(value="member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO) {
		System.out.println("MemberController deletePro()");
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		return "redirect:/member/main";
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String list() {
		
		return "member/list";
	}
}

