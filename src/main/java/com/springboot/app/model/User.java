package com.springboot.app.model;

import javax.persistence.*;

@Entity

@Table(name="form")
public class User {
    
	@Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String phoneno;
    private String salary;
    private String dob;
    
    public User() {
    	  
    }
 
    public User(String name, String email, String dob,String phoneno,String salary) {
    	super();
         this.name = name;
         this.dob = dob;
         this.email = email;
         this.phoneno = phoneno;
         this.salary = salary;

    }
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", email=" + email + ", salary=" +salary + ",dob="+dob
				+ "]";
	}
	
	
}
