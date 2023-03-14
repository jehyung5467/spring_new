package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
//	서블릿이 동작하기 전에 웹 애플리케이션 서버에서 
//  request, response 서버 내장객체 생성 => 서버 기억장소 할당
//  => request 기억장소에 안에 
//	=> 사용자가 입력한 파라미터 정보(태그 입력한 정보), 서버정보, 클라이언트정보, 세션정보, 쿠키정보 저장
	
	// 멤버변수  부모=자식 객체생성
	// MemberService 부모 = MemberServiceImpl 자식  객체생성 
//	MemberService memberService=new MemberServiceImpl();
	
	// 스프링 3버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// 스프링파일 root-context.xml 객체생성 
	// MemberController 파일에 멤버변수 memberService 전달
	
	// 멤버변수 데이터 은닉
//	private MemberService memberService;
	
	//멤버변수 값을 전달 생성자, set메서드 통해서 전달
	//생성자
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
	//set메서드
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	
	// 스프링 4버전 자동으로 객체생성
	// 멤버변수 부모 공통적인 틀 선언 => 데이터 은닉
	// @Inject 부모를 상속받은 자식클래스를 자동으로 찾아옴 
	// 데이터 은닉된 부모 인테페이스 멤버변수에 xml에서 객체생성해서 
	// set메서드 통해서 전달 => 생략
	@Inject
	private MemberService memberService;
	
	//가상주소 http://localhost:8080/myweb/member/insert
	// 자동으로 가상주소 뽑아옴 /member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// 주소변경 없이 이동
		// /WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	}
	
	//가상주소 http://localhost:8080/myweb/member/insertPro
	// 자동으로 가상주소 뽑아옴 /member/insertPro
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		// HttpServletRequest request
		// 사용자가 입력한 내용 => request에 저장 => request 가져오기
		// post방식 한글 깨지고 request.setCharacterEncoding("UTF-8")
		// web.xml에서 한글설정을 한번만하고 모든 곳에서 한글처리가 됨
		System.out.println("MemberController insertPro()");
		// 패키지 com.itwillbs.domain  MemberDTO 에 저장
//		MemberDTO memberDTO=new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setPass(request.getParameter("pass"));
//		memberDTO.setName(request.getParameter("name"));
		// 스프링에서 insertForm.jsp id,pass,name 태그이름 입력된값이 서버에 전달되면
		// request에 저장 => MemberDTO 객체생성 => 멤버변수  id,pass,name 이름이 동일하면 
		// 자동으로 setId(request.getParameter("id")) 메서드 호출되어지고 자동으로 동작해서 값 저장
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// MemberFrontController  주소매핑 호출
		// -> MemberInsertPro.java execute() 호출 
		// -> MemberDAO insertMember()
		
		//자바파일 메서드 호출 회원가입 처리 => MemberService 처리 => MemberDAO 디비
		// 주소매핑 MemberController  
		// -> 처리 패키지 com.itwillbs.service
		//    MemberService 인터페이스 MemberServiceImpl 클래스  insertMember()
		// -> 디비 패키지 com.itwillbs.dao
		//    MemberDAO 인터페이스 MemberDAOImpl 클래스 insertMember()
		
		// MemberService 부모 = MemberServiceImpl 자식  객체생성 
//		MemberService memberService=new MemberServiceImpl();
		
		// 메서드 호출
		memberService.insertMember(memberDTO);
		
		
		// 주소 변경되면서 로그인 페이지로 이동 
		// response.sendRedirect("/member/login");
		return "redirect:/member/login";
	}
	
	//가상주소 http://localhost:8080/myweb/member/login
	// 자동으로 가상주소 뽑아옴 /member/login
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// 주소변경 없이 이동
		// /WEB-INF/views/member/loginForm.jsp
		return "member/loginForm";
	}
	
	//가상주소 http://localhost:8080/myweb/member/loginPro
	// 자동으로 가상주소 뽑아옴 /member/loginPro
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		// 디비 로그인 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
//		System.out.println(memberDTO.getName());
		
		// MemberLoginPro.java execute() 대신 =>
		// MemberService 부모 = MemberServiceImpl 자식  객체생성 
