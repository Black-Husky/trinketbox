package com.trinketBox.exercise;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;                                                                    

@Entity
public class Exercise implements Serializable {
	private static final long serialVersionUID = 1L;
	
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    int ownerId;
    String name;
    String subject;
    String path;
    
    public Exercise(){
    	
    }

	public Exercise(int ownerId, String name, String subject, String path) {
		super();
		this.name = name;
		this.ownerId = ownerId;
		this.subject = subject;
		this.path = path;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Long getId() {
		return id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", ownerId=" + ownerId + ", name=" + name
				+ ", subject=" + subject + ", path=" + path + "]";
	}
}
