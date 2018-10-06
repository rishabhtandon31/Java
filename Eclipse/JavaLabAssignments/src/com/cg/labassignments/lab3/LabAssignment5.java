package com.cg.labassignments.lab3;

import java.time.LocalDate;

public class LabAssignment5 {

	public static void main(String[] args) {
		LocalDate date1= LocalDate.of(2018, 10, 6);
		calculateExpiryDate(date1, 6, 1);
	}
	public static void calculateExpiryDate(LocalDate date1, int months, int years){
		LocalDate date2= date1.plusMonths(months);
		date2=date2.plusYears(years);
		System.out.println("Expiry date: "+date2);
	}
}
