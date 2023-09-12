package com.tofit.spring.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.comment.service.CommentService;
import com.tofit.spring.community.service.CommuService;
import com.tofit.spring.community.vo.CommuVO;

@Controller("commuController")
public class CommuControllerImpl extends MultiActionController implements CommuController {
	@Autowired
	private CommuService commuService;

	@Autowired
	private CommuVO commuVO;

	@Autowired
	private CommentService commentService;

	// 글목록 보기
	@Override
	@RequestMapping(value = "/community/listCommu.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listCommu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		int section = Integer.parseInt((_section == null) ? "1" : _section);
		int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
		Map<String, Integer> pagingMap = new HashMap<String, Integer>();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		Map<String, Integer> articleMap = commuService.listCommu(pagingMap);
		articleMap.put("section", section);
		articleMap.put("pageNum", pageNum);
		ModelAndView mav = new ModelAndView(viewName);
		String msg=request.getParameter("msg");
		mav.addObject("msg", msg);
		mav.addObject("articleMap", articleMap);
		return mav;
	}

	@RequestMapping(value = "/community/commuForm.do", method = { RequestMethod.GET, RequestMethod.POST })
	private ModelAndView commuForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		if (session != null && session.getAttribute("isLogon") == "true") {
			mav.setViewName(viewName);
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 글상세 보기
	@Override
	@RequestMapping(value = "/community/viewArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView viewArticle(@RequestParam("commuNo") int commuNo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		if (session != null && session.getAttribute("isLogon") == "true") {
			commuVO = commuService.viewArticle(commuNo);
			commuService.addView(commuNo);
			List commentList = commuService.getCommentList(commuNo);
			mav.setViewName(viewName);
			mav.addObject("commu", commuVO);
			mav.addObject("commentList", commentList);
			String msg=request.getParameter("msg");
			mav.addObject("msg", msg);
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}

		return mav;
	}

	// 글추가 하기
	@Override
	@RequestMapping(value = "/community/addCommu.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addCommu(@ModelAttribute("commuVO") CommuVO commuVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			commuVO.setUserid(log_id);
			commuService.addCommu(commuVO);
			mav.setViewName("redirect:/community/listCommu.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 글삭제
	@Override
	@RequestMapping(value = "/community/removeArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView removeArticle(@RequestParam("commuNo") int commuNo, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			commuVO = commuService.viewArticle(commuNo);
			String commuId=commuVO.getUserid();
			if(log_id.equals(commuId)) {
				commuService.removeArticle(commuNo);
				commentService.removeChildComment(commuNo);
				rAttr.addAttribute("msg","remove");
				mav.setViewName("redirect:/community/listCommu.do");
			}else {
				rAttr.addAttribute("msg","removeFailed");
				mav.setViewName("redirect:/community/listCommu.do");
			}
		}else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// 글수정
	@Override
	@RequestMapping(value = "/community/modArticle.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView modArticle(@ModelAttribute("commuVO") CommuVO commuVO, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			int commuNo = Integer.parseInt(request.getParameter("commuNo"));
			String log_id = (String) session.getAttribute("log_id");
			CommuVO commuVO2 = commuService.viewArticle(commuNo);
			String commuId=commuVO2.getUserid();
			if(log_id.equals(commuId)) {
				commuService.modArticle(commuVO);
				redirectAttributes.addAttribute("msg","modi");
			}else {
				redirectAttributes.addAttribute("msg","modiFailed");
			}
			redirectAttributes.addAttribute("commuNo", commuNo);
			mav.setViewName("redirect:/community/viewArticle.do");
		}else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
		
		
		
	}
}
