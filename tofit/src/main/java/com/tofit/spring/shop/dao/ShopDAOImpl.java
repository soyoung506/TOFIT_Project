package com.tofit.spring.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.mypage.profile.vo.ProfileVO;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;
import com.tofit.spring.shop.vo.ProductVO;

@Repository("shopDAO")
public class ShopDAOImpl implements ShopDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductVO> getProductList(Map pagingMap) throws DataAccessException {
		List<ProductVO> productList=sqlSession.selectList("mapper.shop.getProductList", pagingMap);
		return productList;
	}

	@Override
	public int getProductTotal() throws DataAccessException {
		int totalProduct=(Integer)sqlSession.selectOne("mapper.shop.getProductTotal");
		return totalProduct;
	}

	@Override
	public ProductVO selectProduct(Integer pNum) throws DataAccessException {
		ProductVO productVO=sqlSession.selectOne("mapper.shop.selectProduct", pNum);
		return productVO;
	}

	@Override
	public void addCarts(CartsVO cartsVO) throws DataAccessException {
		int check=sqlSession.selectOne("mapper.shop.checkCarts", cartsVO);
		if(check==0) {
			int odNum=sqlSession.selectOne("mapper.shop.getOdnum");
			odNum++;
			cartsVO.setOdNum(odNum);
			sqlSession.insert("mapper.shop.addCarts", cartsVO);
		}else {
			sqlSession.update("mapper.shop.updateCarts", cartsVO);
		}
		
	}

	@Override
	public List<CartsVO> getCartsList(String id) throws DataAccessException {
		List<CartsVO> cartsList=sqlSession.selectList("mapper.shop.getCartsList", id);
		return cartsList;
	}

	@Override
	public int getCartsTotal(String id) throws DataAccessException {
		int total=(Integer)sqlSession.selectOne("mapper.shop.getCartsTotal", id);
		return total;
	}

	@Override
	public void deleteCarts(Integer odNum) throws DataAccessException {
		sqlSession.delete("mapper.shop.deleteCarts", odNum);
	}

	@Override
	public void addOrder(OrderVO orderVO) throws DataAccessException {
		String _id=orderVO.getId();
		ProfileVO profileVO=sqlSession.selectOne("mapper.profile.getProfile", _id);
		orderVO.setOrPhone(profileVO.getPhone());
		orderVO.setOrAddress(profileVO.getAddress());
		int orNum=sqlSession.selectOne("mapper.shop.getOrnum");
		orNum++;
		orderVO.setOrNum(orNum);
		sqlSession.insert("mapper.shop.addOrder", orderVO);
		sqlSession.update("mapper.shop.updateOrnum", orderVO);
	}

}
