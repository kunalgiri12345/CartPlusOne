package com.CartPlusOne.factory;

import com.CartPlusOne.dao.CartPlusOneDao;
import com.CartPlusOne.dao.CartPlusOneDaoImpl;

public class CartPlusOneDaoFactory 
{
	private static CartPlusOneDao studentDao;
	static
	{
		studentDao=new CartPlusOneDaoImpl();
	}
	public static CartPlusOneDao getStudentDao()
	{
		return studentDao;
	}
}
