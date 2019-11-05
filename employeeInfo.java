package rando;

import java.util.*;
import java.io.*;

public class employeeInfo {
	
	private String first_name;
	private String last_name;
	private String employee_ID;
	
	private double hours_worked;
	private double rate;

	public static void main(String[] args) 
	{
		
		Scanner kb = new Scanner(System.in);
		
		
		System.out.print("Enter employee first name: ");
		String enterFirst = kb.nextLine();

		System.out.print("Enter employee last name: ");
		String enterLast = kb.nextLine();
		
		System.out.print("Enter employee ID: ");
		String enterID = kb.nextLine();

		employeeInfo emp1 = new employeeInfo(enterFirst, enterLast, enterID);
		
		System.out.println();
		
		System.out.print("Enter hours worked: ");
		double enterHrs = kb.nextDouble();
		emp1.hours_worked = enterHrs;
		

		System.out.print("Total employee paycheck: " + emp1.paycheck());

	}
	
	public employeeInfo()
	{
		this.first_name = "";
		this.last_name = "";
		this.employee_ID = "";
		this.hours_worked = 0;
		this.rate = 0;
	}
	
	public employeeInfo(String firstname,String lastname, String eID){
		this.first_name = firstname;
		this.last_name = lastname;
		this.employee_ID = eID;
		
		if((eID.charAt(0) != '1') && (eID.charAt(0) != '2') && (eID.charAt(0) != '3')) {
			System.out.print("Please enter an employee beginning in an 1, 2, or 3.");
		}
		
		
	}
	
	
	public double rateLevels() {
		
		//pay_rate is tiered by seniority levels given by the first digit of the employee ID's
		//1 corresponds to entry-level, 2 is mid-level, 3 is senior
		
		if(employee_ID.charAt(0) == '1') {
			this.rate = 19.00;
		}
		else if(employee_ID.charAt(0) == '2') {
			this.rate = 26.00;
		}
		else if(employee_ID.charAt(0) == '3') {
			this.rate = 35.00;
		}
		
		return rate;
	}
	
	
	public double paycheck() {

		double checkTotal;
		
			
		if(hours_worked <0){
			System.out.println("Input error");
			System.exit(0);
			}
		
		else if(hours_worked > 40) {
			checkTotal = ((hours_worked%40)*(rateLevels()*1.5)) + (40*rateLevels());
			return checkTotal;
			}
		
		else {
			checkTotal = hours_worked*rateLevels();
			return checkTotal;
			}
		
		return 0.0;
	}
	
	public void setName(String setFirst, String setLast) {
		
		first_name = setFirst;
		last_name = setLast;
		
	}
	
	public void setID(String IDno) {
		
		employee_ID = IDno;
		
	}
	
	public String getName() {
		
		return first_name + " " + last_name;
		
	}
	
	public String getID() {
		
		return employee_ID;
	}
	
	
}
	
	
