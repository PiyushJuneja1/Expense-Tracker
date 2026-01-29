package com.project.model;

public class Expense {
	//private int id;
	private String name;
	private double amount;
	private String category;
	private String date;
	private String mode;
	
	public Expense(){}

	public Expense(String name, double amount, String category, String date, String mode) {
		this.name = name;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.mode = mode;
	}

//	public int getId() {
//		return id;
//	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Expense [name=" + name + ", amount=" + amount + ", category=" + category + ", date=" + date + ", mode="
				+ mode + "]";
	}


	
}
