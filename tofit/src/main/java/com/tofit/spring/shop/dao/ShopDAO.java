package com.tofit.spring.shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.shop.vo.CartsVO;
import com.tofit.spring.shop.vo.OrderVO;
import com.tofit.spring.shop.vo.ProductVO;

public interface ShopDAO {

	public List<ProductVO> getProductList(Map pagingMap) throws DataAccessException;
	public int getProductTotal() throws DataAccessException;
	public ProductVO selectProduct(Integer pNum) throws DataAccessException;
	public void addCarts(CartsVO cartsVO) throws DataAccessException;
	public List<CartsVO> getCartsList(String id) throws DataAccessException;
	public int getCartsTotal(String id) throws DataAccessException;
	public void deleteCarts(Integer odNum) throws DataAccessException;
	public void addOrder(OrderVO orderVO) throws DataAccessException;
}
