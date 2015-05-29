package com.trinketBox.student;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.trinketBox.exercise.Exercise;

@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String name;
	private String email;
	private String educationalInstitution;
	private int age;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private LinkedList<Exercise> exercises = new LinkedList<Exercise>();

	public Student() {

	}

	public Student(String name, String email, String educationalInstitution,
			int age, String password) {
		super();
		this.name = name;
		this.email = email;
		this.educationalInstitution = educationalInstitution;
		this.age = age;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducationalInstitution() {
		return educationalInstitution;
	}

	public void setEducationalInstitution(String educationalInstitution) {
		this.educationalInstitution = educationalInstitution;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setExercises(Exercise exercise) {
		this.exercises.add(exercise);
	}

	public LinkedList<Exercise> getExercises() {
		return exercises;
	}

	public Boolean mathPassword(String password) {
		return this.password.equals(password);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", educationalInstitution=" + educationalInstitution
				+ ", age=" + age + ", exercises=" + exercises + "]";
	}
}
