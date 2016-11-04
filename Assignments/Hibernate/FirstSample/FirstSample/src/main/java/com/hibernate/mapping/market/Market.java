package com.hibernate.mapping.market;

import java.util.Collection;
import java.util.Set;
import java.util.stream.DoubleStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="market")
public class Market {

	@Id
	@GeneratedValue
	@Column(name="market_id")
	private Long marketId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private Double value;
	
	@OneToMany(mappedBy="market", cascade={CascadeType.ALL})
	private Set<Stock> stocks;
	
	public Market() {
	}
	
	public Market(String name) {
		super();
		this.name = name;
	}

	public Market(String name, Set<Stock> stocks) {
		super();
		this.name = name;
		this.stocks = stocks;
	}

	public long getMarketId() {
		return marketId;
	}

	public void setMarketId(long marketId) {
		this.marketId = marketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
		this.value = calulateMarketPrice(stocks);
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public static double calulateMarketPrice(Collection<Stock> stocks) {
		return stocks.stream().flatMapToDouble(stock -> DoubleStream.of(stock.getPrice())).sum();
	}

	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", name=" + name + ", value=" + value + "]";
	}

	
}