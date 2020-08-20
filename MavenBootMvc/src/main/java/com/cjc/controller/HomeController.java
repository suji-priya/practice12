package com.cjc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.serviceinterface.HomeService;
import com.cjc.util.GeneratePdfReport;
//hi this is changed by priya
@Controller
public class HomeController {
	@Autowired
	HomeService hs;

	@RequestMapping("/")
	public String prelogin() {
	System.out.println("login");
		return "Login";
	}

	@RequestMapping("/register")
	public String preRgegister() {
		return "Register";
	}

	@RequestMapping("/reg")
	public String registerdata(@ModelAttribute Student stu) {
		int id = hs.addStudent(stu);
		if (id > 0)
			return "Login";
		else
			return "Register";

	}                                

	@RequestMapping("/log")
	public String login(@RequestParam("uname") String un, @RequestParam("upassword") String psw, Model m) {
		List<Student> list = hs.logincheck(un, psw);
		System.out.println(list);
		m.addAttribute("data", list);

		return "Success";

	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("rollno") int r_no, Model m) {
		Student s = hs.editRecord(r_no);
		m.addAttribute("stu", s);
		return "update";
	}

	@RequestMapping("/update")

	public String update(@ModelAttribute Student stu, Model m) {
		List<Student> list = hs.updateRecord(stu);
		m.addAttribute("data", list);

		return "Success";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("rollno") int r_no, Model m)
	{     
		hs.deleteStudent(r_no);
		List<Student> list = hs.vieAllRecord();
		m.addAttribute("data", list);

		return "Success";
	}
	@RequestMapping(value = "/pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> studentReport() throws IOException {

		List<Student> stu = (List<Student>) hs.findAll();

		ByteArrayInputStream bis = GeneratePdfReport.studentReport(stu);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=studentreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}


}
