package com.tofit.spring.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tofit.spring.shop.vo.CartsVO;

public interface ShopController {

	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView productDetail(@RequestParam("pNum") Integer pNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listCarts(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addCarts(@ModelAttribute("cartsVO") CartsVO cartsVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleteCarts(@RequestParam("odNum") Integer odNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView order(@RequestParam("orTotal") Integer orTotal, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
