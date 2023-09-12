package com.tofit.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> memberList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}

	@Override
	public void insertMember(MemberVO memVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertMember",memVO);
		
	}

//	@Override
//	public MemberVO findId(String id) throws DataAccessException {
//		MemberVO memVO = (MemberVO)sqlSession.selectOne("mapper.member.findMember",id);
//		return memVO;
//	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		sqlSession.delete("mapper.member.deleteMember", id);
		
	}
	@Override
	public MemberVO loginCheck(MemberVO memberVO) throws DataAccessException {
		MemberVO member=sqlSession.selectOne("mapper.member.loginById", memberVO);
		return member;
	}
	@Override
	public String findID(MemberVO memberVO) throws DataAccessException {
		String resultId=null;
		String result=sqlSession.selectOne("mapper.member.findID_EN", memberVO);
		if(result.equals("true")) {
			resultId=sqlSession.selectOne("mapper.member.findID_ID", memberVO);
		}else {
			resultId="noMember";
		}
		return resultId;
	}
	@Override
	public String findPWD(MemberVO memberVO) throws DataAccessException {
		String resultPwd=null;
		String result=sqlSession.selectOne("mapper.member.findPWD_ENI", memberVO);
		if(result.equals("true")) {
			resultPwd=sqlSession.selectOne("mapper.member.findPWD_PWD", memberVO);
		}else {
			resultPwd="noMember";
		}
		return resultPwd;
	}


}