//		MemberService memberService=new MemberServiceImpl();
		
		// 리턴할형 MemberDTO  userCheck(MemberDTO memberDTO ) 메서드 정의 
		// MemberDTO memberDTO2 = userCheck(memberDTO) 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 회원이 일치하다라는 표시 
			// => 페이지 상관없이 값이 계속 유지가 되도록 설정 
			// => 세션의 특징을 이용해서 => 세션기억장소 안에 유지할 값을 저장해 놓고 어디서나 사용가능
			// 세션객체 받아와서  세션사용
			session.setAttribute("id", memberDTO.getId());
			
			// 주소 변경되면서 로그인 페이지로 이동 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// 아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
//			member/msg.jsp 만들어서 
			// 아이디 비밀번호 틀림 메시지 출력, 뒤로이동
			return "member/msg";
		}
		

	}
	
	//가상주소 http://localhost:8080/myweb/member/main
	// 자동으로 가상주소 뽑아옴 /member/main
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// 주소변경 없이 이동
		// /WEB-INF/views/member/main.jsp
		return "member/main";
	}
	
	//가상주소 http://localhost:8080/myweb/member/logout
	// 자동으로 가상주소 뽑아옴 /member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
		// 세션 초기화
		session.invalidate();
		// 주소 변경되면서 로그인 페이지로 이동 
		// response.sendRedirect("/member/main");
		return "redirect:/member/main";
	}
	
	//가상주소 http://localhost:8080/myweb/member/info
	// 자동으로 가상주소 뽑아옴 /member/info
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session,Model model) {
		System.out.println("MemberController info()");
		//세션값 가져오기
		String id=(String)session.getAttribute("id");
		System.out.println("세션 id : " + id);
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		// memberDTO 를 들고 member/info.jsp 로 이동
//		request.setAttribute("memberDTO",memberDTO);
		// request 대신에 스프링 제공 Model 담아서 이동
		model.addAttribute("memberDTO", memberDTO);
		
		// 주소변경 없이 이동
		// /WEB-INF/views/member/info.jsp
		return "member/info";
	}
	
	//가상주소 http://localhost:8080/myweb/member/update
	// 자동으로 가상주소 뽑아옴 /member/update
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session,Model model) {
		System.out.println("MemberController update()");
		//세션값 가져오기
		String id=(String)session.getAttribute("id");
		System.out.println("세션 id : " + id);
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		// memberDTO 를 들고 member/updateForm.jsp 로 이동
//		request.setAttribute("memberDTO",memberDTO);
		// request 대신에 스프링 제공 Model 담아서 이동
		model.addAttribute("memberDTO", memberDTO);
		// 주소변경 없이 이동
		// /WEB-INF/views/member/updateForm.jsp
		return "member/updateForm";
	}
	
	//가상주소 http://localhost:8080/myweb/member/updatePro
	// 자동으로 가상주소 뽑아옴 /member/updatePro
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		// 디비 수정 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 수정작업
			memberService.updateMember(memberDTO);
			// 주소 변경되면서 로그인 페이지로 이동 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// 아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
//			member/msg.jsp 만들어서 
			// 아이디 비밀번호 틀림 메시지 출력, 뒤로이동
			return "member/msg";
		}
	}
	
	
	//가상주소 http://localhost:8080/myweb/member/delete
	// 자동으로 가상주소 뽑아옴 /member/delete
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// 주소변경 없이 이동
		// /WEB-INF/views/member/deleteForm.jsp
		return "member/deleteForm";
	}
	
	//가상주소 http://localhost:8080/myweb/member/deletePro
	// 자동으로 가상주소 뽑아옴 /member/deletePro
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		// 디비 삭제 처리 => 처리 => 디비 자바 메서드 호출
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
//		System.out.println(memberDTO.getName());
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//아이디 비밀번호 일치
			System.out.println("아이디 비밀번호 일치");
			// 삭제작업
			memberService.deleteMember(memberDTO);
			//세션 초기화
			session.invalidate();
			// 주소 변경되면서 로그인 페이지로 이동 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// 아이디 비밀번호 틀림
			System.out.println("아이디 비밀번호 틀림");
//			member/msg.jsp 만들어서 
			// 아이디 비밀번호 틀림 메시지 출력, 뒤로이동
			return "member/msg";
		}

	}
	
	//가상주소 http://localhost:8080/myweb/member/list
	// 자동으로 가상주소 뽑아옴 /member/list
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberDTO> memberList=memberService.getMemberList();
		
		model.addAttribute("memberList", memberList);
		
		// 주소변경 없이 이동
		// /WEB-INF/views/member/list.jsp
		return "member/list";
	}
	
	
}
