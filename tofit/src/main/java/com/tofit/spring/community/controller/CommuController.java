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

	//�۸�� ����
	public ModelAndView listCommu(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//�ۻ� ����
	public ModelAndView viewArticle(@RequestParam("commuNo") int commuNo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//���߰� �ϱ�
	public ModelAndView addCommu(@ModelAttribute("commuVO") CommuVO commuVO ,HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	//�ۼ��� �ϱ�
	public ModelAndView modArticle(@ModelAttribute("commuVO") CommuVO commuVO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	
	//�ۻ���
	public ModelAndView removeArticle(@RequestParam("commuNo") int commuNo, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
