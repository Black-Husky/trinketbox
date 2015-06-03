package com.trinketBox.exercise;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.trinketBox.student.Student;
import com.trinketBox.student.StudentDao;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseDao exerciseDao;
	private RedirectAttributes redirectAttributes;

	@RequestMapping(value = "/exercise_form")
	public ModelAndView form(@RequestParam(required = false) final Long id) {
		if (id != null) {
			Exercise exercise;
			if ((exercise = exerciseDao.getById(id)) != null){
				ModelAndView mv = new ModelAndView("exercise_form", "exercise", exercise);
				mv.addObject("id", id);
				return mv ;
			}
		}
		return new ModelAndView("exercise_form", "exercise", new Exercise());
	}

	@RequestMapping(value = "/delete_exercise")
	public String delete(@RequestParam("id") int id) {
		exerciseDao.delete(id);
		return "redirect:/exercise_list.html";
	}

	@RequestMapping(value = "/update_exercise")
	public ModelAndView update(@Valid Exercise exercise, BindingResult errors, @RequestParam("id") Long id) {
		Student student = new Student();
		ModelAndView mv = new ModelAndView("exercise_form");
		if (exercise.getOwnerId() != null) {
			if((student = exerciseDao.getStudentById(exercise.getOwnerId())) == null) mv.addObject("owner_error", "Usuário não Encontrado.");
		}
		else mv.addObject("owner_error", "Usuário não pode ser vazio e precisa ser um número");
		if (errors.hasErrors() || student == null) {
			mv.addObject("message", "Some message you add on error");
			mv.addObject("errors", errors.getAllErrors());
			mv.addObject("id", id);
			return mv;
		}
		exerciseDao.update(student, id, exercise);
		return new ModelAndView(new RedirectView("exercise_list.html"));
	}

	@RequestMapping(value = "/new_exercise", method = RequestMethod.POST)
	public ModelAndView add(@Valid Exercise exercise, BindingResult errors) {
		Student student = new Student();
		ModelAndView mv = new ModelAndView("exercise_form");
		if (exercise.getOwnerId() != null) {
			if((student = exerciseDao.getStudentById(exercise.getOwnerId())) == null) mv.addObject("owner_error", "Usuário não Encontrado.");
		}
		else mv.addObject("owner_error", "Usuário não pode ser vazio e precisa ser um número");
		if (errors.hasErrors() || student == null) {
			mv.addObject("message", "Some message you add on error");
			mv.addObject("errors", errors.getAllErrors());
			return mv;
		}
		exerciseDao.persist(student, exercise);
		return new ModelAndView(new RedirectView("exercise_list.html"));
	}

	@RequestMapping(value = "/exercise_list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("exercise_list", "exerciseDao", exerciseDao);
	}

	private Exercise createExercise(HttpServletRequest request, Boolean update) {
		String ownerId = request.getParameter("ownerId");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String path = request.getParameter("path");

		if (name != null && ownerId != null && subject != null
				&& (path != null || update))
			return new Exercise(Long.valueOf(ownerId), name, subject, path);
		return null;
	}
}
