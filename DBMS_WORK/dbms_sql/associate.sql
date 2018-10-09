CREATE TABLE associate 
	(associateId number(10) NOT NULL,yearlyInvestmentUnder8oC number(10) NOT NULL);

Alter TABLE associate
	add (
		firstName varchar2(10) NOT NULL,
		lastName varchar2(10),
		department varchar2(10)	NOT NULL,
		designation varchar2(10) NOT NULL,
		pancard varchar(10),
		emailId varchar(20)
	);

ALTER TABLE associate
	add CONSTRAINT id_pk PRIMARY KEY (associateID);

Alter TABLE associate
	modify designation varchar2(20);

****************Create Sequence*************************

CREATE SEQUENCE associate_sequence
start with 101
increment by 1
minvalue 1
maxvalue 1000
nocycle;













	
Insert Into associate
	values
	(
		111111,10000,'Rishabh','Tandon','ADM','Senior Analyst','AUPL13211','rtandon@gmail.com'
	);
	
Insert Into associate
	values
	(
		111112,10000,'Rishabh','Tandon2','ADM','Senior Analyst','AUPL132112','rtandon2@gmail.com'
	);
	
Insert Into associate
	values
	(
		111113,10000,'Rishabh','Tandon3','ADM','Senior Analyst','AUPL132113','rtandon3@gmail.com'
	);
	
Insert Into associate
	values
	(
		111114,10000,'Rishabh','Tandon4','ADM','Senior Analyst','AUPL132114','rtandon4@gmail.com'
	);
	
Insert Into associate
	values
	(
		111115,10000,'Rishabh','Tandon5','ADM','Senior Analyst','AUPL132115','rtandon5@gmail.com'
	);
	
	
Insert Into associate
	values
	(
		111116,10000,'Rishabh','Tandon6','ADM','Senior Consultant','AUPL132116','rtandon6@gmail.com'
	);
	
Insert Into associate
	values
	(
		111117,10000,'Rishabh','Tandon7','ADM','Senior Consultant','AUPL132117','rtandon7@gmail.com'
	);
	
Insert Into associate
	values
	(
		111118,10000,'Rishabh','Tandon8','ADM','Senior Consultant','AUPL132118','rtandon8@gmail.com'
	);
	
Insert Into associate
	values
	(
		111119,10000,'Rishabh','Tandon9','ADM','Senior Consultant','AUPL132119','rtandon9@gmail.com'
	);
	
Insert Into associate
	values
	(
		111120,10000,'Rishabh','Tandon11','ADM','Senior Consultant','AUPL132111','rtandon1@gmail.com'
	);