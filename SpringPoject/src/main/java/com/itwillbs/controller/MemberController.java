package com.itwillbs.controller;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//����: ������ Ʋ���� ���� @Controller�� �ִ� �����ּ� ��� Ʋ���� ��
	
	// �����ּ� http://localhost:8080/myweb/member/insertForm
	//		�ּҸ��� -> member/insertForm.jsp
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
		public String insertForm() {
		//ó���۾�
		
//		// �����ּҿ��� �ּҺ��� ���� �̵�
//		RequestDispatcher dispatcher=
//				request.getRequestDispatcher(forward.getPath());
//				dispatcher.forward(request, response);
	
		// WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	
		// �����ּҿ��� �ּҺ��� �ϸ鼭 �̵�(�����ּ� /member/login)
		// response.sendRedirect(forward.getPath());
//		return "redirect:/member/login";
	}
	
	// �����ּ� http://localhost:8080/myweb/member/insertPro
	//	      http://localhost:8080/member/insertPro
	// ���۹�� POST
	@RequestMapping(value="member/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		System.out.println("MemberController insertPro()");
		
		// �����ּҿ��� �ּҺ��� �ϸ鼭 �̵�(�����ּ� /member/login)
		// response.sendRedirect(forward.getPath());
		return "redirect:/member/login";
		
	}
	
	
	
	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login() {
		
		return "member/loginForm";
		
	}
	
	@RequestMapping(value="member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("MemberController loginPro()");
		
		return "redirect:/member/main";
		
	}
	
//	�ּҸ��� -> member/main.jsp
	
	@RequestMapping (value="/member/main", method= RequestMethod.GET)
	public String main() {
		
		return "member/main";
		
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
	
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String delete() {
		
		return "member/deleteForm";
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String list() {
		
		return "member/list";
	}
}

