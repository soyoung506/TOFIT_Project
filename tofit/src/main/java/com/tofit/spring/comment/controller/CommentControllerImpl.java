package com.tofit.spring.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.comment.service.CommentService;
import com.tofit.spring.comment.vo.CommentVO;

@Controller("commentController")
public class CommentControllerImpl implements CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentVO commentVO;

	
	//´ñ±Û´Þ±â
	@Override
	@RequestMapping(value="/comment/insertComment.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insertComment(@ModelAttribute("commentVO") CommentVO commentVO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			int commuNo=Integer.parseInt(request.getParameter("commuNo"));
			String log_id=(String)session.getAttribute("log_id");
			commentVO.setCommentID(log_id);
			commentService.insertComment(commentVO);
			redirectAttributes.addAttribute("commuNo", commuNo);
			mav.setViewName("redirect:/community/viewArticle.do");
		}else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}
	
	//´ñ±Û ¼öÁ¤
	@Override
	@RequestMapping(value="/comment/updateComment.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateComment(@ModelAttribute("commentVO") CommentVO commentVO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			int commentNo=commentVO.getCommentNo();
			String commentId=commentService.getCommentId(commentNo);
			int commuNo=Integer.parseInt(request.getParameter("commuNo"));
			if(log_id.equals(commentId)) {
				commentService.updateComment(commentVO);
				redirectAttributes.addAttribute("msg","modiComment");
			}else {
				redirectAttributes.addAttribute("msg","modiFailedComment");
			}
			redirectAttributes.addAttribute("commuNo", commuNo);
			mav.setViewName("redirect:/community/viewArticle.do");
		}else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}
	
	//´ñ±Û »èÁ¦
	@Override
	@RequestMapping(value="/comment/deleteComment.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(@RequestParam("commentNo") int commentNo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String commentId=commentService.getCommentId(commentNo);
			int commuNo=Integer.parseInt(request.getParameter("commuNo"));
			if(log_id.equals(commentId)) {
				commentService.deleteComment(commentNo);
				redirectAttributes.addAttribute("msg","removeComment");
			}else {
				redirectAttributes.addAttribute("msg","removeFailedComment");
			}
			redirectAttributes.addAttribute("commuNo", commuNo);
			mav.setViewName("redirect:/community/viewArticle.do");
		}else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
		
		
		
		
	}
}
		