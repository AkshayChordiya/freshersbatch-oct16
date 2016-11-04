package com.hibernate.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "getAllProducts", query = "from Product")

})
@Entity
@Table(name = "PRODUCT_HIBERNATE")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy= GenerationType.TABLE)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hib_seq")
	@SequenceGenerator(name="hib_seq", sequenceName="n_seq", allocationSize=2, initialValue=4)
	@Column(name = "p_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private float price;

	public Product() {
	}

	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String toString() {
		return id + " - " + name + " - " + price;
	}
}
