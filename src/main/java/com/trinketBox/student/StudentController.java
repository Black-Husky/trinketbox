package com.trinketBox.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	private RedirectAttributes redirectAttributes;

	@RequestMapping(value = "/student_form")
	public ModelAndView studentForm(HttpServletRequest request) {
		return new ModelAndView("student_form");
	}

	@RequestMapping(value = "/delete_student")
	public String studentDelete(@RequestParam("id") int id) {
		studentDao.delete(id);
		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/new_student")
	public String studentAdd(HttpServletRequest request) {
		// Handle a new student (if any):
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String educationalInstitution = request
				.getParameter("educationalInstitution");
		String password = request.getParameter("password");
		String age = request.getParameter("age");

		if (name != null && email != null && educationalInstitution != null
				&& password != null && age != null)
			studentDao.persist(new Student(name, email, educationalInstitution,
					Integer.valueOf(age), password));

		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/student_list")
	public ModelAndView studentList(HttpServletRequest request) {
		return new ModelAndView("student_list", "studentDao", studentDao);
	}
}
