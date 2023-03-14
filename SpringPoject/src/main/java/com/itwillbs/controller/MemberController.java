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
//	������ �����ϱ� ���� �� ���ø����̼� �������� 
//  request, response ���� ���尴ü ���� => ���� ������ �Ҵ�
//  => request �����ҿ� �ȿ� 
//	=> ����ڰ� �Է��� �Ķ���� ����(�±� �Է��� ����), ��������, Ŭ���̾�Ʈ����, ��������, ��Ű���� ����
	
	// �������  �θ�=�ڽ� ��ü����
	// MemberService �θ� = MemberServiceImpl �ڽ�  ��ü���� 
//	MemberService memberService=new MemberServiceImpl();
	
	// ������ 3���� �ڵ����� ��ü����
	// ������� �θ� �������� Ʋ ���� => ������ ����
	// ���������� root-context.xml ��ü���� 
	// MemberController ���Ͽ� ������� memberService ����
	
	// ������� ������ ����
//	private MemberService memberService;
	
	//������� ���� ���� ������, set�޼��� ���ؼ� ����
	//������
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
	//set�޼���
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	
	// ������ 4���� �ڵ����� ��ü����
	// ������� �θ� �������� Ʋ ���� => ������ ����
	// @Inject �θ� ��ӹ��� �ڽ�Ŭ������ �ڵ����� ã�ƿ� 
	// ������ ���е� �θ� �������̽� ��������� xml���� ��ü�����ؼ� 
	// set�޼��� ���ؼ� ���� => ����
	@Inject
	private MemberService memberService;
	
	//�����ּ� http://localhost:8080/myweb/member/insert
	// �ڵ����� �����ּ� �̾ƿ� /member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/insertPro
	// �ڵ����� �����ּ� �̾ƿ� /member/insertPro
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		// HttpServletRequest request
		// ����ڰ� �Է��� ���� => request�� ���� => request ��������
		// post��� �ѱ� ������ request.setCharacterEncoding("UTF-8")
		// web.xml���� �ѱۼ����� �ѹ����ϰ� ��� ������ �ѱ�ó���� ��
		System.out.println("MemberController insertPro()");
		// ��Ű�� com.itwillbs.domain  MemberDTO �� ����
//		MemberDTO memberDTO=new MemberDTO();
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setPass(request.getParameter("pass"));
//		memberDTO.setName(request.getParameter("name"));
		// ���������� insertForm.jsp id,pass,name �±��̸� �ԷµȰ��� ������ ���޵Ǹ�
		// request�� ���� => MemberDTO ��ü���� => �������  id,pass,name �̸��� �����ϸ� 
		// �ڵ����� setId(request.getParameter("id")) �޼��� ȣ��Ǿ����� �ڵ����� �����ؼ� �� ����
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		// MemberFrontController  �ּҸ��� ȣ��
		// -> MemberInsertPro.java execute() ȣ�� 
		// -> MemberDAO insertMember()
		
		//�ڹ����� �޼��� ȣ�� ȸ������ ó�� => MemberService ó�� => MemberDAO ���
		// �ּҸ��� MemberController  
		// -> ó�� ��Ű�� com.itwillbs.service
		//    MemberService �������̽� MemberServiceImpl Ŭ����  insertMember()
		// -> ��� ��Ű�� com.itwillbs.dao
		//    MemberDAO �������̽� MemberDAOImpl Ŭ���� insertMember()
		
		// MemberService �θ� = MemberServiceImpl �ڽ�  ��ü���� 
//		MemberService memberService=new MemberServiceImpl();
		
		// �޼��� ȣ��
		memberService.insertMember(memberDTO);
		
		
		// �ּ� ����Ǹ鼭 �α��� �������� �̵� 
		// response.sendRedirect("/member/login");
		return "redirect:/member/login";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/login
	// �ڵ����� �����ּ� �̾ƿ� /member/login
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/loginForm.jsp
		return "member/loginForm";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/loginPro
	// �ڵ����� �����ּ� �̾ƿ� /member/loginPro
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		// ��� �α��� ó�� => ó�� => ��� �ڹ� �޼��� ȣ��
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
//		System.out.println(memberDTO.getName());
		
		// MemberLoginPro.java execute() ��� =>
		// MemberService �θ� = MemberServiceImpl �ڽ�  ��ü���� 
