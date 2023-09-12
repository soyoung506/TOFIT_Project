package com.tofit.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;
	public void insertMember(MemberVO memVo) throws DataAccessException;
	public void removeMember(String id) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
	// public MemberVO findMember(String id) throws DataAccessException;
	public String findID(MemberVO memberVO) throws DataAccessException;
	public String findPWD(MemberVO memberVO) throws DataAccessException;



}
