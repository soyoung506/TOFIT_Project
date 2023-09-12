package com.tofit.spring.mypage.payment.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.payment.vo.PTpaymentVO;

public interface PaymentService {
	public Map getPayment(String id) throws DataAccessException;
	public Map getPTList(Map pagingMap) throws DataAccessException;
	public void refundPT(int ptPaynum) throws DataAccessException;
	public Map getProductList(Map pagingMap) throws DataAccessException;
	public Map getProdpayDetail(Integer orNum) throws DataAccessException;
	public void refundPay(int orNum) throws DataAccessException;
}
