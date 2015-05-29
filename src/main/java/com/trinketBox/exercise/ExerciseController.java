package com.trinketBox.exercise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trinketBox.student.Student;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseDao exerciseDao;
	private RedirectAttributes redirectAttributes;

	@RequestMapping(value = "/exercise_form")
	public ModelAndView form(@RequestParam(required = false) final Long id) {
		if(id != null){
			Exercise exercise;
			if((exercise = exerciseDao.getById(id)) != null)
				return new ModelAndView("exercise_form", "exercise", exercise);
		}
		return new ModelAndView("exercise_form", "exercise", new Exercise());
	}

	@RequestMapping(value = "/delete_exercise")
	public String delete(@RequestParam("id") int id) {
		exerciseDao.delete(id);
		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/update_exercise")
	public String update(HttpServletRequest request, @RequestParam("id") Long id) {
		Exercise exercise;
		if((exercise = this.createExercise(request, true)) != null )
			exerciseDao.update(exercise.getOwnerId(), id, exercise);
		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/new_exercise")
	public String add(HttpServletRequest request) {
		// Handle a new student (if any):
		Exercise exercise;
		if((exercise = this.createExercise(request, false)) != null)
			exerciseDao.persist(exercise.getOwnerId(), exercise);
		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/exercise_list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("exercise_list", "exerciseDao", exerciseDao);
	}
	
	private Exercise createExercise(HttpServletRequest request, Boolean update){
		String ownerId = request.getParameter("ownerId");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String path = request.getParameter("path");

		if (name != null && ownerId != null && subject != null && (path != null || update)) 		
			return new Exercise(Long.valueOf(ownerId), name, subject, path);
		return null;
	}
}
