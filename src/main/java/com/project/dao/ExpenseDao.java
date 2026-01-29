package com.project.dao;

import com.project.model.Expense;

public interface ExpenseDao {
	void addExpense(Expense exp);
	void showExpenses();
	void totalExpense();
	
}
