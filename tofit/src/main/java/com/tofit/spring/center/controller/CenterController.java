package com.tofit.spring.center.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.center.vo.CenterVO;
import com.tofit.spring.member.vo.MemberVO;

public interface CenterController {
	public ModelAndView listCenter(@RequestParam(value="city", required = false) String city, @RequestParam(value="cenName", required = false) String cenName, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView moreCenter(@RequestParam("cenNumber") String cenNumber,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addCenter(@ModelAttribute("centerVO") CenterVO centerVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ptPurchase(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	
}
