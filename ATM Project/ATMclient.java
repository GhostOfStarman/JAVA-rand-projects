package draft;

import java.util.*;
import java.io.*;

public class ATMclient {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to JavaBank ATM, do you have an account? Enter 1 for yes, 2 for no");
		int hasAccount = kb.nextInt();
		if(hasAccount == 1) {
			
			System.out.println("Please enter your account number");
			
			
			int acctNo = kb.nextInt();
			if(AtmOne.accountExists(acctNo)) {
				System.out.println("Please enter your PIN");
				int enterPin = kb.nextInt();
				if(AtmOne.accountAccess(acctNo, enterPin)){
					AtmOne currentAccount = AtmOne.getAccount(acctNo);
					boolean loggedIn = true;
					
					while(loggedIn) {
						System.out.println("Hello, please make a selection from the menu below");
						System.out.println("---------------------------------------------------");
						System.out.println("(1) Make a withdrawl");
						System.out.println("(2) Make a deposit");
						System.out.println("(3) Check Balance");
						System.out.println("(4) Change PIN");
						System.out.println("(5) Log Out");
						
						
						int selection = kb.nextInt();
						
						switch(selection) {
						case 1: 
							System.out.println("Enter the amount you'd like to withdraw, in denominations of 20.00");
							double amount = kb.nextDouble();
							currentAccount.withdraw(amount);
							break;
						case 2:
							System.out.println("Please type in the amount you'd like to deposit, then insert currency");
							double depAmount = kb.nextDouble();
							currentAccount.deposit(depAmount);
							break;
						case 3:
							currentAccount.getBalance();
							break;
						case 4:
							System.out.println("Please enter your old PIN");
							int oldPin = kb.nextInt();
							if(currentAccount.validatePin(oldPin)) {
								System.out.println("Enter new PIN");
								int newPin = kb.nextInt();
								currentAccount.setPin(newPin);
							}else {
								System.out.println("Invalid pin, please try again from main menu");
							}
							break;
						case 5:
							loggedIn = false;
							break;
						}
					}
				}else {
					System.out.println("You have entered the wrong pin");
				}
			}else {
				System.out.println("Account does not exist");
			}
		}else {
			System.out.println("Would you like to create an account? Y/N?");
			char createAcc = Character.toLowerCase(kb.next().charAt(0));
			if(createAcc == 'y') {
				System.out.println("Please enter a 10 digit account number");
				int acctNum = kb.nextInt();
				System.out.println("Please create a 4 digit PIN");
				int acctPin = kb.nextInt();
				AtmOne.createAccount(acctNum, acctPin);
				System.out.println("Thank you for creating an account at JavaBank");
			}else {
				System.out.println("Goodbye");
				System.exit(0);
			}
			
		}		
	}
}
