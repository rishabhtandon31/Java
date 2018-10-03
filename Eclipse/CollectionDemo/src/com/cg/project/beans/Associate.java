package com.cg.project.beans;

public class Associate implements Comparable<Associate>{
	private String name;
	private int associateId;
	public Associate(String name, int associateId) {
		super();
		this.name = name;
		this.associateId = associateId;
	}
	public Associate() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		if (associateId != other.associateId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

	@Override
	public int compareTo(Associate arg0) {
		return this.associateId- arg0.associateId;
		
	}}
