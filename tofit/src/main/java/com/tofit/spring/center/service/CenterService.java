package com.tofit.spring.center.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.center.vo.CenterVO;
import com.tofit.spring.shop.vo.ProductVO;

public interface CenterService {
	public Map getCen(Map pagingMap) throws DataAccessException;
	public Map getCenCity(Map pagingMap) throws DataAccessException;
	public Map listCenterMore(String cenNumber) throws DataAccessException;
	public void insertCenter(CenterVO centerVO) throws DataAccessException;
	public void ptPurchase(Map ptPurMap) throws DataAccessException;
}