//		MemberService memberService=new MemberServiceImpl();
		
		// �������� MemberDTO  userCheck(MemberDTO memberDTO ) �޼��� ���� 
		// MemberDTO memberDTO2 = userCheck(memberDTO) �޼��� ȣ��
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//���̵� ��й�ȣ ��ġ
			System.out.println("���̵� ��й�ȣ ��ġ");
			// ȸ���� ��ġ�ϴٶ�� ǥ�� 
			// => ������ ������� ���� ��� ������ �ǵ��� ���� 
			// => ������ Ư¡�� �̿��ؼ� => ���Ǳ����� �ȿ� ������ ���� ������ ���� ��𼭳� ��밡��
			// ���ǰ�ü �޾ƿͼ�  ���ǻ��
			session.setAttribute("id", memberDTO.getId());
			
			// �ּ� ����Ǹ鼭 �α��� �������� �̵� 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// ���̵� ��й�ȣ Ʋ��
			System.out.println("���̵� ��й�ȣ Ʋ��");
//			member/msg.jsp ���� 
			// ���̵� ��й�ȣ Ʋ�� �޽��� ���, �ڷ��̵�
			return "member/msg";
		}
		

	}
	
	//�����ּ� http://localhost:8080/myweb/member/main
	// �ڵ����� �����ּ� �̾ƿ� /member/main
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/main.jsp
		return "member/main";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/logout
	// �ڵ����� �����ּ� �̾ƿ� /member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("MemberController logout()");
		// ���� �ʱ�ȭ
		session.invalidate();
		// �ּ� ����Ǹ鼭 �α��� �������� �̵� 
		// response.sendRedirect("/member/main");
		return "redirect:/member/main";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/info
	// �ڵ����� �����ּ� �̾ƿ� /member/info
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session,Model model) {
		System.out.println("MemberController info()");
		//���ǰ� ��������
		String id=(String)session.getAttribute("id");
		System.out.println("���� id : " + id);
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		// memberDTO �� ��� member/info.jsp �� �̵�
//		request.setAttribute("memberDTO",memberDTO);
		// request ��ſ� ������ ���� Model ��Ƽ� �̵�
		model.addAttribute("memberDTO", memberDTO);
		
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/info.jsp
		return "member/info";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/update
	// �ڵ����� �����ּ� �̾ƿ� /member/update
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session,Model model) {
		System.out.println("MemberController update()");
		//���ǰ� ��������
		String id=(String)session.getAttribute("id");
		System.out.println("���� id : " + id);
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		// memberDTO �� ��� member/updateForm.jsp �� �̵�
//		request.setAttribute("memberDTO",memberDTO);
		// request ��ſ� ������ ���� Model ��Ƽ� �̵�
		model.addAttribute("memberDTO", memberDTO);
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/updateForm.jsp
		return "member/updateForm";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/updatePro
	// �ڵ����� �����ּ� �̾ƿ� /member/updatePro
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro()");
		// ��� ���� ó�� => ó�� => ��� �ڹ� �޼��� ȣ��
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
		System.out.println(memberDTO.getName());
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//���̵� ��й�ȣ ��ġ
			System.out.println("���̵� ��й�ȣ ��ġ");
			// �����۾�
			memberService.updateMember(memberDTO);
			// �ּ� ����Ǹ鼭 �α��� �������� �̵� 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// ���̵� ��й�ȣ Ʋ��
			System.out.println("���̵� ��й�ȣ Ʋ��");
//			member/msg.jsp ���� 
			// ���̵� ��й�ȣ Ʋ�� �޽��� ���, �ڷ��̵�
			return "member/msg";
		}
	}
	
	
	//�����ּ� http://localhost:8080/myweb/member/delete
	// �ڵ����� �����ּ� �̾ƿ� /member/delete
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/deleteForm.jsp
		return "member/deleteForm";
	}
	
	//�����ּ� http://localhost:8080/myweb/member/deletePro
	// �ڵ����� �����ּ� �̾ƿ� /member/deletePro
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		// ��� ���� ó�� => ó�� => ��� �ڹ� �޼��� ȣ��
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPass());
//		System.out.println(memberDTO.getName());
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2 != null) {
			//���̵� ��й�ȣ ��ġ
			System.out.println("���̵� ��й�ȣ ��ġ");
			// �����۾�
			memberService.deleteMember(memberDTO);
			//���� �ʱ�ȭ
			session.invalidate();
			// �ּ� ����Ǹ鼭 �α��� �������� �̵� 
			// response.sendRedirect("/member/main");
			return "redirect:/member/main";
		}else {
			// ���̵� ��й�ȣ Ʋ��
			System.out.println("���̵� ��й�ȣ Ʋ��");
//			member/msg.jsp ���� 
			// ���̵� ��й�ȣ Ʋ�� �޽��� ���, �ڷ��̵�
			return "member/msg";
		}

	}
	
	//�����ּ� http://localhost:8080/myweb/member/list
	// �ڵ����� �����ּ� �̾ƿ� /member/list
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberDTO> memberList=memberService.getMemberList();
		
		model.addAttribute("memberList", memberList);
		
		// �ּҺ��� ���� �̵�
		// /WEB-INF/views/member/list.jsp
		return "member/list";
	}
	
	
}
