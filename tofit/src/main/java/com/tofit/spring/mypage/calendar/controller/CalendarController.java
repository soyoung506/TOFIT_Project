package com.tofit.spring.mypage.calendar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.mypage.calendar.vo.CalendarVO;

public interface CalendarController {
	public ModelAndView reserveInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView gotoReservePT(@RequestParam("ptDate") String ptDate, @RequestParam("chooseDate") String chooseDate, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView reservePT(@ModelAttribute("calendarVO") CalendarVO calendarVO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	public ModelAndView gotoReserveCancel(@RequestParam("section") String _section, @RequestParam("pageNum") String _pageNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView reserveCancel(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
}
