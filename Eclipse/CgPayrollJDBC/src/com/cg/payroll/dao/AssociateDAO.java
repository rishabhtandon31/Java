package com.cg.payroll.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.payroll.beans.Associate;

public interface AssociateDAO {
	Associate save(Associate associate) throws SQLException;
	Associate findOne(int associateId);
	ArrayList<Associate> findAll() throws SQLException;
	boolean update(Associate associate) throws SQLException;
}
