package com.tofit.spring.mypage.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.mypage.payment.dao.PaymentDAO;
import com.tofit.spring.mypage.payment.vo.PTpaymentVO;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDAO paymentDAO;

	@Override
	public Map getPayment(String id) throws DataAccessException {
		Map paymentMap=new HashMap();
		PTpaymentVO ptPaymentInfo=paymentDAO.getPTpayment(id);
		List<OrderVO> orderList=paymentDAO.getOrderList(id);
		paymentMap.put("ptPaymentInfo", ptPaymentInfo);
		paymentMap.put("orderList", orderList);
		return paymentMap;
	}

	@Override
	public Map getPTList(Map pagingMap) throws DataAccessException {
		Map ptMap=new HashMap();
		List<PTpaymentVO> ptList=paymentDAO.getPTList(pagingMap);
		int ptTotal=paymentDAO.getptTotal(pagingMap);
		ptMap.put("ptList", ptList);
		ptMap.put("ptTotal", ptTotal);
		return ptMap;
	}

	@Override
	public void refundPT(int ptPaynum) throws DataAccessException {
		paymentDAO.refundPT(ptPaynum);
	}

	@Override
	public Map getProductList(Map pagingMap) throws DataAccessException {
		Map productMap=new HashMap();
		List<OrderVO> productList=paymentDAO.getProductList(pagingMap);
		int productTotal=paymentDAO.getProductTotal(pagingMap);
		productMap.put("productList", productList);
		productMap.put("productTotal", productTotal);
		return productMap;
	}

	@Override
	public Map getProdpayDetail(Integer orNum) throws DataAccessException {
		Map prodpayDetail=new HashMap();
		OrderVO payDetail=paymentDAO.getProdpayDetail(orNum);
		List<CartsVO> ProdDetailList=paymentDAO.getProdDetail(orNum);
		prodpayDetail.put("payDetail", payDetail);
		prodpayDetail.put("ProdDetailList", ProdDetailList);
		return prodpayDetail;
	}

	@Override
	public void refundPay(int orNum) throws DataAccessException {
		paymentDAO.refundPay(orNum);
	}


	
}
