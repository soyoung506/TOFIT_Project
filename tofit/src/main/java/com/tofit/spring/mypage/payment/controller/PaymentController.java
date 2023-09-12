package com.tofit.spring.mypage.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface PaymentController {
	public ModelAndView paymentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ptPayment(@RequestParam("section") String _section, @RequestParam("pageNum") String _pageNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ptRefund(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception;
	public ModelAndView productPayment(@RequestParam("section") String _section, @RequestParam("pageNum") String _pageNum, 
			@RequestParam(value="startDate", required = false) String startDate, @RequestParam(value="endDate", required = false) String endDate, 
			@RequestParam(value="period", required = false) String period, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView productPayDetail(@RequestParam("orNum") Integer orNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView refundPay(@RequestParam("orNum") Integer orNum, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
