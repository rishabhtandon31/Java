package com.cg.labassignments.lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class LabAssignment3 {
	public static void main(String[] args) {
		try {
			Date date2= new Date();
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(date2);
			SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
			Date date1= dateformat1.parse("17/07/2017");
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(date1);
			//System.out.println(date2);
			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			System.out.println(startCalendar.get(Calendar.YEAR));
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
			System.out.println("Year :"+diffYear+ " Month: "+diffMonth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
