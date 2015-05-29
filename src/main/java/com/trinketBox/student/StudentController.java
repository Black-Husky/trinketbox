package com.trinketBox.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	private RedirectAttributes redirectAttributes;

	@RequestMapping(value = "/student_form")
	public ModelAndView form(@RequestParam(required = false) final Long id) {
		if(id != null){
			Student student;
			if((student = studentDao.getById(id)) != null)
				return new ModelAndView("student_form", "student", student);
		}
		return new ModelAndView("student_form", "student", new Student());
	}

	@RequestMapping(value = "/delete_student")
	public String delete(@RequestParam("id") int id) {
		studentDao.delete(id);
		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/update_student")
	public String update(HttpServletRequest request, @RequestParam("id") Long id) {
		Student student;
		if((student = this.createStudent(request)) != null )
			studentDao.update(id, student);
		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/new_student")
	public String add(HttpServletRequest request) {
		// Handle a new student (if any):
		Student student;
		if((student = this.createStudent(request)) != null )
			studentDao.persist(student);
		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/student_list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("student_list", "studentDao", studentDao);
	}
	
	private Student createStudent(HttpServletRequest request){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String educationalInstitution = request
				.getParameter("educationalInstitution");
		String password = request.getParameter("password");
		String age = request.getParameter("age");

		if (name != null && email != null && educationalInstitution != null
				&& password != null && age != null)
			return new Student(name, email, educationalInstitution,
					Integer.valueOf(age), password);
		return null;
	}
}
