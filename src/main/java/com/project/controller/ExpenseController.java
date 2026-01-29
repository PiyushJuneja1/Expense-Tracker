package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.ExpenseDao;
import com.project.dao.ExpenseDaoImpl;
import com.project.model.Expense;

public class ExpenseController implements ExpenseInterface {

	Expense exp;
	ExpenseDao dao = new ExpenseDaoImpl();
	Scanner sc = new Scanner(System.in);
	@Override
	public void addExpense() {
		// TODO Auto-generated method stub
		exp = new Expense();
		System.out.println("Enter name");
		String name = sc.nextLine();
		exp.setName(name);
		System.out.println("Enter amount");
		double amt = sc.nextDouble();
		sc.nextLine();
		exp.setAmount(amt);
		System.out.println("Enter category");
		String category= sc.nextLine();
		exp.setCategory(category);
		System.out.println("Enter date in DD-MM-YYYY format");
		String date= sc.nextLine();
		exp.setDate(date);
		System.out.println("Enter mode");
		String mode = sc.nextLine();
		exp.setMode(mode);
		
		dao.addExpense(exp);
		System.out.println("Expense added successfully");
	}

	@Override
	public void showExpenses() {
		dao.showExpenses();
		
	}

	@Override
	public void totalExpense() {
		dao.totalExpense();
		
	}
}
