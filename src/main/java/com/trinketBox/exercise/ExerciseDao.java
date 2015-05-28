package com.trinketBox.exercise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ExerciseDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
    
    // Stores a new student:
    @Transactional
    public void persist(Exercise exercise) {
        em.persist(exercise);
    }
    
    // Retrieves all the students:
    public List<Exercise> getAll() {
        TypedQuery<Exercise> query = em.createQuery(
            "SELECT e FROM Exercise e ORDER BY e.id", Exercise.class);
        return query.getResultList();
    }
}
