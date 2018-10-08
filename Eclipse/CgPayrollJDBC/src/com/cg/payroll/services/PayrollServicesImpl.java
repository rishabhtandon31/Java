package com.cg.payroll.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.dao.AssociateDAO;
import com.cg.payroll.dao.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollServicesImpl implements PayrollServices{

	private AssociateDAO associateDAO = new AssociateDAOImpl();
	
	@Override
	public int acceptAssociateDetails(String firstName, String lastName,
			String emailId, String department, String designation,
			String pancard, int yearlyInvestmentUnder8oC, double basicSalary,
			double epf, double companyPf, double accountNumber,
			String bankName, String ifscCode)
			throws PayrollServicesDownException {
		
		Associate associate = new Associate(yearlyInvestmentUnder8oC, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode), new Salary(basicSalary, epf, companyPf));
		try {
			associate = associateDAO.save(associate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return associate.getAssociateID();
	}

	@Override
	public double calculateNetSalary(int associateId)
			throws AssociateDetailNotFoundException,
			PayrollServicesDownException {
		Associate associate = getAssociateDetails(associateId);
		//Allowances and Gross Salary Calculation
		associate.getSalary().setHra(0.3 * associate.getSalary().getBasicSalary());
		associate.getSalary().setOtherAllowance(0.2 * associate.getSalary().getBasicSalary());
		associate.getSalary().setPersonalAllowance(0.2 * associate.getSalary().getBasicSalary());
		associate.getSalary().setConveyenceAllowance(0.25 * associate.getSalary().getBasicSalary());
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary() + associate.getSalary().getHra() + associate.getSalary().getOtherAllowance() + associate.getSalary().getPersonalAllowance() + associate.getSalary().getConveyenceAllowance());
		double annualGrossSalary = associate.getSalary().getGrossSalary() * 12;
		//Tax Calculation
		double netSalaryAfterInvesting = annualGrossSalary - ((associate.getYearlyInvestmentUnder8oC()>(150000-associate.getSalary().getEpf()*12-associate.getSalary().getCompanyPf()*12)?(150000):(associate.getYearlyInvestmentUnder8oC())));
		double annualTax = 0;
		if (netSalaryAfterInvesting <= 250000)
			annualTax = 0;
		else if (netSalaryAfterInvesting>250000 && netSalaryAfterInvesting<= 500000)
			annualTax = (netSalaryAfterInvesting - 250000) * 0.05;
		else if (netSalaryAfterInvesting>500000 && netSalaryAfterInvesting<=1000000)
			annualTax = (netSalaryAfterInvesting- 500000) * 0.2 + 250000 * 0.05;
		else
			annualTax = (netSalaryAfterInvesting - 1000000) * 0.3 + 500000 * 0.02 + 250000*0.05;
		double monthlyTax = annualTax / 12;
		associate.getSalary().setMonthlyTax(monthlyTax);
		associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary() - monthlyTax);
		try {
			boolean ans=associateDAO.update(associate);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesDownException("Server is down. Please try again later.");
		}
		return associate.getSalary().getNetSalary();
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailNotFoundException,
			PayrollServicesDownException {
		Associate associate = associateDAO.findOne(associateId);
		if (associate == null) throw new AssociateDetailNotFoundException("Associate Details Not Found.");
		return associate;
	}

	@Override
	public ArrayList<Associate> getAllAssociatesDetails()
			throws PayrollServicesDownException {
		try {
			return associateDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
