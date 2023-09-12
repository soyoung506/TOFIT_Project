package com.tofit.spring.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tofit.spring.admin.service.AdminService;
import com.tofit.spring.admin.vo.FitnessCenterVO;
import com.tofit.spring.admin.vo.PTmembershipVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

@Controller("adminController")
public class AdminControllerImpl implements AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private PTmembershipVO ptMembershipVO;
	@Autowired
	private FitnessCenterVO fitnessCenterVO;
	
	@Override
	@RequestMapping(value="/administration/ptAdmin.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ptAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean isLogon=false;
		HttpSession session=request.getSession(false);
		ModelAndView mav=new ModelAndView();
		if(session!=null) {
			isLogon=(Boolean)session.getAttribute("isLogon");
			if(isLogon) {
				List<PTmembershipVO> ptList=adminService.getPTmembership();
				List<FitnessCenterVO> cenList=adminService.getFitnessCenter();
				List<ProfileVO> coachList=adminService.getCoach();
				mav.addObject("ptList", ptList);
				mav.addObject("cenList", cenList);
				mav.addObject("coachList", coachList);
				String msg=request.getParameter("msg");
				if(msg=="add") {
					mav.addObject("msg", msg);
				}else if(msg=="disabled") {
					mav.addObject("msg", msg);
				}
				mav.setViewName("admin/ptAdmin");
			}else {
				mav.setViewName("mypage/home"); // indexd.jsp
			}
		}else {
			mav.setViewName("mypage/home"); // indexd.jsp
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/administration/ptDisabled.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ptDisabled(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean isLogon=false;
		HttpSession session=request.getSession(false);
		ModelAndView mav=new ModelAndView();
		if(session!=null) {
			isLogon=(Boolean)session.getAttribute("isLogon");
			if(isLogon) {
				int ptNo=Integer.parseInt(request.getParameter("ptNo"));
				adminService.setDisabledPT(ptNo);
				mav.addObject("msg", "disabled");
				mav.setViewName("redirect:/administration/ptAdmin.do");
			}else {
				mav.setViewName("mypage/home"); // indexd.jsp
			}
		}else {
			mav.setViewName("mypage/home"); // indexd.jsp
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/administration/ptAdd.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ptAdd(PTmembershipVO ptVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean isLogon=false;
		HttpSession session=request.getSession(false);
		ModelAndView mav=new ModelAndView();
		if(session!=null) {
			isLogon=(Boolean)session.getAttribute("isLogon");
			if(isLogon) {
				adminService.addPTmembership(ptVO);
				mav.addObject("msg", "add");
				mav.setViewName("redirect:/administration/ptAdmin.do");
			}else {
				mav.setViewName("mypage/home"); // indexd.jsp
			}
		}else {
			mav.setViewName("mypage/home"); // indexd.jsp
		}
		return mav;
	}



}


