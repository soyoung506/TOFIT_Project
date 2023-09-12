package com.tofit.spring.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tofit.spring.admin.vo.PTmembershipVO;

public interface AdminController {
	
	public ModelAndView ptAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ptDisabled(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ptAdd(@ModelAttribute("ptMembershipVO") PTmembershipVO ptVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
