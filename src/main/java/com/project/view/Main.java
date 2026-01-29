package com.project.view;
import java.util.Scanner;

import com.project.controller.ExpenseController;
import com.project.controller.ExpenseInterface;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ExpenseInterface exCon = new ExpenseController();
		System.out.println("Welcome to expense tracker");
		String ch = null;
		do {
			System.out.println("Enter 1 for adding expense");
			System.out.println("Enter 2 for history");
			System.out.println("Enter 3 for total expense");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1:{
					exCon.addExpense();
					break;
				}
				case 2:{
					exCon.showExpenses();
					break;
				}
				case 3:{
					exCon.totalExpense();
					break;
				}
				default:{
			        System.out.println("Invalid Choice");
			}
		}
			System.out.println("Do you want to continue(Y/N)");
			ch = sc.next();
		}while (ch.equals("Y") || ch.equals("y"));
		System.out.println("Thank you for using expense tracker");
		sc.close();
		System.exit(0);
		
	}

}
