package edu.dgtic.isp.entity;

import java.time.LocalDateTime;

public class Order extends Entity {
	private LocalDateTime orderPlacedOn;
	private double totalValue;
	private String customerName; // Campo agregado

	public LocalDateTime getOrderPlacedOn() {
		return orderPlacedOn;
	}

	public void setOrderPlacedOn(LocalDateTime orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}

