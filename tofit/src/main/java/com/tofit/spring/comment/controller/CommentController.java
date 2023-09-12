package com.tofit.spring.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

public interface CommentController {

	public ModelAndView insertComment (@ModelAttribute("commentVO") CommentVO commentVO ,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	public ModelAndView updateComment (@ModelAttribute("commentVO") CommentVO commentVO ,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	public ModelAndView deleteComment (@RequestParam("commentVO") int commentNo ,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
}
