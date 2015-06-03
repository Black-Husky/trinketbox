package com.trinketBox.student;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/student_form")
	public ModelAndView form(@RequestParam(required = false) final Long id) {
		if (id != null) {
			Student student;
			if ((student = studentDao.getById(id)) != null){
				ModelAndView mv = new ModelAndView("student_form", "student", student);
				mv.addObject("id", id);
				return mv;
			}
		}
		return new ModelAndView("student_form", "student", new Student());
	}

	@RequestMapping(value = "/delete_student")
	public String delete(@RequestParam("id") int id) {
		studentDao.delete(id);
		return "redirect:/student_list.html";
	}

	@RequestMapping(value = "/update_student")
	public ModelAndView update(@Valid Student student, BindingResult errors, @RequestParam("id") Long id) {
		if(errors.hasErrors()){
			ModelAndView mv = new ModelAndView("student_form");
			mv.addObject("message", "Some message you add on error");
			mv.addObject("errors", errors.getAllErrors());
			mv.addObject("id", id);
			return mv;
		}
		studentDao.update(id, student);
		return new ModelAndView(new RedirectView("student_list.html"));
	}

	@RequestMapping(value="/new_student", method=RequestMethod.POST)
	public ModelAndView add(@Valid Student student, BindingResult errors) {
		if(errors.hasErrors()){
			ModelAndView mv = new ModelAndView("student_form");
			mv.addObject("message", "Some message you add on error");
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}
		studentDao.persist(student);
		return new ModelAndView(new RedirectView("student_list.html"));
	}

	@RequestMapping(value = "/student_list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("student_list", "studentDao", studentDao);
	}
}
