package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private Pancard pancard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

	public Pancard getPancard() {
		return pancard;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +",Pancard="+pancard+ "]";
	}
	
	
}
