package com.CartPlusOne.service;

import com.CartPlusOne.beans.Student;
import com.CartPlusOne.dao.CartPlusOneDao;
import com.CartPlusOne.factory.CartPlusOneDaoFactory;

public class CartPlusOneServiceImpl implements CartPlusOneService 
{

	@Override
	public String addStudent(Student student) 
	{
		String status="";
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		status=studentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) 
	{
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		Student student=studentDao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) 
	{
		String status="";
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		status=studentDao.update(student);
		return status;
	}

	@Override
	public String deleteStudent(String sid) 
	{
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		String status=studentDao.delete(sid);
		return status;
	}
	
	@Override
	public String checkLogin(Student student) 
	{
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		String status=studentDao.checkLogin(student);
		return status;
	}
	public String addAccountDetails(Student student) 
	{
		CartPlusOneDao studentDao=CartPlusOneDaoFactory.getStudentDao();
		String status=studentDao.addAccountDetails(student);
		return status;
	}
}
