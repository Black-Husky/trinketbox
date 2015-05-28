package com.trinketBox.student;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;                                                                    

@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private String email;
    private String educationalInstitution;
    private int age;
    private String password;
    
    public Student(){
    	
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", educationalInstitution=" + educationalInstitution
				+ ", age=" + age + "]";
	}
}
