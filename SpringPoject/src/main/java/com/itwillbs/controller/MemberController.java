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
	//주의: 파일이 틀려도 같은 @Controller에 있는 가상주소 모두 틀려야 됨

	
//	MemberService 부모 = new MemberServiceImpl 자식 객체생성;
//	MemberService memberService = new MemberServiceImpl();
	
	// 스프링 3버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// 스프링파일 root-context.xml 객체생성
	// MemberController 파일에 멤버변수 memberService 전달
	
	// 멤버변수 데이터 은닉
	private MemberService memberService;
	
	// 멤버변수 값을 전달 생성자, set메서드 통해서 전달
	// 생성자
//	public MemberController(MemberService memberService) {
//		this.memberService=memberService;
//	}
	

	//set메서드
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	// 스프링 4버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// @Inject 부모를 상속받은 자식클래스를 자동으로 찾아옴
//	@Inject
//	private MemberService memberService;
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
		public String insertForm() {
		//처리작업
		return "member/insertForm";
	
	}
	
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
//		MemberService memberservice = new MemberServiceImpl();
		// 리턴할형 MemberDTO userCheck(MemberDTO memberDTO)메서드정의
		MemberDTO memberDTO2= memberService.userCheck(memberDTO);
		// MemberDTO memberDTO2 = userCheck(MemberDTO) 메서드호출

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

