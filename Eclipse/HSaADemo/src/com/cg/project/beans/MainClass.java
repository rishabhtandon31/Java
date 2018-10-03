package com.cg.project.beans;
public class MainClass {
	public static void main(String[] args) {
		//Address address1=new Address("Pune", "Maharashtra", "India", 141444);
		//Customer customer= new Customer(101, "Satish", "Mahajan", address1);
		/*Address address2=customer.getAddress();
		System.out.println(address2.getCity());*/
		
		Customer customer=new Customer(101, "Rishabh", "Tandon", new Address("Pune", "Maharashtra", "India", 121234));
		
		System.out.println(customer.getAddress().getCity());
		
		customer.getAddress().setCity("Patiala");
		//customer.setAddress(new Address("Khanna", "Punjab", "India", 141401));
		System.out.println(customer.getAddress().getCity());
	}

}
