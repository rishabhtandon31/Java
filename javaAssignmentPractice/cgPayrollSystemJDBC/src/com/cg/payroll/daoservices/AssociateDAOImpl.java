package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.util.ConnectionProvider;
public class AssociateDAOImpl implements AssociateDAO{
	private Connection conn = ConnectionProvider.getDBConnection();
	@Override
	public Associate save(Associate associate) throws SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "insert into associate ( ASSOCIATEID, YEARLYINVESTMENTUNDER80C, FIRSTNAME, LASTNAME, DEPARTMENT, DESIGNATION, PANCARD,EMAILID) values(ASSOCIATE_ID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setInt(1, associate.getYearlyInvestmentUnder8oC());
			pstmt1.setString(2, associate.getFirstName());
			pstmt1.setString(3, associate.getLastName());
			pstmt1.setString(4, associate.getDepartment());
			pstmt1.setString(5, associate.getDesignation());
			pstmt1.setString(6, associate.getPancard());
			pstmt1.setString(7, associate.getEmailId());
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement("select max(ASSOCIATEID) from associate");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int associateId = rs.getInt(1);
			
			PreparedStatement pstmt3 = conn.prepareStatement("insert into bankdetails values(?, ?, ?, ?)");
			pstmt3.setInt(1, associateId);
			pstmt3.setDouble(2, associate.getBankDetail().getAccountNumber());
			pstmt3.setString(3, associate.getBankDetail().getBankName());
			pstmt3.setString(4, associate.getBankDetail().getIfscCode());
			pstmt3.executeUpdate();
			
			PreparedStatement pstmt4 = conn.prepareStatement("insert into salary (associateid, basicsalary, epf, companypf) values(?, ?, ?, ?)");
			pstmt4.setInt(1, associateId);
			pstmt4.setDouble(2, associate.getSalary().getBasicSalary());
			pstmt4.setDouble(3, associate.getSalary().getEpf());
			pstmt4.setDouble(4, associate.getSalary().getCompanyPf());
			pstmt4.executeUpdate();
			
