package com.trinketBox.exercise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseDao exerciseDao;
	private RedirectAttributes redirectAttributes;

	@RequestMapping(value = "/exercise_form")
	public ModelAndView studentForm(HttpServletRequest request) {
		return new ModelAndView("exercise_form");
	}

	@RequestMapping(value = "/delete_exercise")
	public String studentdelete(@RequestParam("id") int id) {
		exerciseDao.delete(id);
		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/new_exercise")
	public String studentAdd(HttpServletRequest request) {
		// Handle a new student (if any):
		String ownerId = request.getParameter("ownerId");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String path = request.getParameter("path");

		if (name != null && ownerId != null && subject != null && path != null) {
			exerciseDao.persist(Long.valueOf(ownerId), new Exercise(Long.valueOf(ownerId), name, subject, path));
		}

		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/exercise_list")
	public ModelAndView studentList(HttpServletRequest request) {
		return new ModelAndView("exercise_list", "exerciseDao", exerciseDao);
	}
}
