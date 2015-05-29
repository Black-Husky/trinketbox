package com.trinketBox.exercise;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	Long ownerId;
	String name;
	String subject;
	String path;

	public Exercise() {

	}

	public Exercise(Long ownerId, String name, String subject, String path) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.subject = subject;
		this.path = path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return "Exercise [id=" + id + ", ownerId=" + ownerId + ", name=" + name
				+ ", subject=" + subject + ", path=" + path + "]";
	}
}
