package com.itwillbs.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

//@Inject
//private MemberDAO memberDAO;
// => �ڵ����� @Repository ���ǵ� �ڽ�Ŭ���� ã�Ƽ� ��ü���� 

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	//���̹�Ƽ�� ��񿬰� ��ü����
	//���� �������
	//  @Inject => root-context.xml ���Ͽ� ��ü������ "sqlSession" ã�Ƽ� �ڵ����� ������
	@Inject
	private SqlSession sqlSession;

	//��񿬰� ��ü����
	//���� �������
//	private DataSource dataSource;
//	private SimpleJdbcTemplate template;
	
//	import javax.sql.DataSource;
	//set�޼���
//	@Inject
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		template=new SimpleJdbcTemplate(dataSource);
//	}
	
	private static final String namespace="com.itwillbs.mappers.memberMapper";
//	String sql="insert into members(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO memberDTO) {
		// ����۾� 
		System.out.println("MemberDAOImpl insertMember()");
		
//		import java.sql.Timestamp;
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		//  src/main/resources ���� mappers ���� memberMapper.xml 
		//  namespace="com.itwillbs.mappers.memberMapper" �̸��� �ҷ��� ���
		//  MyBatis sql���� ȣ���ؼ� ���
//		sqlSession.insert(sql�����̸�, ?ǥ�� �Էµɰ�memberDTO);
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
//		template.update(sql, memberDTO.getId(), memberDTO.getPass(),
//				memberDTO.getName(), memberDTO.getDate());
	}



	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl userCheck()");
		// selectOne ���ϰ��� MemberDTO �ϳ��϶� ��� 
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}



	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAOImpl getMember()");
		
		return sqlSession.selectOne(namespace+".getMember", id);
	}



	@Override
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl updateMember()");
		
		 sqlSession.selectOne(namespace+".updateMember", memberDTO);
	}



	@Override
	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl updateMember()");
		
		 sqlSession.selectOne(namespace+".deleteMember", memberDTO);
	}



	@Override
	public List<MemberDTO> getMemberList() {
		System.out.println("MemberDAOImpl getMemberList()");
		//selectList
		return sqlSession.selectList(namespace+".getMemberList");
	}



	

}
