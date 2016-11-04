package com.hibernate.mapping.market;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="stock")
public class Stock {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long stockId;

	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Double price;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="market_id")
	private Market market;
	
	public Stock() {
		
	}

	public Stock(String name, double price, Market market) {
		super();
		this.name = name;
		this.price = price;
		this.market = market;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}
	
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", name=" + name + ", price=" + price + "]";
	}
	
}