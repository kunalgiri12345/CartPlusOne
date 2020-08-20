package com.CartPlusOne.dao;

import com.CartPlusOne.beans.Student;

public interface CartPlusOneDao 
{
	public String add(Student student);
	public Student search(String sid);
	public String update(Student student);
	public String delete(String sid);
	public String checkLogin(Student student);
	public String addAccountDetails(Student student);
}
