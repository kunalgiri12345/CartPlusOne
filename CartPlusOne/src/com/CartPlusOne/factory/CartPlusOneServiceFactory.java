package com.CartPlusOne.factory;

import com.CartPlusOne.service.CartPlusOneService;
import com.CartPlusOne.service.CartPlusOneServiceImpl;

public class CartPlusOneServiceFactory 
{
	private static CartPlusOneService studentService;
	static
	{
		studentService=new CartPlusOneServiceImpl();
	}
	public static CartPlusOneService getStudentService()
	{
		return studentService;
	}
}
