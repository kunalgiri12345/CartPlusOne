package com.CartPlusOne.service;

import com.CartPlusOne.beans.Student;

public interface CartPlusOneService 
{
	public String addStudent(Student student);
	public Student searchStudent(String sid);
	public String updateStudent(Student student);
	public String deleteStudent(String sid);
	public String checkLogin(Student student);
	public String addAccountDetails(Student student);
}
