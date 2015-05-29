package com.trinketBox.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentDao {
	// Injected database connection:
	@PersistenceContext
	private EntityManager em;

	// Stores a new student:
	@Transactional
	public void persist(Student student) {
		em.persist(student);
	}

	@Transactional
	public void delete(int id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}

	// Retrieves all the students:
	public List<Student> getAll() {
		TypedQuery<Student> query = em.createQuery(
				"SELECT s FROM Student s ORDER BY s.id", Student.class);
		return query.getResultList();
	}
}
