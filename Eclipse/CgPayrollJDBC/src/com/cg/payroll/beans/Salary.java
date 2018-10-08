package com.cg.payroll.beans;

public class Salary {
	private double basicSalary, hra, conveyenceAllowance, otherAllowance, personalAllowance;
	private double monthlyTax, epf, companyPf, gratuity, grossSalary, netSalary;
	
	public Salary() {
		super();
	}
	
	public Salary(double basicSalary, double epf, double companyPf,
			double gratuity) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
	}
	
	public Salary(double basicSalary, double epf, double companyPf) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
	}	

	public Salary(double basicSalary, double hra, double conveyenceAllowance,
			double otherAllowance, double personalAllowance, double monthlyTax,
			double epf, double companyPf,  double grossSalary,
			double netSalary) {
		super();
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyenceAllowance = conveyenceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllowance = personalAllowance;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		//this.gratuity = gratuity;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getConveyenceAllowance() {
		return conveyenceAllowance;
	}

	public void setConveyenceAllowance(double conveyenceAllowance) {
		this.conveyenceAllowance = conveyenceAllowance;
	}

	public double getOtherAllowance() {
		return otherAllowance;
	}

	public void setOtherAllowance(double otherAllowance) {
		this.otherAllowance = otherAllowance;
	}

	public double getPersonalAllowance() {
		return personalAllowance;
	}

	public void setPersonalAllowance(double personalAllowance) {
		this.personalAllowance = personalAllowance;
	}

	public double getMonthlyTax() {
		return monthlyTax;
	}

	public void setMonthlyTax(double monthlyTax) {
		this.monthlyTax = monthlyTax;
	}

	public double getEpf() {
		return epf;
	}

	public void setEpf(double epf) {
		this.epf = epf;
	}

	public double getCompanyPf() {
		return companyPf;
	}

	public void setCompanyPf(double companyPf) {
		this.companyPf = companyPf;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "Salary [basicSalary=" + basicSalary + ", hra=" + hra
				+ ", conveyenceAllowance=" + conveyenceAllowance
				+ ", otherAllowance=" + otherAllowance + ", personalAllowance="
				+ personalAllowance + ", monthlyTax=" + monthlyTax + ", epf="
				+ epf + ", companyPf=" + companyPf + ", gratuity=" + gratuity
				+ ", grossSalary=" + grossSalary + ", netSalary=" + netSalary
				+ "]";
	}
	
}
