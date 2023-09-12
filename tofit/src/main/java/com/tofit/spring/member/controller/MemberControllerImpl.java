package com.tofit.spring.member.controller;

import java.util.List;

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

import com.tofit.spring.member.service.MemberService;
import com.tofit.spring.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl extends MultiActionController implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

	@RequestMapping(value = "/common/index.do", method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String msg = request.getParameter("msg");
		mav.addObject("msg", msg);
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/common/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public ModelAndView loginHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/member/kitlogin.do", method = RequestMethod.GET)
	public ModelAndView loginForm(@RequestParam(value="action", required = false) String action, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session=request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/member/kitresister.do", method = RequestMethod.GET)
	public ModelAndView resisterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/member/searchpwd.do", method = RequestMethod.GET)
	public ModelAndView searchpwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.insertMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/kitlogin.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList", memberList);
		return mav;
	}

	@RequestMapping(value = "/member/loginfail.do", method = RequestMethod.GET)
	public ModelAndView loginfail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList", memberList);
		return mav;

	}

	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberVO memberVO, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(memberVO);
		if (memberVO != null) {
			String id=memberVO.getId();
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogon", "true");
			session.setAttribute("log_id", id);
			String action=(String)session.getAttribute("action");
			session.removeAttribute("action");
			System.out.println(action);
			if(action!=null) {
				mav.setViewName("redirect:"+action);
			}else {
				mav.setViewName("redirect:/common/index.do");
			}
		} else {
			mav.setViewName("redirect:/member/loginfail.do");
		}
		return mav;

	}

	@Override
	@RequestMapping(value = "/member/findID.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		memberVO.setName(name);
		memberVO.setEmail(email);
		System.out.println(name);
		System.out.println(email);
		String resultId = memberService.findID(memberVO);
		if (resultId == "noMember") {
			mav.addObject("msg", "noMember");
		} else {
			mav.addObject("id", resultId);
			mav.addObject("msg", "findid");
		}
		mav.setViewName("member/searchpwd");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/findPWD.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findPWD(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		memberVO.setName(name);
		memberVO.setId(id);
		memberVO.setPhone(phone);
		String resultPwd = memberService.findPWD(memberVO);
		if (resultPwd == "noMember") {
			mav.addObject("msg", "noMember");
		} else {
			mav.addObject("pwd", resultPwd);
			mav.addObject("msg", "findpwd");
		}
		mav.setViewName("member/searchpwd");

		return mav;
	}

}
