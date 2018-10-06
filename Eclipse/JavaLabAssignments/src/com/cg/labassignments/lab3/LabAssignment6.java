package com.cg.labassignments.lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class LabAssignment6 {

	public static void main(String[] args) {
		DateOfTimeZone("Asia/Kolkata");
		DateOfTimeZone("America/Los_Angeles");
	}
	public static void DateOfTimeZone(String timeZone){
		DateFormat df= new SimpleDateFormat("dd-MM-YY HH:MM:SS z");
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date date= new Date();
		String date2=df.format(date);
		System.out.println(timeZone+" : "+date2);
	}
}
