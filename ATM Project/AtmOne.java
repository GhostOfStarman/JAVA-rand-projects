package draft;

import java.util.*;
import java.io.*;

public class AtmOne {
	
	private double balance;
	private int accountNumber;
	private int pin;
	
	private static Map<Integer, Integer> infoMap = new HashMap<>();
	private static Map<Integer, AtmOne> accounts = new HashMap<>();
	
	public AtmOne(double balance, int acctNo, int pin) {
		this.balance = balance;
		this.accountNumber = acctNo;
		this.pin = pin;
	}
	
	public static boolean accountExists(int val) {
		if(infoMap.containsKey(val)) {
			return true;
		}return false;
	}
	
	public static boolean accountAccess(int acctNo, int pin) {
		if(pin == infoMap.get(acctNo)) {
			return true;
		}return false;
	}
	
	public static AtmOne getAccount(int acctNo) {
		for(int num : accounts.keySet()) {
			if(acctNo == num) {
				return accounts.get(num);
			}
		}
		return null;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public boolean validatePin(int pin) {
		return pin == this.pin;
	}
	
	public void setPin(int freshPin) {
		pin = freshPin;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException("Necessary funds not available");
		}else if(amount % 20 != 0) {
			throw new IllegalArgumentException("Please enter a multiple of 20");
		}else {
			if(amount == 20.00) {
				balance -= 20.00;
			}else if(amount == 40.00) {
				balance -= 40.00;
			}else if(amount == 60.00) {
				balance -= 60.00;
			}else if(amount == 100.00) {
				balance -= 100.00;
			}else {
				throw new IllegalArgumentException("Please enter an amount between $20.00 and $100.00");
			}
		}
		System.out.println("Your new balance is: " + balance);
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Your new balance is: " + balance);
	}
	
	public static void createAccount(int accountNo, int pin) {
		if(infoMap.containsKey(accountNo) || accounts.containsKey(accountNo)) {
			throw new IllegalArgumentException("Account already exists");
		}else {
			AtmOne freshAcct = new AtmOne(0.00, accountNo, pin);
			infoMap.put(accountNo, pin);
	
			accounts.put(accountNo, freshAcct);
		}
	}
	
	

}
