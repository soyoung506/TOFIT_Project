package com.tofit.spring.community.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.community.vo.CommuVO;

public interface CommuController {

	//글목록 보기
	public ModelAndView listCommu(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//글상세 보기
	public ModelAndView viewArticle(@RequestParam("commuNo") int commuNo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//글추가 하기
	public ModelAndView addCommu(@ModelAttribute("commuVO") CommuVO commuVO ,HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	//글수정 하기
	public ModelAndView modArticle(@ModelAttribute("commuVO") CommuVO commuVO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	
	//글삭제
	public ModelAndView removeArticle(@RequestParam("commuNo") int commuNo, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
