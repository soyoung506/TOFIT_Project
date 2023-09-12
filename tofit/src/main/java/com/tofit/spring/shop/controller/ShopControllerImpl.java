package com.tofit.spring.shop.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tofit.spring.shop.service.ShopService;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;
import com.tofit.spring.shop.vo.ProductVO;

@Controller("shopController")
public class ShopControllerImpl implements ShopController{
	@Autowired
	private ShopService shopService;
	@Autowired
	private ProductVO productVO;
	@Autowired
	private CartsVO cartsVO;
	@Autowired
	private OrderVO orderVO;
	
	@Override
	@RequestMapping(value = "/shop/listProduct.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		int section = Integer.parseInt((_section == null) ? "1" : _section);
		int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
		Map pagingMap = new HashMap();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		Map proMap = shopService.getProduct(pagingMap);
		proMap.put("section", section);
		proMap.put("pageNum", pageNum);
		mav.addObject("proMap", proMap);
		mav.setViewName("shop/indexshop");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/shop/productDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productDetail(@RequestParam("pNum") Integer pNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		productVO=shopService.selectProduct(pNum);
		mav.addObject("productVO", productVO);
		mav.setViewName("shop/productDetail");
		return mav;
	}

	@Override
	@RequestMapping(value = "/shop/listCarts.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listCarts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			List<CartsVO> cartsList=shopService.getCartsList(log_id);
			int total=shopService.getCartsTotal(log_id);
			mav.addObject("cartsList", cartsList);
			mav.addObject("total", total);
			mav.setViewName("shop/carts");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/shop/addCarts.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addCarts(CartsVO cartsVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			cartsVO.setId(log_id);
			shopService.addCarts(cartsVO);
			mav.setViewName("redirect:/shop/listCarts.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/shop/deleteCarts.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteCarts(Integer odNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			shopService.deleteCarts(odNum);
			mav.setViewName("redirect:/shop/listCarts.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}
	@Override
	@RequestMapping(value = "/shop/order.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView order(Integer orTotal, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null && session.getAttribute("isLogon") == "true") {
			String log_id = (String) session.getAttribute("log_id");
			orderVO.setId(log_id);
			orderVO.setOrTotal(orTotal);
			shopService.addOrder(orderVO);
			mav.setViewName("redirect:/shop/listCarts.do");
		} else {
			mav.setViewName("redirect:/member/kitlogin.do");
		}
		return mav;
	}

}
