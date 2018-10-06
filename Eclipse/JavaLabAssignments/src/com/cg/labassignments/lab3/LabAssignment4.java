package com.cg.labassignments.lab3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LabAssignment4 {

	public static void main(String[] args) {
		System.out.println("Enter date (DD/MM/YYYY):");
		Scanner input= new Scanner(System.in);
		String date= input.next();
		LocalDate date1= LocalDate.of(Integer.parseInt( date.split("/")[2]),Integer.parseInt( date.split("/")[1]),Integer.parseInt( date.split("/")[0]));
		LocalDate date2= LocalDate.now();
		Period duration= Period.between(date1, date2);
		System.out.println("Day: "+duration.getDays()+" Month: "+duration.getMonths()+ " Year: "+duration.getYears());
		input.close();
	}

}
