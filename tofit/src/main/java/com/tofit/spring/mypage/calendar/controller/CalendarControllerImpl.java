package com.tofit.spring.mypage.calendar.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.mypage.calendar.service.CalendarService;
import com.tofit.spring.mypage.calendar.vo.CalendarVO;

@Controller("calendarController")
public class CalendarControllerImpl implements CalendarController {
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private CalendarVO calendarVO;

	// PT 예약현황
	@Override
	@RequestMapping(value = "/reserve/reserveInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView reserveInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String user = calendarService.getUser(log_id);
			if (user.equals("user")) {
				List<CalendarVO> reserveList = calendarService.getReserveInfo(log_id);
				boolean result = calendarService.getPTmembership(log_id);
				mav.addObject("reserveList", reserveList);
				mav.addObject("ptResult", result);
				System.out.println(result);
			} else if (user.equals("coach")) {
				List<CalendarVO> reserveList = calendarService.getReserveInfoC(log_id);
				mav.addObject("reserveList", reserveList);
				mav.addObject("ptResult", user);
			}
			String msg = request.getParameter("msg");
			mav.addObject("msg", msg);
			mav.setViewName("mypage/sub_mypage01");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// PT시간 예약/설정 페이지 로드
	@Override
	@RequestMapping(value = "/reserve/gotoReservePT.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gotoReservePT(String ptDate, String chooseDate, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String user = calendarService.getUser(log_id);
			if (ptDate == null) {
				ptDate = "0";
			}
			Map<String, String> dateMap = new HashMap<String, String>();
			dateMap.put("id", log_id);
			dateMap.put("ptDate", ptDate);
			if (user.equals("user")) {
				List<String> disabledTimes = calendarService.getTimes(dateMap);
				mav.addObject("disabledTimes", disabledTimes);

			} else if (user.equals("coach")) {
				List<String> disabledTimes = calendarService.getTimesC(dateMap);
				mav.addObject("disabledTimes", disabledTimes);
			}
			mav.addObject("chooseDate", chooseDate);
			mav.addObject("ptDate", ptDate);
			mav.addObject("user", user);
			mav.setViewName("mypage/sub_mypage01_PTReservation");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// PT 시간 예약/설정
	@Override
	@RequestMapping(value = "/reserve/reservePT.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView reservePT(CalendarVO calendarVO, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String user = calendarService.getUser(log_id);
			calendarVO.setId(log_id);
			if (user.equals("user")) {
				calendarService.addReservation(calendarVO);
				redirectAttributes.addAttribute("msg", "reserve");

			} else if (user.equals("coach")) {
				calendarService.addReservationC(calendarVO);
				redirectAttributes.addAttribute("msg", "exemption");
			}
			mav.setViewName("redirect:/reserve/reserveInfo.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// PT 예약 취소 페이지 로드
	@Override
	@RequestMapping(value = "/reserve/gotoReserveCancel.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gotoReserveCancel(String _section, String _pageNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String user = calendarService.getUser(log_id);
			int section = Integer.parseInt((_section == null) ? "1" : _section);
			int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
			Map pagingMap = new HashMap();
			pagingMap.put("section", section);
			pagingMap.put("pageNum", pageNum);
			pagingMap.put("id", log_id);
			Map reserveMap = new HashMap();
			if (user.equals("user")) {
				reserveMap = calendarService.getReserveDetail(pagingMap);
			} else if (user.equals("coach")) {
				reserveMap = calendarService.getReserveDetailC(pagingMap);
			}
			reserveMap.put("section", section);
			reserveMap.put("pageNum", pageNum);
			String msg = request.getParameter("msg");
			mav.addObject("msg", msg);
			mav.addObject("reserveMap", reserveMap);
			mav.addObject("user", user);
			mav.setViewName("mypage/sub_mypage01_PTCancel");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	// PT 예약 취소
	@Override
	@RequestMapping(value = "/reserve/reserveCancel.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView reserveCancel(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			String user = calendarService.getUser(log_id);
			String[] ptNumS = request.getParameterValues("checkedRV");
			int[] ptNumI = new int[ptNumS.length];
			for (int i = 0; i < ptNumS.length; i++) {
				ptNumI[i] = Integer.parseInt(ptNumS[i]);
			}
			if (user.equals("user")) {
				for (int ptNum : ptNumI) {
					calendarService.cancelRerservation(ptNum);
				}
				redirectAttributes.addAttribute("msg", "cancel");
			} else if (user.equals("coach")) {
				for (int ptNum : ptNumI) {
					calendarService.cancelRerservationC(ptNum);
				}
				redirectAttributes.addAttribute("msg", "cancelE");
			}
			mav.setViewName("redirect:/reserve/gotoReserveCancel.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

}
