package com.cg.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.util.ConnectionProvider;

public class AssociateDAOImpl implements AssociateDAO{
	private Connection conn=ConnectionProvider.getDBConnection();

	@Override
	public Associate save(Associate associate) throws SQLException {
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt1= conn.prepareStatement("insert into Associate(associateid,YearlyInvestmentUnder8oC,firstName,lastName, department,designation,pancard, emailId) values(associate_sequence.nextval,?,?,?,?,?,?,?)");
			pstmt1.setInt(1, associate.getYearlyInvestmentUnder8oC());
			pstmt1.setString(2, associate.getFirstName());
			pstmt1.setString(3, associate.getLastName());
			pstmt1.setString(4, associate.getDepartment());
			pstmt1.setString(5, associate.getDesignation());
			pstmt1.setString(6, associate.getPancard());
			pstmt1.setString(7, associate.getEmailId());
			pstmt1.executeUpdate();

			PreparedStatement pstmt2= conn.prepareStatement("select max(associateid) from associate");
			ResultSet rs=pstmt2.executeQuery();
			rs.next();
			int associateid= rs.getInt(1);

			PreparedStatement pstmt3= conn.prepareStatement("insert into BankDetails values(?,?,?,?)");
			pstmt3.setInt(1, associateid);
			pstmt3.setDouble(2,  associate.getBankDetail().getAccountNumber());
			pstmt3.setString(3, associate.getBankDetail().getBankName());
			pstmt3.setString(4, associate.getBankDetail().getIfscCode());
			pstmt3.executeUpdate();

			PreparedStatement pstmt4= conn.prepareStatement("insert into Salary (associateid,basicSalary,epf,companyPf)  values(?,?,?,?)");
			pstmt4.setInt(1, associateid);
			pstmt4.setDouble(2,  associate.getSalary().getBasicSalary());
			pstmt4.setDouble(3, associate.getSalary().getEpf());
			pstmt4.setDouble(4, associate.getSalary().getCompanyPf());
			pstmt4.executeUpdate();
			conn.commit();
			associate.setAssociateID(associateid);
			return associate;
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally{
			conn.setAutoCommit(true);
		}
	}

	@Override
	public Associate findOne(int associateId) {
		try {
			PreparedStatement pstmt1= conn.prepareStatement("Select * from associate where associateid="+associateId);
			ResultSet associateRS= pstmt1.executeQuery();
			if(associateRS.next()){
				String firstName=associateRS.getString("firstName");
				String lastName=associateRS.getString("firstName");
				String department=associateRS.getString("firstName");
				String designation=associateRS.getString("firstName");
				String pancard=associateRS.getString("firstName");
				String emailId=associateRS.getString("firstName");
				int yearlyInvestmentUnder8oC= associateRS.getInt("YearlyInvestmentUnder8oC");
				Associate associate = new Associate(associateId, yearlyInvestmentUnder8oC, firstName, lastName, department, designation, pancard, emailId, null, null);

				PreparedStatement pstmt2= conn.prepareStatement("Select * from BankDetails where associateid="+associateId);
				ResultSet bankdetailsRS= pstmt2.executeQuery();
				bankdetailsRS.next();
				int accountNumber=bankdetailsRS.getInt("accountNumber");
				String bankName=bankdetailsRS.getString("bankName");
				String ifscCode=bankdetailsRS.getString("ifscCode");
				associate.setBankDetail(new BankDetails(accountNumber, bankName, ifscCode));

				PreparedStatement pstmt3= conn.prepareStatement("Select * from Salary where associateid="+associateId);
				ResultSet salaryRS= pstmt3.executeQuery();
				salaryRS.next();
				associate.setSalary(new Salary(salaryRS.getInt("basicSalary"),salaryRS.getInt("hra") , salaryRS.getInt("conveyenceAllowance"), salaryRS.getInt("otherAllowance"), salaryRS.getInt("personalAllowance"), salaryRS.getInt("monthlyTax"), salaryRS.getInt("epf"), salaryRS.getInt("companyPf"), salaryRS.getInt("grossSalary") ,salaryRS.getInt("netSalary")) );
				return associate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Associate> findAll() throws SQLException {
		PreparedStatement pstmt1= conn.prepareStatement("Select * from associate");
		ResultSet associateRS= pstmt1.executeQuery();
		ArrayList<Associate> associates= new ArrayList<Associate>();

		while(associateRS.next()){
			int associateId= associateRS.getInt("associateId");
			String firstName=associateRS.getString("firstName");
			String lastName=associateRS.getString("firstName");
			String department=associateRS.getString("firstName");
			String designation=associateRS.getString("firstName");
			String pancard=associateRS.getString("firstName");
			String emailId=associateRS.getString("firstName");
			int yearlyInvestmentUnder8oC= associateRS.getInt("YearlyInvestmentUnder8oC");
			Associate associate = new Associate(associateId, yearlyInvestmentUnder8oC, firstName, lastName, department, designation, pancard, emailId, null, null);

			PreparedStatement pstmt2= conn.prepareStatement("Select * from BankDetails where associateid="+associateId);
			ResultSet bankdetailsRS= pstmt2.executeQuery();
			bankdetailsRS.next();
			int accountNumber=bankdetailsRS.getInt("accountNumber");
			String bankName=bankdetailsRS.getString("bankName");
			String ifscCode=bankdetailsRS.getString("ifscCode");
			associate.setBankDetail(new BankDetails(accountNumber, bankName, ifscCode));

			PreparedStatement pstmt3= conn.prepareStatement("Select * from Salary where associateid="+associateId);
			ResultSet salaryRS= pstmt3.executeQuery();
			salaryRS.next();
			associate.setSalary(new Salary(salaryRS.getDouble("basicSalary"),salaryRS.getDouble("hra") , salaryRS.getDouble("conveyenceAllowance"), salaryRS.getDouble("otherAllowance"), salaryRS.getDouble("personalAllowance"), salaryRS.getDouble("monthlyTax"), salaryRS.getDouble("epf"), salaryRS.getDouble("companyPf"), salaryRS.getDouble("grossSalary") , salaryRS.getDouble("netSalary")));
			associates.add(associate);
		}
		return associates;
	}

	@Override
	public boolean update(Associate associate) throws SQLException {
		PreparedStatement pstmt= conn.prepareStatement("Update salary set hra=?, conveyenceAllowance=?, otherAllowance=? , personalAllowance= ?, monthlyTax=?, grossSalary=?, netSalary=? where associateid="+associate.getAssociateID());
		pstmt.setDouble(1, associate.getSalary().getHra());
		pstmt.setDouble(2, associate.getSalary().getConveyenceAllowance());
		pstmt.setDouble(3, associate.getSalary().getOtherAllowance());
		pstmt.setDouble(4, associate.getSalary().getPersonalAllowance());
		pstmt.setDouble(5, associate.getSalary().getMonthlyTax());
		pstmt.setDouble(6, associate.getSalary().getGrossSalary());
		pstmt.setDouble(7, associate.getSalary().getNetSalary());
		int flag= pstmt.executeUpdate();
		if(flag>0) return true;
		return false;
	}

}
