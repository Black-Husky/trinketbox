package com.trinketBox.student;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.trinketBox.exercise.Exercise;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	@NotBlank
	private String name;
	// @Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Email
	@NotBlank
	String email;
	@NotBlank
	private String educationalInstitution;
	private int age;
	@NotBlank
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
