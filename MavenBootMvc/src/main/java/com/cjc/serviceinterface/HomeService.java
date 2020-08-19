package com.cjc.serviceinterface;

import java.util.List;

import com.cjc.model.Student;

public interface HomeService {
	int addStudent(Student s);
	List<Student> logincheck(String un,String psw);
	void deleteStudent(int rollno);
	List<Student>vieAllRecord();
	Student editRecord(int rollno);
	List<Student>updateRecord(Student stu);
	List<Student> findAll();

}
