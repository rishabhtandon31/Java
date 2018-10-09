ALTER TABLE ADDRESS
	add customerId varchar(10);
	
ALTER TABLE ADDRESS
	add Constraint FK_customerId
	FOREIGN KEY (customerId) REFERENCES customer(customerid);
	
	
ALTER TABLE POSTPAIDACCOUNT
	add (customerId varchar(10), 
	planId number);
	

ALTER TABLE POSTPAIDACCOUNT
	add (Constraint FK_ceustomerId
	FOREIGN KEY (customerId) REFERENCES customer(customerid),
	Constraint FK_planid
	FOREIGN KEY (planId) REFERENCES plan(planid)
	);
	
	
ALTER TABLE BILL
	add (planId number);

	
	
ALTER TABLE BILL
	add (constraint FK_planId1
	Foreign Key (planId) references plan(planid));