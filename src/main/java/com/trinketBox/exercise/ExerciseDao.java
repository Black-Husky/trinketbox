package com.trinketBox.exercise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trinketBox.student.Student;

@Component
public class ExerciseDao {
	// Injected database connection:
	@PersistenceContext
	private EntityManager em;

	// Stores a new student:
	@Transactional
	public void persist(Long ownerId, Exercise exercise) {
		Student student = em.find(Student.class, Long.valueOf(ownerId));
		if (student != null) {
			em.persist(exercise);
			student.setExercises(exercise); // connect the child to the parent
		}
	}

	@Transactional
	public void update(Long ownerId, Long id, Exercise exercise2) {
		Student student = em.find(Student.class, Long.valueOf(ownerId));
		Exercise exercise = em.find(Exercise.class, id);
		if (student != null && exercise != null)
			if ((exercise = student.getExercises().get(student.getExercises().indexOf(exercise))) != null) {
				exercise.setName(exercise2.getName());
				exercise.setSubject(exercise2.getSubject());
			}
	}

	@Transactional
	public void delete(int id) {
		Exercise exercise = em.find(Exercise.class, id);
		if (exercise != null) {
			Student student = em.find(Student.class,
					Long.valueOf(exercise.getOwnerId()));
			student.getExercises().remove(exercise);
		}
	}

	// Retrieves all the students:
	public List<Exercise> getAll() {
		TypedQuery<Exercise> query = em.createQuery(
				"SELECT e FROM Exercise e ORDER BY e.id", Exercise.class);
		return query.getResultList();
	}
	
	
	public Exercise getById(Long id) {
		return em.find(Exercise.class, id);
	}
}
