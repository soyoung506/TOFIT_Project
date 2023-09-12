package com.tofit.spring.mypage.payment.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.payment.vo.PTpaymentVO;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;

public interface PaymentDAO {

	public PTpaymentVO getPTpayment(String _id) throws DataAccessException;
	public List<PTpaymentVO> getPTList(Map pagingMap) throws DataAccessException;
	public int getptTotal(Map pagingMap) throws DataAccessException;
	public void refundPT(int ptPayNum) throws DataAccessException;
	public List<OrderVO> getOrderList(String id) throws DataAccessException;
	public List<OrderVO> getProductList(Map pagingMap) throws DataAccessException;
	public int getProductTotal(Map pagingMap) throws DataAccessException;
	public OrderVO getProdpayDetail(Integer orNum) throws DataAccessException;
	public List<CartsVO> getProdDetail(Integer orNum) throws DataAccessException;
	public void refundPay(int orNum) throws DataAccessException;
}
