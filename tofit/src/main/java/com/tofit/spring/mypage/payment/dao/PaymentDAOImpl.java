package com.tofit.spring.mypage.payment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.mypage.payment.vo.PTpaymentVO;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;

@Repository("paymentDAO")
public class PaymentDAOImpl implements PaymentDAO{
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public PTpaymentVO getPTpayment(String _id) throws DataAccessException {
		PTpaymentVO ptPaymentInfo=sqlSession.selectOne("mapper.payment.getPTpayment", _id);
		return ptPaymentInfo;
	}

	@Override
	public List<PTpaymentVO> getPTList(Map pagingMap) throws DataAccessException {
		List<PTpaymentVO> ptList=sqlSession.selectList("mapper.payment.getPTList", pagingMap);
		return ptList;
	}

	@Override
	public int getptTotal(Map pagingMap) throws DataAccessException {
		int totCount=0;
		totCount=sqlSession.selectOne("mapper.payment.getptTotal", pagingMap);
		return totCount;
	}

	@Override
	public void refundPT(int ptPayNum) throws DataAccessException {
		sqlSession.update("mapper.payment.refundPT", ptPayNum);
	}

	@Override
	public List<OrderVO> getOrderList(String id) throws DataAccessException {
		List<OrderVO> orderList=sqlSession.selectList("mapper.payment.getOrderList", id);
		return orderList;
	}

	@Override
	public List<OrderVO> getProductList(Map pagingMap) throws DataAccessException {
		String period=(String)pagingMap.get("period");
		String startDate=(String)pagingMap.get("startDate");
		List<OrderVO> productList=null;
		if((period==null || period.equals("")) && (startDate==null || startDate.equals(""))) {
			productList=sqlSession.selectList("mapper.payment.getProductList", pagingMap);
		}else if (period==null || period.equals("")) {
			productList=sqlSession.selectList("mapper.payment.getProductListDate", pagingMap);
		}else if (period.equals("fullPeriod")) {
			productList=sqlSession.selectList("mapper.payment.getProductList", pagingMap);
		}else if (period.equals("halfPeriod")) {
			productList=sqlSession.selectList("mapper.payment.getProductListHalf", pagingMap);
		}else if (period.equals("onePeriod")) {
			productList=sqlSession.selectList("mapper.payment.getProductListOne", pagingMap);
		}else if (period.equals("threePeriod")) {
			productList=sqlSession.selectList("mapper.payment.getProductListThree", pagingMap);
		}else if (period.equals("sixPeriod")) {
			productList=sqlSession.selectList("mapper.payment.getProductListSix", pagingMap);
		}
		return productList;
	}

	@Override
	public int getProductTotal(Map pagingMap) throws DataAccessException {
		String period=(String)pagingMap.get("period");
		String startDate=(String)pagingMap.get("startDate");
		int productTotal=0;
		if((period==null || period.equals("")) && (startDate==null || startDate.equals(""))) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotal", pagingMap);
		}else if (period==null || period.equals("")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotalDate", pagingMap);
		}else if (period.equals("fullPeriod")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotal", pagingMap);
		}else if (period.equals("halfPeriod")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotalHalf", pagingMap);
		}else if (period.equals("onePeriod")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotalOne", pagingMap);
		}else if (period.equals("threePeriod")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotalThree", pagingMap);
		}else if (period.equals("sixPeriod")) {
			productTotal=sqlSession.selectOne("mapper.payment.getProductTotalSix", pagingMap);
		}
		return productTotal;
	}

	@Override
	public OrderVO getProdpayDetail(Integer orNum) throws DataAccessException {
		OrderVO payDetail=sqlSession.selectOne("mapper.payment.getProdpayDetail", orNum);
		return payDetail;
	}

	@Override
	public List<CartsVO> getProdDetail(Integer orNum) throws DataAccessException {
		List<CartsVO> ProdDetailList=sqlSession.selectList("mapper.payment.getProdDetail", orNum);
		return ProdDetailList;
	}

	@Override
	public void refundPay(int orNum) throws DataAccessException {
		sqlSession.update("mapper.payment.refundPay", orNum);
	}
	
	

} 




















