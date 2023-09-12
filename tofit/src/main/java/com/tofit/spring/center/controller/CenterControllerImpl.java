package com.tofit.spring.center.controller;

import java.util.HashMap;
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

import com.tofit.spring.center.service.CenterService;
import com.tofit.spring.center.vo.CenterVO;

@Controller("centerController")
public class CenterControllerImpl extends MultiActionController implements CenterController {

	@Autowired
	private CenterService centerService;
	@Autowired
	private CenterVO centerVO;

	@Override
	@RequestMapping(value = "/center/centerMain.do", method = RequestMethod.GET)
	public ModelAndView listCenter(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "cenName", required = false) String cenName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		String msg = request.getParameter("msg");
		if (city == null || city.equals("")) {
			city = "전체";
		}
		System.out.println(city);
		System.out.println(cenName);
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		int section = Integer.parseInt((_section == null) ? "1" : _section);
		int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
		Map pagingMap = new HashMap();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		pagingMap.put("city", city);
		pagingMap.put("cenName", cenName);
		Map cenMap = null;
		if (city.equals("전체")) {
			cenMap = centerService.getCen(pagingMap);
		} else {
			cenMap = centerService.getCenCity(pagingMap);
		}
		cenMap.put("section", section);
		cenMap.put("pageNum", pageNum);
		cenMap.put("city", city);
		mav.addObject("cenMap", cenMap);
		mav.addObject("msg", msg);
		return mav;
	}

	@Override
	@RequestMapping(value = "/center/moreCenter.do", method = RequestMethod.GET)
	public ModelAndView moreCenter(@RequestParam("cenNumber") String cenNumber, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		Map cenDetailMap = centerService.listCenterMore(cenNumber);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("cenDetailMap", cenDetailMap);
		return mav;
	}

	@Override
	@RequestMapping(value = "/center/addCenter.do", method = RequestMethod.POST)
	public ModelAndView addCenter(@ModelAttribute("centerVO") CenterVO centerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		centerService.insertCenter(centerVO);
		ModelAndView mav = new ModelAndView("redirect:/center/centerMain.do");

		return mav;
	}

	@RequestMapping(value = "/center/insertCenter.do", method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/center/ptPurchase.do", method = RequestMethod.GET)
	public ModelAndView ptPurchase(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			int ptNo = Integer.parseInt(request.getParameter("ptNo"));
			Map ptPurMap = new HashMap();
			ptPurMap.put("ptNo", ptNo);
			ptPurMap.put("id", log_id);
			centerService.ptPurchase(ptPurMap);
			redirectAttributes.addAttribute("msg", "purchase");
			mav.setViewName("redirect:/center/centerMain.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

}
