package com.cg.payroll.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		PayrollServices payrollServices = new PayrollServicesImpl();
		String choice="y";
		Scanner sc = new Scanner(System.in);
		int ch=0;
		
		while(choice.compareToIgnoreCase("y")==0){
			System.out.println("Payroll Services Menu!");
			System.out.println("1. Add Associate Details\n2. Get Total Salary of the employee\n3. Retrieve the details of a specific employee\n4. Retrieve all details");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			switch(ch){
			case 1: 
				try {
					System.out.println("Associate details of associate id: " + payrollServices.acceptAssociateDetails("Satish", "Mahajan", "satish@gmail.com", "YTP", "Sr. Con", "JDDU2664F",  100000, 40000, 1000, 1000, 96853256, "ICICI", "ICIC000562") + " added.");					
				} catch (PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2: 
				try {
					System.out.println("Net Salary: " + payrollServices.calculateNetSalary(101));
				} catch (AssociateDetailNotFoundException | PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					System.out.println("Enter the associateId: ");
					int associateId = sc.nextInt();
					printDetails(payrollServices.getAssociateDetails(associateId));
				} catch (AssociateDetailNotFoundException | PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					ArrayList<Associate> associates=payrollServices.getAllAssociatesDetails();
					int length=associates.size();
				} catch (PayrollServicesDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			default:
				System.out.println("Enter valid choice");
				break;
			}
			System.out.println("Do you wanna continue(y/n) ");
			choice = sc.next();
		}
		sc.close();
		
		/*Associate associate1 = new Associate(101, 15000, "Satish", "Mahajan", "Sr. Con", "YTP", "JDDU2664F", "satish@gmail.com", new BankDetails(96853256, "ICICI", "ICIC000562"), new Salary(40000, 1000, 1000, 2000));
		Associate associate2 = new Associate(102, 20000, "Rajesh", "Kumar", "Sr. Con", "YTP", "UDHG5865D", "rajesh@gmail.com", new BankDetails(85694523, "HDFC", "HDFC000252"), new Salary(35000, 800, 800, 1500));
		Associate associate3 = new Associate(103, 25000, "Ankit", "Kumar", "Sr. Con", "YTP", "SYTRE8965S", "ankit@gmail.com", new BankDetails(96874586, "ICICI", "ICIC000562"), new Salary(50000, 1500, 1500, 2500));
		
		Associate[] associate = new Associate[3];
		associate[0] = new Associate(101, 15000, "Satish", "Mahajan", "Sr. Con", "YTP", "JDDU2664F", "satish@gmail.com", new BankDetails(96853256, "ICICI", "ICIC000562"), new Salary(40000, 1000, 1000, 2000));
		associate[1] = new Associate(102, 20000, "Rajesh", "Kumar", "Sr. Con", "YTP", "UDHG5865D", "rajesh@gmail.com", new BankDetails(85694523, "HDFC", "HDFC000252"), new Salary(35000, 800, 800, 1500));
		associate[2] = new Associate(103, 25000, "Ankit", "Kumar", "Sr. Con", "YTP", "SYTRE8965S", "ankit@gmail.com", new BankDetails(96874586, "ICICI", "ICIC000562"), new Salary(50000, 1500, 1500, 2500));
		
		for (int i=0; i<associate.length; i++){
			associate[i].getSalary().setHra(30 * associate[i].getSalary().getBasicSalary() / 100);
			associate[i].getSalary().setOtherAllowance(20 * associate[i].getSalary().getBasicSalary() / 100);
			associate[i].getSalary().setPersonalAllowance(25 * associate[i].getSalary().getBasicSalary() / 100);
			associate[i].getSalary().setConveyenceAllowance(25 * associate[i].getSalary().getBasicSalary() / 100);
			associate[i].getSalary().setGrossSalary(associate[i].getSalary().getBasicSalary() + associate[i].getSalary().getHra() + associate[i].getSalary().getOtherAllowance() + associate[i].getSalary().getPersonalAllowance() + associate[i].getSalary().getConveyenceAllowance());
			associate[i].getSalary().setMonthlyTax(5 * associate[i].getSalary().getGrossSalary() / 100);
			associate[i].getSalary().setNetSalary(associate[i].getSalary().getGrossSalary() - associate[i].getSalary().getMonthlyTax() - associate[i].getSalary().getEpf() - associate[i].getSalary().getCompanyPf() - associate[i].getSalary().getGratuity());
		}
		
		System.out.println("Details of First Associate");
		printDetails(associate[0]);
		System.out.println("\nDetails of Second Associate");
		printDetails(associate[1]);
		System.out.println("\nDetails of Third Associate");
		printDetails(associate[2]);*/
	}
	
	public static void printDetails(Associate associate){
		System.out.println("Associate ID: " + associate.getAssociateID());
		System.out.println("Associate First Name" + associate.getFirstName());
		System.out.println("Basic Salary: " + associate.getSalary().getBasicSalary());
		System.out.println("HRA: " + associate.getSalary().getHra());
		System.out.println("Other Allowances: " + associate.getSalary().getOtherAllowance());
		System.out.println("Personal Allowances: " + associate.getSalary().getPersonalAllowance());
		System.out.println("Conveyence Allowances: " + associate.getSalary().getConveyenceAllowance());
		System.out.println("EPF: " + associate.getSalary().getEpf());
		System.out.println("Company PF: " + associate.getSalary().getCompanyPf());
		System.out.println("Gratuity: " + associate.getSalary().getGratuity());
		System.out.println("Gross Salary: " + associate.getSalary().getGrossSalary());
		System.out.println("MonthlyTax: " + associate.getSalary().getMonthlyTax());
		System.out.println("Net Salary: " + associate.getSalary().getNetSalary());
		
	}
	
		
}
