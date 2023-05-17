package com.project.precize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue 
	private int studentId;
    private String name;
    private String city;
    private String country;
    private String pincode;
    private int score;
    private String result;
    
    @Transient
    private long rank;
    
    
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", city=" + city + ", country=" + country
				+ ", pincode=" + pincode + ", score=" + score + "]";
	}
	
}


