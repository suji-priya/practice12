package com.cjc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;

@Repository
public interface HomeRepository extends  CrudRepository<Student,Integer>{
List<Student> findAllByUnameAndUpassword(String un,String psw);
Student findAllByRollno(int rno);

}
