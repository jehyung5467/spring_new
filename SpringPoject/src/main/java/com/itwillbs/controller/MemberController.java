package com.itwillbs.controller;

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
	//주의: 파일이 틀려도 같은 @Controller에 있는 가상주소 모두 틀려야 됨
	
	// 가상주소 http://localhost:8080/myweb/member/insertForm
	//		주소매핑 -> member/insertForm.jsp
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
		public String insertForm() {
		//처리작업
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
	public String insertPro(MemberDTO memberDTO) {
//		System.out.println("MemberController insertPro()");
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pass"));
//		System.out.println(request.getParameter("name"));
		//패키지 com.itwillbs.domain MemberDTO 에 저장
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setId(request.getParameter("pass"));
//		memberDTO.setId(request.getParameter("name"));
		//스프링에서 insertForm.jsp id,pass,name 태그이름 입력된값이 서버에 전달되면
		// request에 저장 => MemberDTO 객체생성 => 멤버변수 id, pass, name 이름이 동일하면
		// 자동으로 setId(request.getParameter("id")) 메서드 호출되서 자동으로 동작해서 값 저장
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// MemberFrontController 주소매핑 호출
		// -> MemberInsertPro.java execute()호출 
		// -> MemberDAO insertMember()
		
		//자바파일 메서드 호출 회원가입 처리 => MemberService 처리 => MemberDAO 디비
		// 주소매핑 MemberController
		// -> 처리 패키지 com.itwillbs.service
		//	 MemberService 인터페이스 MemberServiceImpl 클래스 insertMember()
		// -> 디비 패키지 com.itwillbs.dao
		//	 MemberDAO 인터페이스 MemberDAOImpl 클래스 insertMember()
		
		// MemberService 부모 = MemberServiceImpl 자식 객체생성
		MemberService memberService = new MemberServiceImpl();
		// 매서드 호출
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
		//디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		return "redirect:/member/main";
	}
	
//	주소매핑 -> member/main.jsp
	
	@RequestMapping (value="/member/main", method= RequestMethod.GET)
	public String main() {
		
		return "member/main";
	}
	
	@RequestMapping (value="/member/logout", method= RequestMethod.GET)
	public String logout() {
		System.out.println("MemberController logout()");
		//세션 초기화
		
		return "redirect:/member/main";
		
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

