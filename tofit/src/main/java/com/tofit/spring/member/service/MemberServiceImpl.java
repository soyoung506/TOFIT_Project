package com.tofit.spring.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.member.dao.MemberDAO;
import com.tofit.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List memberList = memberDAO.selectAllMemberList();
		return memberList;
	}

	@Override
	public void insertMember(MemberVO memVO) throws DataAccessException {
		memberDAO.insertMember(memVO);
		
	}

	@Override
	public void removeMember(String id) throws DataAccessException {
		memberDAO.deleteMember(id);
		
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		return memberDAO.loginCheck(memberVO);
	}

//	@Override
//	public MemberVO findMember(String id) throws DataAccessException {
//		MemberVO memVo = (MemberVO)memberDAO.findId(id);
//		return memVo;
//	}
	@Override
	public String findID(MemberVO memberVO) throws DataAccessException {
		String resultId=memberDAO.findID(memberVO);
		return resultId;
	}
	@Override
	public String findPWD(MemberVO memberVO) throws DataAccessException {
		String resultPwd=memberDAO.findPWD(memberVO);
		return resultPwd;
	}

	
	
}
