package com.cg.payroll.dao;

import java.util.ArrayList;

import com.cg.payroll.beans.Associate;

public interface AssociateDAO {
	Associate save(Associate associate);
	Associate findOne(int associateId);
	ArrayList<Associate> findAll();
}
