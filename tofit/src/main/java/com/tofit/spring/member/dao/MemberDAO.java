package com.tofit.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	public void insertMember(MemberVO memVO) throws DataAccessException;
	//public MemberVO findId (String id) throws DataAccessException;
	public void deleteMember(String id) throws DataAccessException; 
	public MemberVO loginCheck(MemberVO memberVO) throws DataAccessException;
	public String findID(MemberVO memberVO) throws DataAccessException;
	public String findPWD(MemberVO memberVO) throws DataAccessException;

	
}
