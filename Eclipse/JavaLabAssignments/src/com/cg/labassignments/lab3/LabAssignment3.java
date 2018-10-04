package com.cg.labassignments.lab3;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class LabAssignment3 {

	public static void main(String[] args) {
		Date date1 = new Date(1995, 10, 31);
		Date date2=new Date();
		Date date3= new Date(date2.getTime()-date1.getTime());
		System.out.println(date3.getYear());
	}

}
