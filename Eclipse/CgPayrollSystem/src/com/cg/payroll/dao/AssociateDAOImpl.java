package com.cg.payroll.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.payroll.beans.Associate;

public class AssociateDAOImpl implements AssociateDAO{

	private static HashMap<Integer, Associate> associates= new HashMap<>();
	private static int ASSOCIATE_ID_COUNTER = 101;
	
	@Override
	public Associate save(Associate associate) {
		associate.setAssociateID(ASSOCIATE_ID_COUNTER++);
		associates.put(associate.getAssociateID(), associate);
		return associate;
	}

	@Override
	public Associate findOne(int associateId) {
		return associates.get(associateId);
	}

	@Override
	public ArrayList<Associate> findAll() {
		return new ArrayList<>(associates.values());
	}

}
