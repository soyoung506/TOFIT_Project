package com.tofit.spring.mypage.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.mypage.profile.vo.ProfileVO;


public interface ProfileController {
	public ModelAndView profileInfo(@RequestParam("section") String _section, @RequestParam("pageNum") String _pageNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView gotoModi(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView checkUser(@ModelAttribute("profileVO") ProfileVO profileVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity modProfile(MultipartHttpServletRequest multipartRequest, @ModelAttribute("profileVO") ProfileVO profileVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeUser(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
}
