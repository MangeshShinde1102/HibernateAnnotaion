package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "pancard")
public class Pancard {
	@Id
	@GeneratedValue(generator = "pan")
	@GenericGenerator(name = "pan", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Column(name = "id")
	private int id;

	@Column(name = "panNo")
	private String panNo;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", panNo=" + panNo + "]";
	}

}
