package com.cjc.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Student;
import com.cjc.repository.HomeRepository;
import com.cjc.serviceinterface.HomeService;

@Service
public class ServiceImpl implements HomeService {
	@Autowired
	HomeRepository hr;

	@Override
	public int addStudent(Student s) {
		hr.save(s);

		return 1;
	}

	@Override
	public List<Student> logincheck(String un, String psw) {
		if (un.equals("admin") && psw.equals("admin")) {
			List<Student> list = (List<Student>) hr.findAll();
			System.out.println(list);
			return list;
		} else {
			List<Student> list = hr.findAllByUnameAndUpassword(un, psw);
			System.out.println(list);
			return list;

		}

	}

	@Override
	public void deleteStudent(int rollno) {
		hr.deleteById(rollno);
	}

	@Override
	public List<Student> vieAllRecord() {
		List<Student> list = (List<Student>) hr.findAll();
		return list;
	}

	@Override
	public Student editRecord(int rollno) {
		Student s = (Student) hr.findAllByRollno(rollno);
		return s;
	}

	@Override
	public List<Student> updateRecord(Student stu) {
		hr.save(stu);
		List<Student> list = (List<Student>) hr.findAll();
		return list;
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return (List<Student>) hr.findAll();
	}

}
