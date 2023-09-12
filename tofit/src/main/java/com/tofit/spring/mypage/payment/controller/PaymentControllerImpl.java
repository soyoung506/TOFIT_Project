package com.tofit.spring.mypage.payment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tofit.spring.mypage.payment.service.PaymentService;
import com.tofit.spring.mypage.payment.vo.PTpaymentVO;
import com.tofit.spring.mypage.profile.service.ProfileService;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

@Controller("paymentController")
public class PaymentControllerImpl implements PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PTpaymentVO ptPaymentVO;

	@Override
	@RequestMapping(value = "/payment/paymentInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView paymentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			Map paymentMap = paymentService.getPayment(log_id);
			mav.addObject("paymentMap", paymentMap);
			mav.setViewName("mypage/sub_mypage02");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/payment/ptPayment.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ptPayment(String _section, String _pageNum, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			int section = Integer.parseInt((_section == null) ? "1" : _section);
			int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
			Map pagingMap = new HashMap();
			pagingMap.put("section", section);
			pagingMap.put("pageNum", pageNum);
			pagingMap.put("id", log_id);
			Map ptMap = paymentService.getPTList(pagingMap);
			ptMap.put("section", section);
			ptMap.put("pageNum", pageNum);
			String msg = request.getParameter("msg");
			mav.addObject("msg", msg);
			mav.addObject("ptMap", ptMap);
			mav.setViewName("mypage/sub_mypage02_PTPurchaseList");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override 
	@RequestMapping(value = "/payment/ptRefund.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ptRefund(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			int ptPaynum = Integer.parseInt(request.getParameter("checkedPT"));
			paymentService.refundPT(ptPaynum);
			redirectAttributes.addAttribute("msg", "ptRefund");
			mav.setViewName("redirect:/payment/ptPayment.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/payment/productPayment.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productPayment(String _section, String _pageNum, String startDate, String endDate,
			String period, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			int section = Integer.parseInt((_section == null) ? "1" : _section);
			int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
			Map pagingMap = new HashMap();
			pagingMap.put("section", section);
			pagingMap.put("pageNum", pageNum);
			pagingMap.put("id", log_id);
			pagingMap.put("startDate", startDate);
			pagingMap.put("endDate", endDate);
			pagingMap.put("period", period);
			Map productMap=paymentService.getProductList(pagingMap);
			productMap.put("section", section);
			productMap.put("pageNum", pageNum);
			productMap.put("startDate", startDate);
			productMap.put("endDate", endDate);
			productMap.put("period", period);
			mav.addObject("productMap", productMap);
			mav.setViewName("mypage/sub_mypage02_productPurchaseList");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/payment/productPayDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productPayDetail(Integer orNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			Map prodpayDetail=paymentService.getProdpayDetail(orNum);
			String msg = request.getParameter("msg");
			mav.addObject("msg", msg);
			mav.addObject("prodpayDetail", prodpayDetail);
			mav.setViewName("mypage/sub_mypage02_purchaseDetail");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/payment/refundPay.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView refundPay(Integer orNum, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			paymentService.refundPay(orNum);
			redirectAttributes.addAttribute("msg", "refund");
			redirectAttributes.addAttribute("orNum", orNum);
			mav.setViewName("redirect:/payment/productPayDetail.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

}