			conn.commit();
			associate.setAssociateID(associateId);
			return associate;
		} catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally { conn.setAutoCommit(true); }
	}
	@Override
	public Associate findOne(int associateId) throws SQLException { 
		PreparedStatement pstmt1 = conn.prepareStatement("select * from associate where associateid="+associateId);
		ResultSet findAssociateDetailsRS = pstmt1.executeQuery();
		if(findAssociateDetailsRS.next()){
			int associateID = findAssociateDetailsRS.getInt("associateid");
			int yearlyInvestmentUnder8oC = findAssociateDetailsRS.getInt("yearlyInvestmentUnder80C");
			String firstName = findAssociateDetailsRS.getString("firstName");
			String lastName= findAssociateDetailsRS.getString("lastName");
			String department= findAssociateDetailsRS.getString("department");
			String designation= findAssociateDetailsRS.getString("designation");
			String pancard= findAssociateDetailsRS.getString("pancard");
			String emailId= findAssociateDetailsRS.getString("emailId");
			Associate associate = new Associate(associateID, yearlyInvestmentUnder8oC, firstName, lastName, department, designation, pancard, emailId, null, null);
		
			PreparedStatement pstmt2 = conn.prepareStatement("select * from bankdetails where associateid="+associateId);
			ResultSet findBankDetailsRS = pstmt2.executeQuery();
			findBankDetailsRS.next();
			double accountNumber= findBankDetailsRS.getDouble("accountNumber");
			String bankName= findBankDetailsRS.getString("bankName");
			String ifscCode= findBankDetailsRS.getString("ifscCode");
			associate.setBankDetail(new BankDetails(accountNumber, bankName, ifscCode));
		
			PreparedStatement pstmt3 = conn.prepareStatement("select * from salary where associateid=" + associateId);
			ResultSet findSalaryDetailsRS = pstmt3.executeQuery();
			findSalaryDetailsRS.next();
			double basicSalary= findSalaryDetailsRS.getDouble("basicSalary");
			double epf= findSalaryDetailsRS.getDouble("epf");
			double companyPf= findSalaryDetailsRS.getDouble("companyPf");
			double gratuity= findSalaryDetailsRS.getDouble("gratuity");
			double hra =findSalaryDetailsRS.getDouble("hra");
			double conveyenceAllowance =findSalaryDetailsRS.getDouble("conveyenceAllowance");
			double otherAllowance =findSalaryDetailsRS.getDouble("otherAllowance");
			double personalAllowance =findSalaryDetailsRS.getDouble("personalAllowance");
			double monthlyTax =findSalaryDetailsRS.getDouble("monthlyTax");
			double grossSalary =findSalaryDetailsRS.getDouble("grossSalary");
			double netSalary =findSalaryDetailsRS.getDouble("netSalary");
//			associate.setSalary(new Salary(basicSalary, epf, companyPf, gratuity));
			associate.setSalary(new Salary(basicSalary, hra, conveyenceAllowance, otherAllowance, personalAllowance, monthlyTax, epf, companyPf, gratuity, grossSalary, netSalary));
			return associate;
		}
		return null;
	}
	@Override
	public ArrayList<Associate> findAll() throws SQLException { 
		ArrayList<Associate> associates = new ArrayList<>();
		PreparedStatement pstmt1 = conn.prepareStatement("select * from associate");
		ResultSet findAssociateDetailsRS = pstmt1.executeQuery();
		while(findAssociateDetailsRS.next()){
			int associateID = findAssociateDetailsRS.getInt("associateid");
			int yearlyInvestmentUnder8oC = findAssociateDetailsRS.getInt("yearlyInvestmentUnder80C");
			String firstName = findAssociateDetailsRS.getString("firstName");
			String lastName= findAssociateDetailsRS.getString("lastName");
			String department= findAssociateDetailsRS.getString("department");
			String designation= findAssociateDetailsRS.getString("designation");
			String pancard= findAssociateDetailsRS.getString("pancard");
			String emailId= findAssociateDetailsRS.getString("emailId");
			Associate associate = new Associate(associateID, yearlyInvestmentUnder8oC, firstName, lastName, department, designation, pancard, emailId, null, null);
		
			PreparedStatement pstmt2 = conn.prepareStatement("select * from bankdetails where associateid="+associateID);
			ResultSet findBankDetailsRS = pstmt2.executeQuery();
			findBankDetailsRS.next();
			double accountNumber= findBankDetailsRS.getDouble("accountNumber");
			String bankName= findBankDetailsRS.getString("bankName");
			String ifscCode= findBankDetailsRS.getString("ifscCode");
			associate.setBankDetail(new BankDetails(accountNumber, bankName, ifscCode));
		
			PreparedStatement pstmt3 = conn.prepareStatement("select * from salary where associateid=" + associateID);
			ResultSet findSalaryDetailsRS = pstmt3.executeQuery();
			findSalaryDetailsRS.next();
			double basicSalary= findSalaryDetailsRS.getDouble("basicSalary");
			double epf= findSalaryDetailsRS.getDouble("epf");
			double companyPf= findSalaryDetailsRS.getDouble("companyPf");
			double gratuity= findSalaryDetailsRS.getDouble("gratuity");
			double hra =findSalaryDetailsRS.getDouble("hra");
			double conveyenceAllowance =findSalaryDetailsRS.getDouble("conveyenceAllowance");
			double otherAllowance =findSalaryDetailsRS.getDouble("otherAllowance");
			double personalAllowance =findSalaryDetailsRS.getDouble("personalAllowance");
			double monthlyTax =findSalaryDetailsRS.getDouble("monthlyTax");
			double grossSalary =findSalaryDetailsRS.getDouble("grossSalary");
			double netSalary =findSalaryDetailsRS.getDouble("netSalary");
//			associate.setSalary(new Salary(basicSalary, epf, companyPf, gratuity));
			associate.setSalary(new Salary(basicSalary, hra, conveyenceAllowance, otherAllowance, personalAllowance, monthlyTax, epf, companyPf, gratuity, grossSalary, netSalary));
			associates.add(associate);
		}
		return associates;
	}
	@Override
	public boolean update(Associate associate) throws SQLException {
		PreparedStatement pstmt1 = conn.prepareStatement("update salary set HRA=?, CONVEYENCEALLOWANCE=?,OTHERALLOWANCE=?, PERSONALALLOWANCE=?, MONTHLYTAX=?, GROSSSALARY=?,  NETSALARY=? where associateid=?");
		pstmt1.setDouble(1, associate.getSalary().getHra());
		pstmt1.setDouble(2, associate.getSalary().getConveyenceAllowance());
		pstmt1.setDouble(3, associate.getSalary().getOtherAllowance());
		pstmt1.setDouble(4, associate.getSalary().getPersonalAllowance());
		pstmt1.setDouble(5, associate.getSalary().getMonthlyTax());
		pstmt1.setDouble(6, associate.getSalary().getGrossSalary());
		pstmt1.setDouble(7, associate.getSalary().getNetSalary());
		pstmt1.setDouble(8, associate.getAssociateID());
		int flag = pstmt1.executeUpdate();
		if (flag > 0)	return true;
		else	return false;
	}
}