package com.tofit.spring.center.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.center.vo.CenterVO;
import com.tofit.spring.center.vo.PurchaseVO;

public interface CenterDAO {

	public List<CenterVO> selectAllList(Map pagingMap) throws DataAccessException;
	public List<CenterVO> selectCityList(Map pagingMap) throws DataAccessException;
	public int getTotalCen(Map pagingMap) throws DataAccessException;
	public int getTotalCenCity(Map pagingMap) throws DataAccessException;
	public CenterVO moreCenter(String cenNumber)throws DataAccessException;
	public List<PurchaseVO> centerPTList(String cenNumber)throws DataAccessException;
	public void insertCenter(CenterVO centerVO) throws DataAccessException;
	public void ptPurchase(Map ptPurMap) throws DataAccessException;
}
