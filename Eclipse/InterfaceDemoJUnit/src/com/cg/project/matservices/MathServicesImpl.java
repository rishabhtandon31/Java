package com.cg.project.matservices;

import com.cg.project.exceptions.InvalidNumberRangeException;

public class MathServicesImpl implements MathServices{

	@Override
	public int addNums(int n1, int n2) throws InvalidNumberRangeException{
		if(n1<0 || n2<0) throw new InvalidNumberRangeException();
		return n1+n2;
	}

	@Override
	public int subNums(int n1, int n2) throws InvalidNumberRangeException {
		if(n1<0 || n2<0) throw new InvalidNumberRangeException();
		return n1-n2;
	}

	@Override
	public int multiNums(int n1, int n2) throws InvalidNumberRangeException {
		if(n1<0 || n2<0) throw new InvalidNumberRangeException();
		return n1*n2;
	}

}
