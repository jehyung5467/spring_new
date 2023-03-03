package com.itwillbs.controller;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//주의: 파일이 틀려도 같은 @Controller에 있는 가상주소 모두 틀려야 됨
	
	// 가상주소 http://localhost:8080/myweb/member/insertForm
	//		주소매핑 -> member/insertForm.jsp
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
		public String insertForm() {
		//처리작업
		
//		// 가상주소에서 주소변경 없이 이동
//		RequestDispatcher dispatcher=
//				request.getRequestDispatcher(forward.getPath());
//				dispatcher.forward(request, response);
	
		// WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	
		// 가상주소에서 주소변경 하면서 이동(가상주소 /member/login)
		// response.sendRedirect(forward.getPath());
//		return "redirect:/member/login";
	}
	
	// 가상주소 http://localhost:8080/myweb/member/insertPro
	//	      http://localhost:8080/member/insertPro
	// 전송방식 POST
	@RequestMapping(value="member/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		System.out.println("MemberController insertPro()");
		
		// 가상주소에서 주소변경 하면서 이동(가상주소 /member/login)
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
	
//	주소매핑 -> member/main.jsp
	
	@RequestMapping (value="/member/main", method= RequestMethod.GET)
	public String main() {
		
		return "member/main";
		
	}
	
	// 주소매핑 info,update,delete,list
	
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

