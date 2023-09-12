package com.tofit.spring.center.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.center.vo.CenterVO;
import com.tofit.spring.center.vo.PurchaseVO;

@Repository("centerDAO")
public class CenterDAOImpl implements CenterDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CenterVO> selectAllList(Map pagingMap) throws DataAccessException {
		List<CenterVO> centerList;
		String cenName=(String)pagingMap.get("cenName");
		if(cenName==null || cenName.equals("")) {
			centerList = sqlSession.selectList("mapper.center.selectAllList", pagingMap);
		}else {
			centerList = sqlSession.selectList("mapper.center.selectAllListSearch", pagingMap);
		}
		return centerList;
	}
	

	@Override
	public int getTotalCen(Map pagingMap) throws DataAccessException {
		int totalCen;
		String cenName=(String)pagingMap.get("cenName");
		if(cenName==null || cenName.equals("")) {
			totalCen=(Integer)sqlSession.selectOne("mapper.center.getTotalCen");
		}else {
			totalCen=(Integer)sqlSession.selectOne("mapper.center.getTotalCenSearch", pagingMap);
		}
		return totalCen;
	}

	@Override
	public List<CenterVO> selectCityList(Map pagingMap) throws DataAccessException {
		List<CenterVO> centerList;
		String cenName=(String)pagingMap.get("cenName");
		if(cenName==null || cenName.equals("")) {
			centerList = sqlSession.selectList("mapper.center.selectCityList", pagingMap);
		}else {
			centerList = sqlSession.selectList("mapper.center.selectCityListSearch", pagingMap);
		}
		return centerList;
	}
	
	@Override
	public int getTotalCenCity(Map pagingMap) throws DataAccessException {
		int totalCen;
		String cenName=(String)pagingMap.get("cenName");
		if(cenName==null || cenName.equals("")) {
			totalCen=(Integer)sqlSession.selectOne("mapper.center.getTotalCenCity");
		}else {
			totalCen=(Integer)sqlSession.selectOne("mapper.center.getTotalCenCitySearch", pagingMap);
		}
		return totalCen;
	}

	@Override
   public CenterVO moreCenter(String cenNumber) throws DataAccessException {
   CenterVO centerVO=(CenterVO)sqlSession.selectOne("mapper.center.selectCenterlist", cenNumber);
   return centerVO;
   }


	@Override
	public List<PurchaseVO> centerPTList(String cenNumber) throws DataAccessException {
		List<PurchaseVO> ptList=sqlSession.selectList("mapper.center.centerPTList", cenNumber);
		return ptList;
	}

	@Override
	public void insertCenter(CenterVO centerVO) throws DataAccessException {
		sqlSession.insert("mapper.center.insetCenter", centerVO);
		
	}


	@Override
	public void ptPurchase(Map ptPurMap) throws DataAccessException {
		PurchaseVO purchaseVO=sqlSession.selectOne("mapper.center.getPT", ptPurMap);
		String id=(String)ptPurMap.get("id");
		purchaseVO.setUserId(id);
		int ptPaynum=sqlSession.selectOne("mapper.center.getPTpaynum");
		ptPaynum+=1;
		purchaseVO.setPtPaynum(ptPaynum);
		sqlSession.insert("mapper.center.ptPurchase", purchaseVO);
	}




}
