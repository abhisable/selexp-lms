package com.se.selexplms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lessions")
public class Lession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lession_id")
	private int lessionId;
	
	@Column(name="lession_name")
	private String lessionName;
	
	@Column(name="lession_link",length = 1000)
	private String lessionLink;
	
	@ManyToOne
	@JoinColumn(name="course_id",referencedColumnName = "course_id")
	private Course course;

	public int getLessionId() {
		return lessionId;
	}

	public void setLessionId(int lessionId) {
		this.lessionId = lessionId;
	}

	public String getLessionName() {
		return lessionName;
	}

	public void setLessionName(String lessionName) {
		this.lessionName = lessionName;
	}

	public String getLessionLink() {
		return lessionLink;
	}

	public void setLessionLink(String lessionLink) {
		this.lessionLink = lessionLink;
	}

	@Override
	public String toString() {
		return "Lession [lessionId=" + lessionId + ", lessionName=" + lessionName + ", lessionLink=" + lessionLink
				+ "]";
	}
	
	

}
