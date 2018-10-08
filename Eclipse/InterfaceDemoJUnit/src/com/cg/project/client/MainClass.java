package com.cg.project.client;

import com.cg.project.exceptions.InvalidNumberRangeException;
import com.cg.project.matservices.MathServices;
import com.cg.project.matservices.MathServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		try {
			MathServices services = new MathServicesImpl();
			services.addNums(45, 46);
		} catch (InvalidNumberRangeException e) {
			e.printStackTrace();
		}
	}

}
