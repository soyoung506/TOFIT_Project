package com.tofit.spring.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.shop.dao.ShopDAO;
import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;
import com.tofit.spring.shop.vo.ProductVO;

@Service("shopService")
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public Map getProduct(Map pagingMap) throws DataAccessException {
		Map proMap=new HashMap();
		List<ProductVO> productList = shopDAO.getProductList(pagingMap);
		int totalProduct=shopDAO.getProductTotal();
		proMap.put("productList", productList);
		proMap.put("totalProduct", totalProduct);
		return proMap;
	}

	@Override
	public ProductVO selectProduct(Integer pNum) throws DataAccessException {
		ProductVO productVO=shopDAO.selectProduct(pNum);
		return productVO;
	}

	@Override
	public void addCarts(CartsVO cartsVO) throws DataAccessException {
		shopDAO.addCarts(cartsVO);
	}

	@Override
	public List<CartsVO> getCartsList(String id) throws DataAccessException {
		List<CartsVO> cartsList=shopDAO.getCartsList(id);
		return cartsList;
	}

	@Override
	public int getCartsTotal(String id) throws DataAccessException {
		int total=shopDAO.getCartsTotal(id);
		return total;
	}

	@Override
	public void deleteCarts(Integer odNum) throws DataAccessException {
		shopDAO.deleteCarts(odNum);
	}

	@Override
	public void addOrder(OrderVO orderVO) throws DataAccessException {
		shopDAO.addOrder(orderVO);
	}

}
