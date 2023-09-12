package com.tofit.spring.center.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.center.dao.CenterDAO;
import com.tofit.spring.center.vo.CenterVO;
import com.tofit.spring.center.vo.PurchaseVO;
import com.tofit.spring.member.vo.MemberVO;
import com.tofit.spring.shop.vo.ProductVO;

@Service("centerService")
public class CenterServiceImpl implements CenterService {

	@Autowired
	private CenterDAO centerDAO;
	
	@Override
	public Map getCen(Map pagingMap) throws DataAccessException {
		Map cenMap=new HashMap();
		List<CenterVO> centerList = centerDAO.selectAllList(pagingMap);
		int totalCen=centerDAO.getTotalCen(pagingMap);
		cenMap.put("centerList", centerList);
		cenMap.put("totalCen", totalCen);
		return cenMap;
	}

	
	@Override
	public Map getCenCity(Map pagingMap) throws DataAccessException {
		Map cenMap=new HashMap();
		List<CenterVO> centerList = centerDAO.selectCityList(pagingMap);
		int totalCen=centerDAO.getTotalCenCity(pagingMap);
		cenMap.put("centerList", centerList);
		cenMap.put("totalCen", totalCen);
		return cenMap;
	}


//	@Override
//	public List listCenterMore() throws DataAccessException {
//		List centerList = centerDAO.selectAllList();
//		return centerList;
//	}

	 @Override
	   public Map listCenterMore(String cenNumber) throws DataAccessException {
		 Map cenDetailMap=new HashMap();
	      CenterVO centerVO = centerDAO.moreCenter(cenNumber);
	      List<PurchaseVO> ptList=centerDAO.centerPTList(cenNumber);
	      cenDetailMap.put("centerVO", centerVO);
	      cenDetailMap.put("ptList", ptList);
	      return cenDetailMap;
	   }


	@Override
	public void insertCenter(CenterVO centerVO) throws DataAccessException {
		centerDAO.insertCenter(centerVO);
		
	}

	@Override
	public void ptPurchase(Map ptPurMap) throws DataAccessException {
		centerDAO.ptPurchase(ptPurMap);
		
	}



}
